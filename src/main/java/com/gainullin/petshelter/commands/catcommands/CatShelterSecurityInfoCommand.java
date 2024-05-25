package com.gainullin.petshelter.commands.catcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.cat_menu_buttons.CatShelterInfoButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("CAT_SHELTER_SECURITY_INFO")
@RequiredArgsConstructor
public class CatShelterSecurityInfoCommand implements Command {

    private final CatShelterInfoButtons buttons;
    @Override
    public SendMessage action(Update update) {
        String info = "Контактные данные охраны: 89971597533 Андрей";
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage(chatId, info);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
