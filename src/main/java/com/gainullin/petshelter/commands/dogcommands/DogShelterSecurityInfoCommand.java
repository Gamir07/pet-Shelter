package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.dog_menu_buttons.DogShelterInfoButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("DOD_SHELTER_SECURITY_INFO")
@RequiredArgsConstructor
public class DogShelterSecurityInfoCommand implements Command {

    private final DogShelterInfoButtons buttons;

    /**
     *
     * @param update уникальный идентификатор чата
     * @return SendMessage - контактные данные охраны
     */
    @Override
    public SendMessage action(Update update) {
        String info = "Контактные данные охраны: 89178612233 Михаил";
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage(chatId, info);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
