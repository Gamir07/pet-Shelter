package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.DogShelterInfoButtons;
import com.gainullin.petshelter.service.interfaces.DogShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;


@Component("DOG_SHELTER_LOCATION")
@RequiredArgsConstructor
public class DogShelterLocationCommand implements Command {

    private final DogShelterInfoButtons buttons;
    private final DogShelterService service;

    /**
     *
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - возвращает текстовое сообщение об адресе и расписании работы приюта из базы данных,
     * также снова предлагает на выбор дальнейшие действия
     * @see DogShelterService #getAddress, #getWorkingHours
     */
    @Override
    public SendMessage action(String chatId) {
        String address = service.getAddress();
        String workingHours = service.getWorkingHours();
        SendMessage sendMessage = new SendMessage(chatId, address + " " + workingHours);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }


}
