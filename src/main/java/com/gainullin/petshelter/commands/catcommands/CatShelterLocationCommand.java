package com.gainullin.petshelter.commands.catcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.cat_menu_buttons.CatShelterInfoButtons;
import com.gainullin.petshelter.service.interfaces.CatShelterService;
import com.gainullin.petshelter.service.interfaces.DogShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;

@Component("CAT_SHELTER_LOCATION")
@RequiredArgsConstructor
public class CatShelterLocationCommand implements Command {

    private final CatShelterInfoButtons buttons;
    private final CatShelterService service;
    @Value("${path.to.catShelter.roadmap}")
    private File file;

    /**
     *
     * @param update это параметр который телеграмм бот получает от пользователя при взаимодействии
     * @return SendMessage - возвращает текстовое сообщение об адресе и расписании работы приюта из базы данных,
     * также снова предлагает на выбор дальнейшие действия
     * @see DogShelterService #getAddress, #getWorkingHours
     */
    @Override
    public SendPhoto action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String address = service.getAddress();
        String workingHours = service.getWorkingHours();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setCaption(address + " " + workingHours);
        sendPhoto.setPhoto(new InputFile(file));
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendPhoto.setReplyMarkup(markupInline);
        return sendPhoto;
    }
}
