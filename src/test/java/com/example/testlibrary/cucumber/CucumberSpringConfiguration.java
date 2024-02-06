package com.example.testlibrary.cucumber;

import com.example.testlibrary.TestlibraryApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestlibraryApplication.class)
@SpringBootTest
public class CucumberSpringConfiguration {
}
