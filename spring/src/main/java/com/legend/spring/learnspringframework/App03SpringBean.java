package com.legend.spring.learnspringframework;

import com.legend.spring.game.GameRunner;
import com.legend.spring.game.GamingConsole;
import com.legend.spring.game.PacMan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App03SpringBean {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }

    }
}
