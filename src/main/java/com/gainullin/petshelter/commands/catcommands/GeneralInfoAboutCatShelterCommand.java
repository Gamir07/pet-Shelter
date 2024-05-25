package com.gainullin.petshelter.commands.catcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.cat_menu_buttons.CatShelterInfoButtons;
import com.gainullin.petshelter.service.interfaces.CatShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("GENERAL_INFO_ABOUT_CAT_SHELTER")
@RequiredArgsConstructor
public class GeneralInfoAboutCatShelterCommand implements Command {

    private final CatShelterService service;
    private final CatShelterInfoButtons buttons;
    @Override
    public SendMessage action(Update update) {
        String info = service.getInfo();
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage(chatId, info);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
