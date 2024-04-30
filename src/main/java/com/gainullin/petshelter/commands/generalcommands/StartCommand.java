package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.StartMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("/start")
@RequiredArgsConstructor
public class StartCommand implements Command {

    private final StartMenuButtons menuButtons;

    /**
     *
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - возвращает приветственное сообщение и предлаегает выбрать приют
     */

    @Override
    public SendMessage action(String chatId) {
        String greeting = "Тебя приветствует телеграмм бот PetShelter, и я готов помочь тебе найти  подходящую" +
                " собаку или кошку. Чтобы пользоваться данным телеграмм ботом используй предлагаемые кнопки." +
                " На данном этапе тебе предстоит выбрать приют:";

        SendMessage sendMessage = new SendMessage(chatId,greeting);
        InlineKeyboardMarkup markupInline = menuButtons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
