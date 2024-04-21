package com.gainullin.petshelter.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

import java.io.Serializable;

@Component("CALL_VOLUNTEER")
public class CallVolunteerCommand implements Command{
    @Override
    public BotApiMethod<?> action(String chatId, int messageId) {
        return null;
    }
}
