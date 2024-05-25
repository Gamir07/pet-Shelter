package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.entities.Owner;
import com.gainullin.petshelter.service.interfaces.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("SAVE_CONTACT_COMMAND")
@RequiredArgsConstructor
public class SaveContactCommand implements Command {

    private final OwnerService service;

    @Override
    public PartialBotApiMethod<Message> action(Update update) {
        String firstName = update.getMessage().getFrom().getFirstName();
        String correctPhoneNumber = String.format("Уважаемый %s. Мы записали твой телефон." +
                                                  " Скоро с тобой свяжется наш сотрудник", firstName);

        String chatId = update.getMessage().getChatId().toString();
        String phoneNumber = update.getMessage().getText();
        SendMessage sendMessage;
        sendMessage = new SendMessage(chatId, correctPhoneNumber);
        Owner owner = new Owner();
        owner.setChatId(chatId);
        owner.setName(firstName);
        owner.setPhoneNumber(phoneNumber);
        service.save(owner);

        return sendMessage;
    }

}
