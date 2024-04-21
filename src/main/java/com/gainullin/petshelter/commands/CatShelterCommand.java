package com.gainullin.petshelter.commands;

import com.gainullin.petshelter.menu_buttons.ShelterMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component("CAT_SHELTER")
@RequiredArgsConstructor
public class CatShelterCommand implements Command{

    private final ShelterMenuButtons buttons;
    @Override
    public BotApiMethod<?> action(String chatId, int messageId) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setText("Вы находитесь в меню приюта для кошек" +
                ", выберите дальнейшие действия.");
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);

        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        editMessageText.setReplyMarkup(markupInline);

        return editMessageText;
    }


}
