package com.example.testlibrary.utils.browser.scope;

import com.example.testlibrary.utils.browser.Browser;
import com.example.testlibrary.utils.browser.BrowserUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class BrowserScope extends SimpleThreadScope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);
        boolean browserHasQuit = (((Browser) o)).browserHasQuit();
        if(browserHasQuit){
            super.remove(name);
            o = super.get(name, objectFactory);
        }
        return o;
    }
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
