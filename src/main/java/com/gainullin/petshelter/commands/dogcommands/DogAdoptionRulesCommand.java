package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.dog_menu_buttons.DogShelterMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("DOG_ADOPTION_RULES")
@RequiredArgsConstructor
public class DogAdoptionRulesCommand implements Command {

    private final DogShelterMenuButtons menuButtons;

    @Override
    public SendMessage action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String adoptionRules = """
                Если вы решили забрать собаку домой, просто приехать в приют и заявить о своем желании недостаточно.
                Как правило, человеку предстоит пройти несколько этапов.
                
                1. ЗНАКОМСТВО С СОБАКОЙ.
                Важно, чтобы будущий владелец провел какое-то время с животным — узнал чуть большео его характере и повадках.                      
                На первой встрече рекомендуется узнать как можно больше о биографии собаки у волонтеров
                и сотрудников приюта: как животное попало в приют, что известно о его происхождении и прошлой жизни,
                есть ли у него хронические заболевания, поведенческие проблемы и другие особенности.
                Исходя из этого, человек может более трезво оценить свои возможности.
                
                2. ПРОВЕРКА СОТРУДНИКАМИ ПРИЮТА.
                В разных приютах требования к потенциальным владельцам подопечных могут различаться.
                Чтобы узнать о человеке подробнее, ему предлагают заполнить анкету.
                Иногда анкета — это первый этап и до знакомства с животным дело доходит, только если человек
                соответствует требованиям.     
                          
                3. ЗАКЛЮЧЕНИЕ ДОГОВОРА О ПЕРЕДАЧЕ ЖИВОТНОГО НОВОМУ ВЛАДЕЛЬЦУ.
                В документе прописывают права и обязанности владельца, указывают номер чипа питомца, если он есть.""";

        SendMessage sendMessage = new SendMessage(chatId, adoptionRules);
        InlineKeyboardMarkup markupInline = menuButtons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
