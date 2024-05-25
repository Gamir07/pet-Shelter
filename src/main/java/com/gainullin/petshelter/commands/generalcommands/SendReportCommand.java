package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("SEND_REPORT")
public class SendReportCommand implements Command {
    @Override
    public SendMessage action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String firstName = update.getCallbackQuery().getFrom().getFirstName();
        String text = String.format("""
                Уважаемый %s,
                Для того чтобы отправить отчет, заполни его в следующем формате:
                id:\s
                diet:\s
                wellbeing:\s
                habits:\s
                               
                Также после отправки отчета, отправь фото питомца.\s
                 """, firstName);

        return new SendMessage(chatId, text);
    }
}
