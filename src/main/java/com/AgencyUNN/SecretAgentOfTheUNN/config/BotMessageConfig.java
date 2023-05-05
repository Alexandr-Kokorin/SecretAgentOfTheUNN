package com.AgencyUNN.SecretAgentOfTheUNN.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotMessageConfig {

    private String UnidentifiedMessage = """
            Что-то странное я получил...
            Не надо кидаться подобной бякой!""";
    private String GagMessage = "Здесь пока ничего нет, но скоро обязательно всё появится.";
    private String StartMessage = """
            Привет! Я помогу тебе сделать твою жизнь чуточку проще. Тебе больше не нужно заходить на портал и что-то там искать, всю информацию ты сможешь получить здесь!
            
            Для того, чтобы начать, пришли мне сообщение вот такого вида со своими данными:""";
    private String AuthorizationExample = """
            #Авторизация
            Логин: s21380208
            Пароль: qwerty123""";
    private String ConfirmationDataReceipt = """
            Отлично, данные получены!
            Произвожу авторизацию...""";
    private String LoginCompleted = "Вход успешно выполнен! Теперь ты можешь получать информацию через меня.";
    private String LoginFailed = "Что-то пошло не так во время входа. Пожалуйста проверь свои данные и пришли мне их снова.";
}
