package com.gainullin.petshelter.commands.catcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.cat_menu_buttons.CatShelterMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;

@Component("CAT_SHELTER")
@RequiredArgsConstructor
public class CatShelterCommand implements Command {

    private final CatShelterMenuButtons buttons;
    @Value("${catShelter.catsPhoto}")
    private File file;
    @Override
    public SendPhoto action(Update update) {
        String text = "Вы находитесь в меню приюта для кошек" +
                ", выберите дальнейшие действия.";
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(file));
        sendPhoto.setCaption(text);

        InlineKeyboardMarkup markupInline = buttons.getInlineKeyboardButtons();
        sendPhoto.setReplyMarkup(markupInline);

        return sendPhoto;
    }
}
