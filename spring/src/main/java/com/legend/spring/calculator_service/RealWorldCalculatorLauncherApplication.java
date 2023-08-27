package com.legend.spring.calculator_service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@ComponentScan
public class RealWorldCalculatorLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(RealWorldCalculatorLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }

    }
}
