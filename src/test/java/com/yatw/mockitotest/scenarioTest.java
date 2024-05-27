package com.yatw.mockitotest;


import com.yatw.mockitotest.scenarioDAO.DatabaseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.ArgumentMatchers.argThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class scenarioTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    DatabaseService database;

    @Test
    public void duplicateScenario() throws Exception {
        RequestBuilder request = post("/scenarios/duplicate")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8");

        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();

        InOrder inOrder = Mockito.inOrder(database);
        inOrder.verify(database).save(argThat(scenario -> {
            System.out.println(scenario);
            // printed 6 times
//            Scenario{id='null', name='scenario1'}
//            Scenario{id='100', name='scenario2'}
//            Scenario{id='null', name='scenario1'}
//            Scenario{id='100', name='scenario2'}
//            Scenario{id='null', name='scenario1'}
//            Scenario{id='100', name='scenario2'}
            return true;
        }));
    }
}
