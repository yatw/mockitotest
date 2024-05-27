package com.yatw.mockitotest.scenarioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ScenarioService {

    @Autowired
    private DatabaseService database;

    public ResponseEntity<Object> duplicateScenario() {

        Scenario scenario1 = new Scenario(null, "scenario1");
        Scenario scenario2 = new Scenario("100", "scenario2");

        database.save(scenario1);
        database.save(scenario2);
        return ResponseEntity.ok().build();
    }
}
