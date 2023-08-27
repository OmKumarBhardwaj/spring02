package com.legend.spring.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
The @ComponentScan annotation is used in Spring to specify the packages that should be scanned for Spring components, such as beans, controllers, services, etc.
When you use @ComponentScan("com.legend.spring.game"),
it tells Spring to scan the com.legend.spring.game package and its sub-packages for components.
 */
@Configuration
@ComponentScan("com.legend.spring.game")
public class GamingAppLauncherApplication {

    // Created a GameRunner
    // and wired PacMan with GameRunner with the help of Parameter

    // We have used @Component to create the bean for the PacMan and GameRunner
    // @ComponentScan is used to tell Spring, which package to scan for the component

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }

    }
}
