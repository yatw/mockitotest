package com.yatw.mockitotest.scenarioDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/scenarios")
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @PostMapping("/duplicate")
    public ResponseEntity<Object> duplicateScenario() {
        return scenarioService.duplicateScenario();
    }
}
