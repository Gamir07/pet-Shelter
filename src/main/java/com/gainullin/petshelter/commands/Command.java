package com.gainullin.petshelter.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public interface Command {
    PartialBotApiMethod<Message> action(Update update);

}
