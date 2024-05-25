package com.gainullin.petshelter.menu_buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartMenuButtons {

    public  InlineKeyboardMarkup getInlineKeyboardButtons(){

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var catShelterButton = new InlineKeyboardButton();
        catShelterButton.setText("Приют для кошек");
        catShelterButton.setCallbackData("CAT_SHELTER");

        var dogShelterButton = new InlineKeyboardButton();
        dogShelterButton.setText("Приют для собак");
        dogShelterButton.setCallbackData("DOG_SHELTER");

        rowInLine.add(catShelterButton);
        rowInLine.add(dogShelterButton);
        rowsInLine.add(rowInLine);
        markupInline.setKeyboard(rowsInLine);
        return markupInline;
    }
}
