package com.priyakdey.noteely;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@DisplayName("NoteelyApplicationTest")
@SpringBootTest
class NoteelyApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @DisplayName("application context loads")
    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
    }

}