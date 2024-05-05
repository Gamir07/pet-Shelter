package com.gainullin.petshelter.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public interface Command {
    PartialBotApiMethod<Message> action(String chatId);

}
