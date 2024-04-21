package com.gainullin.petshelter.menu_buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShelterMenuButtons {
    public InlineKeyboardMarkup getInlineKeyboardButtons() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var information = new InlineKeyboardButton();
        information.setText("Информация о приюте");
        information.setCallbackData("INFORMATION_ABOUT_SHELTER");

        var adoptionRules = new InlineKeyboardButton();
        adoptionRules.setText("Как взять животное из приюта");
        adoptionRules.setCallbackData("ADOPTION_RULES");

        var sendReport = new InlineKeyboardButton();
        sendReport.setText("Прислать отчет о питомце");
        sendReport.setCallbackData("SEND_REPORT");

        var callVolunteer = new InlineKeyboardButton();
        sendReport.setText("Позвать волонтера");
        sendReport.setCallbackData("CALL_VOLUNTEER");

        rowInLine.add(information);
        rowInLine.add(adoptionRules);
        rowInLine.add(sendReport);
        rowInLine.add(callVolunteer);
        rowsInLine.add(rowInLine);
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}
