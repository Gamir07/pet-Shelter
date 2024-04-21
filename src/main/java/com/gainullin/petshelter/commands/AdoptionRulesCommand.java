package com.gainullin.petshelter.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;


@Component("ADOPTION_RULES")
public class AdoptionRulesCommand implements Command{


    @Override
    public BotApiMethod<?> action(String chatId, int messageId) {
        EditMessageText editMessageText = new EditMessageText();
        return null;
    }
}
