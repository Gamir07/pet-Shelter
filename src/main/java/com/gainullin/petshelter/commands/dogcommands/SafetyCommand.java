package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.DogShelterInfoButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("SAFETY")
@RequiredArgsConstructor
public class SafetyCommand implements Command {

    private final DogShelterInfoButtons buttons;

    /**
     *
     * @param chatId уникальный идентификатор чата
     * @return SendMessage - возвращает текстовое сообщение о технике безопасности при нахождении в приюте,
     * также снова предлагает на выбор дальнейшие действия
     */
    @Override
    public SendMessage action(String chatId) {
        String safetyInfo = "Находясь в приюте запрещается:\n" +
                "Самостоятельно открывать выгулы и вольеры без разрешения работника приюта.\n" +
                "Подходить близко к вольерам и гладить собак через сетку на выгулах. Животные могут быть агрессивны!\n" +
                "Кричать, размахивать руками, бегать между будками или вольерами, пугать и дразнить животных.\n" +
                "Выводить животное без разрешение волонтера.\n" +
                "Допускать близкий контакт между собаками во время выгула во избежание драк.\n" +
                "Кормить собак костями, пищевыми отходами и сладостями.\n" +
                "Отпускать животных с поводка за территорией приюта.";

        SendMessage sendMessage = new SendMessage(chatId, safetyInfo);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
