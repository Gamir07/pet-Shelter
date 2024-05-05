package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.SaveContactButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("SAVE_CONTACT_DETAILS")
@RequiredArgsConstructor
public class SaveContactCommand implements Command {

    private final SaveContactButtons buttons;

    //todo
    @Override
    public SendMessage action(String chatId) {
        String format = """
                Укажи свои данные для связи в следующем формате:
                Имя:
                Телефон: 8 9** ** **
                """;
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(format);
        InlineKeyboardMarkup markup = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markup);

        return sendMessage;
    }


}


