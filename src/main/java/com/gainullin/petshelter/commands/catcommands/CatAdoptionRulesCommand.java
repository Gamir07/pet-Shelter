package com.gainullin.petshelter.commands.catcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.cat_menu_buttons.CatShelterMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component("CAT_ADOPTION_RULES")
@RequiredArgsConstructor
public class CatAdoptionRulesCommand implements Command {

    private final CatShelterMenuButtons menuButtons;

    @Override
    public SendMessage action(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        String adoptionRules = """
                Для начала нужно обзавестись базовым набором котовладельца – лотком, переноской, мисками и сухим кормом.
                Прежде чем отправляться в приют за новым членом семьи, подготовьте дом к его прибытию – оборудуйте уютное
                и уединенное место, где питомец сможет спрятаться. Кошка, оказавшись в новом месте,
                наверняка будет испытывать стресс, а значит, ей будет не до обследования территории.                
                В приют с собой обязательно возьмите переноску и паспорт, во многих организация при усыновлении питомца
                составляется определенная документации.               
                Если вам еще нет 18, то необходимо взять с собой родителей или других старших родственников,
                несовершеннолетним животное не отдадут.              
                Если у вас уже есть кошка или кошки, убедитесь, что они имеют актуальные прививки.
                После вакцинации подождите минимум две недели, прежде чем брать новую кошку.
                За это время уже имеющийся у вас питомец приобретет иммунитет.
                Вакцинация очень важна, поскольку она защищает вашего питомца от возможных вирусов,
                которые может "принести" с собой новое животное.
                                
                Подумайте еще раз, действительно ли вы готовы взять кошку.
                Принимая решение о выборе кошки, вы должны знать, что животные живут до 20 лет.
                """;

        SendMessage sendMessage = new SendMessage(chatId, adoptionRules);
        InlineKeyboardMarkup markupInline = menuButtons.getInlineKeyboardButtons();
        sendMessage.setReplyMarkup(markupInline);
        return sendMessage;
    }
}
