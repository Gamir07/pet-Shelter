package com.gainullin.petshelter.commands.dogcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.menu_buttons.dog_menu_buttons.DogShelterMenuButtons;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;

@Component("DOG_SHELTER")
@RequiredArgsConstructor
public class DogShelterCommand implements Command {

    private final DogShelterMenuButtons buttons;
    @Value("${dogShelter.dogsPhoto}")
    private File file;

    /**
     *
     * @param update уникальный идентификатор чата
     * @return SendPhoto - предлагает выбрать дальнейшие действия для взаимодейсвия с приютом для собак
     */
    @Override
    public SendPhoto action(Update update) {
        String text = "Ты находишься в меню приюта для собак" +
                ", выбери дальнейшие действия.";

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
