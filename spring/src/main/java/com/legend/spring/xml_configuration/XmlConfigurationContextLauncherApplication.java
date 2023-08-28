package com.legend.spring.xml_configuration;

import com.legend.spring.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            // We can do everything with xml Configuration
            // which we can do with the help of Java Annotation.
            // However, XML Configuration is not frequently used these days

            context.getBean(GameRunner.class).run();
        }

    }
}
