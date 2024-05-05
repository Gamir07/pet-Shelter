package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.DogShelterInfoButtons;
import com.gainullin.petshelter.service.interfaces.DogShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;


@Component("DOG_SHELTER_LOCATION")
@RequiredArgsConstructor
public class DogShelterLocationCommand implements Command {

    private final DogShelterInfoButtons buttons;
    private final DogShelterService service;
    @Value("${path.to.dogShelter.roadmap}")
    private File file;

    /**
     *
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - возвращает текстовое сообщение об адресе и расписании работы приюта из базы данных,
     * также снова предлагает на выбор дальнейшие действия
     * @see DogShelterService #getAddress, #getWorkingHours
     */
    @Override
    public SendPhoto action(String chatId) {
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
