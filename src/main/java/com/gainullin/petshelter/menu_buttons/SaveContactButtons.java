package com.gainullin.petshelter.menu_buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveContactButtons {
    public InlineKeyboardMarkup getInlineKeyboardButtons() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var send = new InlineKeyboardButton();
        send.setText("Отправить данные");
        send.setCallbackData("SAVE_COMMAND");

        rowInLine.add(send);
        rowsInLine.add(rowInLine);
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}
