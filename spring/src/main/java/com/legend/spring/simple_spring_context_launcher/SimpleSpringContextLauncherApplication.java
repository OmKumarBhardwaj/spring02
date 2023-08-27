package com.legend.spring.simple_spring_context_launcher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/*
The @ComponentScan annotation is used in Spring to specify the packages that should be scanned for Spring components, such as beans, controllers, services, etc.
When you use @ComponentScan("com.legend.spring.game"),
it tells Spring to scan the com.legend.spring.game package and its sub-packages for components.
 */
@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }

    }
}
