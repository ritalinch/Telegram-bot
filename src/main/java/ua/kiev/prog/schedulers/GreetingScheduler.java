package ua.kiev.prog.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.kiev.prog.bot.ChatBot;

@Component
public class GreetingScheduler {

    private final ChatBot chatBot;

    public GreetingScheduler(ChatBot chatBot) {
        this.chatBot = chatBot;
    }

    @Scheduled(fixedDelay = 86400000)
    public void greet() {
        chatBot.birthDayBroadcast();
    }

}
