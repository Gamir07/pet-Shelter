package com.gainullin.petshelter.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component("/start")
public class StartCommand{
    private final String greeting = "Тебя приветствует телеграмм бот PetShelter, и я готов помочь найти тебе подходящую" +
            " собаку или кошку. На данном этапе тебе предстоит выбрать приют:";


    public SendMessage action(String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(greeting);
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
        sendMessage.setReplyMarkup(markupInline);

        return sendMessage;
    }
}
