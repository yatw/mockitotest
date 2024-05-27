package com.yatw.mockitotest.scenarioDAO;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    public void save(Scenario scenario) {
        System.out.println("Scenario saved to database");
    }
}
