package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class DefaultCommand implements Command {
    @Override
    public SendMessage action(String chatId) {
        return new SendMessage(chatId, "Команда не распознана");
    }
}
