package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.DogShelterMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("DOG_SHELTER")
@RequiredArgsConstructor
public class DogShelterCommand implements Command {

    private final DogShelterMenuButtons buttons;

    /**
     *
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - предлагает выбрать дальнейшие действия для взаимодейсвия с приютом для собак
     */
    @Override
    public SendMessage action(String chatId) {
        String text = "Ты находишься в меню приюта для собак" +
                ", выбери дальнейшие действия.";

        SendMessage sendMessage = new SendMessage(chatId, text);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);

        return sendMessage;
    }


}
