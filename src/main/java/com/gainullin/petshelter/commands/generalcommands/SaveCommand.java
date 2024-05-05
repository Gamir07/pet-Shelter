package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component("SAVE_COMMAND")
public class SaveCommand implements Command {

    @Override
    public SendMessage action(String chatId) {
        String save = "Данные сохранены";

        SendMessage sendMessage = new SendMessage(chatId,save);

        return sendMessage;
    }
}
