package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.dog_menu_buttons.DogShelterInfoButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;


@Component("INFORMATION_ABOUT_DOG_SHELTER")
@RequiredArgsConstructor
public class InfoAboutDogShelterCommand implements Command {

    private final DogShelterInfoButtons buttons;

    @Override
    public SendMessage action(Update update) {
        String info = "Какую информацию ты желаешь получить";
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage(chatId, info);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);

        return sendMessage;
    }
}
