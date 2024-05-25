package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.StartMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;

@Component("/start")
@RequiredArgsConstructor
public class StartCommand implements Command {

    private final StartMenuButtons menuButtons;
    @Value("${path.to.greetingPhoto}")
    private File greetingPhoto;

    /**
     * @param update это параметр который телеграмм бот получает от пользователя при взаимодействии
     * @return SendPhoto - возвращает приветственное сообщение, и приветственное фото и предлагает выбрать приют
     */

    @Override
    public SendPhoto action(Update update) {
        User user = update.getMessage().getFrom();
        String firstName = user.getFirstName();
        String chatId = update.getMessage().getChatId().toString();
        String greeting = String.format("Привет %s. Это телеграмм бот PetShelter, и я готов помочь тебе найти  подходящую" +
                " собаку или кошку. Чтобы пользоваться данным телеграмм ботом используй предлагаемые кнопки." +
                " На данном этапе тебе предстоит выбрать приют:",firstName);

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(greetingPhoto));
        sendPhoto.setCaption(greeting);
        InlineKeyboardMarkup markupInline = menuButtons.getInlineKeyboardButtons();
        sendPhoto.setReplyMarkup(markupInline);
        return sendPhoto;
    }
}
