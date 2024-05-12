package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class DefaultCommand implements Command {
    @Override
    public SendMessage action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();

        return new SendMessage(chatId, "Команда не распознана");
    }
}
