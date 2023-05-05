package com.AgencyUNN.SecretAgentOfTheUNN.service;

import com.AgencyUNN.SecretAgentOfTheUNN.config.BotMessageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class CommandManager {

    @Autowired
    BotMessageConfig botMessageConfig;

    public SendMessage sortingCommand(Message message) {
        return MessageBroker.messageGeneration(message.getChatId(), botMessageConfig.getGagMessage());
    }
}
