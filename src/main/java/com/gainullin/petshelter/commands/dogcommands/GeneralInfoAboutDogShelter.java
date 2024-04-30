package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.DogShelterInfoButtons;
import com.gainullin.petshelter.service.interfaces.DogShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("GENERAL_INFO_ABOUT_DOG_SHELTER")
@RequiredArgsConstructor
public class GeneralInfoAboutDogShelter implements Command {

    private final DogShelterService service;
    private final DogShelterInfoButtons buttons;

    /**
     *
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - возвращает общую информация о приюте из базы данных, также снова предлагает на выбор дальнейшие действия
     * @see com.gainullin.petshelter.repositories.DogRepository getInfo
     */

    @Override
    public SendMessage action(String chatId) {
        String info = service.getInfo();
        SendMessage sendMessage = new SendMessage(chatId, info);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
