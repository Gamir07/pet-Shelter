package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component("SAVE_CONTACT_DETAILS")
@RequiredArgsConstructor
public class SaveContactCommand implements Command {

    @Override
    public PartialBotApiMethod<Message> action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String firstName = update.getCallbackQuery().getFrom().getFirstName();
        String format = String.format("""
                Уважаемый %s
                Укажи свой номер телефона для связи в следующем формате:
                8(9**)****
                """, firstName);
        return new SendMessage(chatId, format);
    }


}


