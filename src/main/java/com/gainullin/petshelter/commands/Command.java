package com.gainullin.petshelter.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.Serializable;

@Component
public interface Command {
    BotApiMethod<?> action(String chatId, int messageId);

}
