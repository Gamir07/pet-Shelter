package com.gainullin.petshelter.commands.generalcommands;

import com.gainullin.petshelter.commands.Command;
import com.gainullin.petshelter.entities.PetReport;
import com.gainullin.petshelter.service.implementations.PetReportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("SAVE_REPORT")
@RequiredArgsConstructor
public class SaveReportCommand implements Command {
    private final PetReportServiceImpl service;

    public SendMessage action(Update update) {
        String successfulReport = "Отчет сохранен";
        String unSuccessfulReport = "Отчет заполнен неверно ";
        String reportPattern = """
                id:\\s(\\d*)
                diet:\\s(\\w*)
                wellbeing:\\s(\\w*)
                habits:\\s(\\w*)
                """;
        String text = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();
        Matcher matcher = Pattern.compile(reportPattern).matcher(text);
        if (matcher.matches()) {
            PetReport report = new PetReport();
            report.setId(Long.parseLong(matcher.group(1)));
            report.setDiet(matcher.group(2));
            report.setWellbeing(matcher.group(3));
            report.setHabits(matcher.group(4));
            report.setDateOfReport(LocalDateTime.now());
            service.saveReport(report);
            return new SendMessage(chatId, successfulReport);
        } else {
            return new SendMessage(chatId, unSuccessfulReport);
        }

    }
}
