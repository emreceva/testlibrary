package com.example.testlibrary.utils.browser.scope;

import com.example.testlibrary.utils.browser.Browser;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

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
