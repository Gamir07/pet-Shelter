package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.entities.Owner;
import com.gainullin.petshelter.menu_buttons.DogShelterInfoButtons;
import com.gainullin.petshelter.service.implementations.OwnerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component("SAVE_CONTACT_DETAILS")
@RequiredArgsConstructor
public class SaveContactCommand implements Command {

    private final DogShelterInfoButtons buttons;
    private final OwnerServiceImpl service;

    //todo
    @Override
    public SendMessage action(String chatId) {
        String contact = "Данные сохранены";
        SendMessage sendMessage = new SendMessage(chatId, contact);
        Owner owner = new Owner();
        owner.setChatId(chatId);
        service.save(owner);

        return sendMessage;
    }


    }


