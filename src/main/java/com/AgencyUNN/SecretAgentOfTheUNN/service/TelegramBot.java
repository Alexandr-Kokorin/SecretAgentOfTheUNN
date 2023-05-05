package com.AgencyUNN.SecretAgentOfTheUNN.service;

import com.AgencyUNN.SecretAgentOfTheUNN.config.BotConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Log4j
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private BotConfig botConfig;
    @Autowired
    private MessageBroker messageBroker;

    @PostConstruct
    private void init() {
        messageBroker.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        messageBroker.sortingMessages(update);
        log.debug("id: " + update.getMessage().getChatId() + ", text: " + update.getMessage().getText());
        /*String text = update.getMessage().getText();
        Long id = update.getMessage().getFrom().getId();
        log.debug("id: " + id + ", text: " + text);
        if ((text.equals("Саш") || text.equals("Сашунь") || text.equals("Малыш") || text.equals("❤")) && id == 1336719525) { //1336719525
            sendMessage(SendMessage.builder().chatId(id.toString()).text("Я тебя очень люблю, малыш❤❤❤").build());
        }
        else sendMessage(SendMessage.builder().chatId(id.toString()).text(text).build());*/
    }

    public void sendMessage(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Error sending the message!");
        }
    }
}
