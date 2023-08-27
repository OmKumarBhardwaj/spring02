package com.legend.spring.game;

import org.springframework.stereotype.Component;

// Add the @Component annotation to the class to make it a Spring bean.
// Save the file and ensure that the class is within the component scan path of your Spring application.
// This allows Spring to detect and manage the bean.
@Component
public class PacMan implements GamingConsole{
    @Override
    public void up() {
        System.out.println("up");
    }

    @Override
    public void down() {
        System.out.println("down");
    }

    @Override
    public void left() {
        System.out.println("left");
    }

    @Override
    public void right() {
        System.out.println("right");
    }
}
