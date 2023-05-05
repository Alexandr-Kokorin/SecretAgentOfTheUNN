package com.AgencyUNN.SecretAgentOfTheUNN.service;

import com.AgencyUNN.SecretAgentOfTheUNN.config.BotMessageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandManager {

    @Autowired
    BotMessageConfig botMessageConfig;

    public List<SendMessage> sortingCommand(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        switch (message.getText()) {
            case "/start" -> sendMessages = startCommandProcessing(message);
            case "/my_data" -> sendMessages = myDataCommandProcessing(message);
            case "/change_data" -> sendMessages = changeDataCommandProcessing(message);
            case "/get_class_schedule" -> sendMessages = getClassScheduleCommandProcessing(message);
            case "/get_exam_schedule" -> sendMessages = getExamScheduleCommandProcessing(message);
            case "/get_unread_news_feed" -> sendMessages = getUnreadNewsFeedCommandProcessing(message);
            case "/get_unread_messages" -> sendMessages = getUnreadMessagesCommandProcessing(message);
            default -> sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getUnidentifiedMessage()));
        }
        return sendMessages;
    }

    private List<SendMessage> startCommandProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getStartMessage()));
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getAuthorizationExample()));
        return sendMessages;
    }

    private List<SendMessage> myDataCommandProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getGagMessage()));
        return sendMessages;
    }

    private List<SendMessage> changeDataCommandProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getGagMessage()));
        return sendMessages;
    }

    private List<SendMessage> getClassScheduleCommandProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getGagMessage()));
        return sendMessages;
    }

    private List<SendMessage> getExamScheduleCommandProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getGagMessage()));
        return sendMessages;
    }

    private List<SendMessage> getUnreadNewsFeedCommandProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getGagMessage()));
        return sendMessages;
    }

    private List<SendMessage> getUnreadMessagesCommandProcessing(Message message) {
        List<SendMessage> sendMessages = new ArrayList<>();
        sendMessages.add(MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getGagMessage()));
        return sendMessages;
    }

}
