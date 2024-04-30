package com.gainullin.petshelter.menu_buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class DogShelterMenuButtons {
    public InlineKeyboardMarkup getInlineKeyboardButtons() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();

        var information = new InlineKeyboardButton();
        information.setText("Информация о приюте для собак");
        information.setCallbackData("INFORMATION_ABOUT_DOG_SHELTER");

        var adoptionRules = new InlineKeyboardButton();
        adoptionRules.setText("Как взять собаку из приюта");
        adoptionRules.setCallbackData("ADOPTION_RULES");

        var sendReport = new InlineKeyboardButton();
        sendReport.setText("Прислать отчет о питомце");
        sendReport.setCallbackData("SEND_REPORT");

        var callVolunteer = new InlineKeyboardButton();
        callVolunteer.setText("Позвать волонтера");
        callVolunteer.setCallbackData("CALL_VOLUNTEER");

        rowInLine.add(information);
        rowInLine.add(adoptionRules);
        rowInLine2.add(sendReport);
        rowInLine2.add(callVolunteer);
        rowsInLine.add(rowInLine);
        rowsInLine.add(rowInLine2);
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}
