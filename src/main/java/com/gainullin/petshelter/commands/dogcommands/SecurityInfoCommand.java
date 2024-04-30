package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.DogShelterInfoButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("SECURITY_INFO")
@RequiredArgsConstructor
public class SecurityInfoCommand implements Command {
    private final DogShelterInfoButtons buttons;

    /**
     *
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - контактные данные охраны
     */
    @Override
    public SendMessage action(String chatId) {
        String info = "Контактные данные охраны: 89178612233 Михаил";
        SendMessage sendMessage = new SendMessage(chatId, info);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
