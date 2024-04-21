package com.gainullin.petshelter.configuration;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.commands.StartCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final Map<String, Command> commands;
    private final StartCommand startCommand;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String chatId = update.getMessage().getChatId().toString();
            BotApiMethod action1 = startCommand.action(chatId);
            executeMessage(action1);

        } else if (update.hasCallbackQuery()) {
            for (Map.Entry<String, Command> entry : commands.entrySet()) {
                String callBackData = update.getCallbackQuery().getData();
                int messageID = update.getCallbackQuery().getMessage().getMessageId();
                String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
                if (update.hasCallbackQuery()) {
                    if (entry.getKey().equals(callBackData)) {
                        BotApiMethod action = entry.getValue().action(chatId, messageID);
                        executeMessage(action);
                    }
                }
            }
        }

    }

    private void executeMessage(BotApiMethod sendMessage) {
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

