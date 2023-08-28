package com.legend.spring.jakarta_inject_api_cdi;


import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


// @Component and @Named does the same thing
// It is Just that @Component is in spring framework - import org.springframework.stereotype.Component;
// and @Named is in jakarta API - import jakarta.inject.Named;

//@Component
@Named
class BusinessService {
    DataService dataService;

    // @Autowired and @Inject does the same thing
    // It is Just that @Autowired is in spring framework - import org.springframework.beans.factory.annotation.Autowired;
    // and @Inject is in jakarta API - import jakarta.inject.Inject;
    // Setter Injection
//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }
}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }

    }
}
