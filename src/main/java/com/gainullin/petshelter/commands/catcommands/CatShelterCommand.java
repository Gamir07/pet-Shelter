package com.gainullin.petshelter.commands.catcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.CatShelterMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("CAT_SHELTER")
@RequiredArgsConstructor
public class CatShelterCommand implements Command {

    private final CatShelterMenuButtons buttons;
    @Override
    public SendMessage action(String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Вы находитесь в меню приюта для кошек" +
                ", выберите дальнейшие действия.");
        sendMessage.setChatId(chatId);

        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);

        return sendMessage;
    }
}
