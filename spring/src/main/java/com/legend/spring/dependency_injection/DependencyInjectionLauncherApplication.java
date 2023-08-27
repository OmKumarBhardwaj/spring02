package com.legend.spring.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


// YourBusinessClass
// Dependency 1
// Dependency 2

@Component
class YourBusinessClass {

    // This is called field injection
    // As soon as we put autowired on a field
    // Spring Automatically do field Injection
//     @Autowired
//     Dependency1 dependency1;
//
//     @Autowired
//     Dependency2 dependency2;



    Dependency1 dependency1;

    Dependency2 dependency2;

//    Now we will Learn Constructor Dependency Injection
//    Done through Constructor
//    @Autowired is not mandatory for Constructor Injection

    // @Autowired // This is not mandatory for Constructor Injection
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Dependency Injection :- setDependency 1 and setDependency 2");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }


//    Now we will Learn Setter Dependency Injection
//    Done through Setters

//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Dependency Injection :- setDependency 1");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Dependency Injection :- setDependency 2");
//        this.dependency2 = dependency2;
//    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }

    }
}
