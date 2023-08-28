package com.legend.spring.postconstruct_and_predestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependency are ready!");
    }

    /*
     The PostConstruct annotation is used on a method that needs
     to be executed after dependency injection is done to perform any initialization
     */
    @PostConstruct
    public void intialize() {
        someDependency.getReady();
    }

    /*
      The method annotated with PreDestroy is typically used to release resources that it has been holding.
     */
    @PreDestroy
    public void cleanup() {
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}
