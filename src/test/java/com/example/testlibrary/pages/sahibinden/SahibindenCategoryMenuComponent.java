package com.example.testlibrary.pages.sahibinden;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.enums.CategoryMenuItem;
import com.example.testlibrary.interfaces.sahibinden.SahibindenCategoryMenu;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@LazyComponent
public class SahibindenCategoryMenuComponent extends BasePage implements SahibindenCategoryMenu {

    @FindBy(css = "[title='Oto360']")
    private WebElement oto360;

    @Override
    public boolean isAt() {
        return false;
    }

    @Override
    public SahibindenCategoryMenu clickItemOnCategoryMenu(CategoryMenuItem categoryMenuItem) {
        switch (categoryMenuItem) {
            case OTO360 -> browser.click(oto360);
        }
        throw  new EnumConstantNotPresentException(CategoryMenuItem.class, categoryMenuItem.name());
    }
}
