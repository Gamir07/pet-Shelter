package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.StartMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;

@Component("/start")
@RequiredArgsConstructor
public class StartCommand implements Command {

    private final StartMenuButtons menuButtons;
    @Value("${path.to.startCommandPhoto}")
    private File chatPhoto;

    /**
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - возвращает приветственное сообщение и предлаегает выбрать приют
     */

    @Override
    public SendPhoto action(String chatId) {
        String greeting = "Тебя приветствует телеграмм бот PetShelter, и я готов помочь тебе найти  подходящую" +
                " собаку или кошку. Чтобы пользоваться данным телеграмм ботом используй предлагаемые кнопки." +
                " На данном этапе тебе предстоит выбрать приют:";

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(chatPhoto));
        sendPhoto.setCaption(greeting);
        InlineKeyboardMarkup markupInline = menuButtons.getInlineKeyboardButtons();
        sendPhoto.setReplyMarkup(markupInline);
        return sendPhoto;
    }
}
