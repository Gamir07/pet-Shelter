package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.service.interfaces.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("CALL_VOLUNTEER")
@RequiredArgsConstructor
public class CallVolunteerCommand implements Command {
    private final OwnerService service;

    @Override
    public ForwardMessage action(Update update) {
        String fromChatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
        ForwardMessage message = new ForwardMessage();
        message.setChatId(service.findVolunteer());
        message.setFromChatId(fromChatId);
        message.setMessageId(messageId);
        message.setDisableNotification(true);

        return message;
    }
}
