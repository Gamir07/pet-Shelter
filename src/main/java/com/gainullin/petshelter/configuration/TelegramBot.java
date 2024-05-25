package com.gainullin.petshelter.configuration;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.commands.generalcommands.DefaultCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
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
     *
     * @param update это параметр который телеграмм бот получает от пользователя при взаимодействии
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            PartialBotApiMethod<Message> action = parseText(update);
            log.info("Message from text: [{}]", text);
            execution(action);

        } else if (update.hasCallbackQuery()) {
            String callBackData = update.getCallbackQuery().getData();
            PartialBotApiMethod<Message> action = commands.getOrDefault(callBackData, new DefaultCommand()).action(update);
            log.info("Message from callback: [{}]", callBackData);
            execution(action);
        }
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendPhoto(SendPhoto sendPhoto) {
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void execution(PartialBotApiMethod<Message> action) {
        if (action instanceof SendPhoto) {
            sendPhoto((SendPhoto) action);
        } else if (action instanceof SendMessage) {
            sendMessage((SendMessage) action);
        }
    }

    private PartialBotApiMethod<Message> parseText(Update update) {
        String report = """
                id:\\s(\\d*)
                diet:\\s(\\w*)
                wellbeing:\\s(\\w*)
                habits:\\s(\\w*)
                """;
        String phoneNumber = "8\\(9\\d{2}\\)\\d{7}";
        String text = update.getMessage().getText();
        if ("/start".equals(text)) {
            return commands.get(text).action(update);
        } else if (text.matches(report)) {
            return commands.get("SAVE_REPORT").action(update);
        } else if (text.matches(phoneNumber)) {
            return commands.get("SAVE_CONTACT_COMMAND").action(update);
        } else {
            return commands.getOrDefault(text, new DefaultCommand()).action(update);
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


