package com.legend.spring.learnspringframework;

import com.legend.spring.game.GameRunner;
import com.legend.spring.game.GamingConsole;
import com.legend.spring.game.PacMan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App03SpringBean {

    @Bean
    public GamingConsole game() {
        return new PacMan();
    }

    // Created a GameRunner
    // and wired PacMan with GameRunner with the help of Parameter
    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App03SpringBean.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }

    }
}
