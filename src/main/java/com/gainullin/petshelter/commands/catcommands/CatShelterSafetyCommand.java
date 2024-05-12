package com.gainullin.petshelter.commands.catcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.cat_menu_buttons.CatShelterInfoButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("CAT_SHELTER_SAFETY")
@RequiredArgsConstructor
public class CatShelterSafetyCommand implements Command {
    private final CatShelterInfoButtons buttons;

    /**
     * @param update уникальный идентификатор чата
     * @return SendMessage - возвращает текстовое сообщение о технике безопасности при нахождении в приюте,
     * также снова предлагает на выбор дальнейшие действия
     */
    @Override
    public SendMessage action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String safetyInfo = """
                Находясь в приюте запрещается:
                Самостоятельно открывать выгулы и вольеры без разрешения работника приюта
                Кормить животных.Этим Вы можете спровоцировать драку.Угощения разрешены только постоянным опекунам и волонтерам,
                во время прогулок с животными на поводке.Оставлять после себя мусор на территории приюта и прилегающей территории.
                Животные могут быть агрессивны!
                Кричать, размахивать руками, бегать между вольерами, пугать и дразнить животных.
                Посещение приюта для детей дошкольного и младшего школьного возраста без сопровождения взрослых.
                Нахождение на территории приюта детей среднего и старшего школьного возраста без сопровождения взрослых
                или письменной справки - разрешения от родителей или законных представителей.
                Самостоятельно заходить в кошатник без разрешения сотрудников приюта.
                Посещение приюта в состоянии алкогольного, наркотического опьянения.""";

        SendMessage sendMessage = new SendMessage(chatId, safetyInfo);
        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
