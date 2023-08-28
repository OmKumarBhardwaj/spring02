package com.legend.spring.calculator_service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// We can use Repository instead of @Component
// Because it is a Specialization of @Component
// Used to denote That a class deals with retrieving data and updating data.

//@Component
@Repository
public class MySQLDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
