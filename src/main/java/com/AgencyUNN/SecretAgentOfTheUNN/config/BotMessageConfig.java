package com.AgencyUNN.SecretAgentOfTheUNN.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotMessageConfig {

    private String UnidentifiedMessage = "Что-то странное я получил...\nНе надо кидаться подобной бякой!";
    private String GagMessage = "Здесь пока ничего нет. Идите лесом!";
}
