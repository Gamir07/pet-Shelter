package com.gainullin.petshelter.menu_buttons.cat_menu_buttons;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatShelterInfoButtons {

    public InlineKeyboardMarkup getInlineKeyboardButtons() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine3 = new ArrayList<>();

        var generalInfo = new InlineKeyboardButton();
        generalInfo.setText("Общая информация о приюте для кошек");
        generalInfo.setCallbackData("GENERAL_INFO_ABOUT_CAT_SHELTER");

        var location = new InlineKeyboardButton();
        location.setText("Расписание работы, адрес и схема проезда");
        location.setCallbackData("CAT_SHELTER_LOCATION");

        var securityInfo = new InlineKeyboardButton();
        securityInfo.setText("Контактные данные охраны");
        securityInfo.setCallbackData("CAT_SHELTER_SECURITY_INFO");

        var safety = new InlineKeyboardButton();
        safety.setText("Рекомендации о технике безопасности");
        safety.setCallbackData("CAT_SHELTER_SAFETY");

        var saveContactDetails = new InlineKeyboardButton();
        saveContactDetails.setText("Оставить контактные данные для связи");
        saveContactDetails.setCallbackData("SAVE_CONTACT_DETAILS");

        var callVolunteer = new InlineKeyboardButton();
        callVolunteer.setText("Позвать волонтера");
        callVolunteer.setCallbackData("CALL_VOLUNTEER");

        rowInLine.add(generalInfo);
        rowInLine.add(location);
        rowInLine2.add(securityInfo);
        rowInLine2.add(safety);
        rowInLine3.add(saveContactDetails);
        rowInLine3.add(callVolunteer);
        rowsInLine.add(rowInLine);
        rowsInLine.add(rowInLine2);
        rowsInLine.add(rowInLine3);
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}
