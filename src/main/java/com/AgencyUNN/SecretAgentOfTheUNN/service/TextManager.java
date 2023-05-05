package com.AgencyUNN.SecretAgentOfTheUNN.service;

import com.AgencyUNN.SecretAgentOfTheUNN.config.BotMessageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Component
public class TextManager {

    @Autowired
    BotMessageConfig botMessageConfig;

    public List<SendMessage> sortingText(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        if (message.getText().contains("#Авторизация") || message.getText().contains("Логин:") || message.getText().contains("Пароль:")) {
            sendMessages = authorizationProcessing(message);
        } else sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getUnidentifiedMessage()));
        return sendMessages;
    }

    private List<SendMessage> authorizationProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getConfirmationDataReceipt()));
        //...
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getLoginCompleted()));
        return sendMessages;
    }
}
