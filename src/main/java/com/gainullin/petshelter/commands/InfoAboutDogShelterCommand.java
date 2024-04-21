package com.gainullin.petshelter.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;


@Component("INFORMATION_ABOUT_DOG_SHELTER")
public class InfoAboutDogShelterCommand implements Command {
    private final String info = "Приют ШАРИК - это приют для бездомных собак в Южном округе г. Москвы. В нем живет почти 2500 собак." +
            " Большие и маленькие, пушистые и гладкие, веселые и задумчивые - и на всех одна большая мечта - встретить своего Человека и найти Дом.";

    @Override
    public BotApiMethod<?> action(String chatId, int messageId) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setText(info);
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);

        return editMessageText;
    }
}
