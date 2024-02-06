package com.example.testlibrary.context;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ScenarioScope
public class ScenarioRunContext {

    private final Map<String, Object> runContext = new ConcurrentHashMap<String, Object>();

    public void setProperty(String key, Object value) {
        if (value != null) {
            runContext.put(key, value);
        }
    }

    public <T> T getProperty(String key) {
        return (T) runContext.get(key);
    }

    public <T> T getPropertyOrDefault(String key, T defaultValue) {
        return (T) runContext.computeIfAbsent(key, k-> defaultValue);
    }

    public static class ContextProperties {

        public interface Common {

            String SCENARIO_NAME = "SCENARIO_NAME";
        }

        public interface Result {

            String FACTORIAL_NUMBER = "FACTORIAL_NUMBERS";

        }

    }
}
