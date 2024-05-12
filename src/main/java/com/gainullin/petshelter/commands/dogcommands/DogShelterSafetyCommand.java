package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.dog_menu_buttons.DogShelterInfoButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("DOG_SHELTER_SAFETY")
@RequiredArgsConstructor
public class DogShelterSafetyCommand implements Command {

    private final DogShelterInfoButtons buttons;

    /**
     *
     * @param update уникальный идентификатор чата
     * @return SendMessage - возвращает текстовое сообщение о технике безопасности при нахождении в приюте,
     * также снова предлагает на выбор дальнейшие действия
     */
    @Override
    public SendMessage action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String safetyInfo = """
                Находясь в приюте запрещается:
                Самостоятельно открывать выгулы и вольеры без разрешения работника приюта.
                Подходить близко к вольерам и гладить собак через сетку на выгулах. Животные могут быть агрессивны!
                Кричать, размахивать руками, бегать между будками или вольерами, пугать и дразнить животных.
                Выводить животное без разрешение волонтера.
                Допускать близкий контакт между собаками во время выгула во избежание драк.
                Кормить собак костями, пищевыми отходами и сладостями.
                Отпускать животных с поводка за территорией приюта.""";

        SendMessage sendMessage = new SendMessage(chatId, safetyInfo);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
