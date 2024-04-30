package com.gainullin.petshelter.configuration;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.commands.generalcommands.DefaultCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final Map<String, Command> commands;


    /**
     * Метод обрабатывает текстовое сообщение или взаимодейтвие с кнопкой, и исполняет соответствующую команду
     * @param update  это параметр который телеграмм бот получает от пользователя при взаимодействии
     */
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();
            SendMessage action = commands.getOrDefault(text, new DefaultCommand()).action(chatId);
            log.info("Message: [{}]", text);
            sendMessage(action);

        } else if (update.hasCallbackQuery()) {
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            String callBackData = update.getCallbackQuery().getData();
            SendMessage action = commands.getOrDefault(callBackData, new DefaultCommand()).action(chatId);
            log.info("Message from callback: [{}]", callBackData);
            sendMessage(action);
        }
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}


