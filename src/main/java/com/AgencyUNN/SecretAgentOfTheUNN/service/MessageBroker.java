package com.AgencyUNN.SecretAgentOfTheUNN.service;

import com.AgencyUNN.SecretAgentOfTheUNN.config.BotMessageConfig;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j
public class MessageBroker {

    private TelegramBot telegramBot;
    @Autowired
    private CommandManager commandManager;
    @Autowired
    private TextManager textManager;
    @Autowired
    BotMessageConfig botMessageConfig;

    public void registerBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void sortingMessages(Update update) {
        Message message = update.getMessage();
        if (message != null) {
            List<SendMessage> sendMessages = new ArrayList<>();
            if (message.isCommand()) {
                sendMessages = commandManager.sortingCommand(message);
            } else if (message.hasText()) {
                sendMessages = textManager.sortingText(message);
            } else {
                sendMessages.add(messageGeneration(message.getChatId(), botMessageConfig.getUnidentifiedMessage()));
            }
            for (SendMessage sendMessage: sendMessages) {
                telegramBot.sendMessage(sendMessage);
            }
        } else {
            log.error("Unsupported massage type!");
        }
    }

    public static SendMessage messageGeneration(Long id, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(id);
        sendMessage.setText(text);
        return sendMessage;
    }
}
