package com.example.testlibrary.pages.sahibinden;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.enums.HeaderItemAuto360;
import com.example.testlibrary.enums.MenuItemAuto360;
import com.example.testlibrary.interfaces.sahibinden.SahibindenHeaderAuto360;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@LazyComponent
public class SahibindenHeaderAuto360Page extends BasePage implements SahibindenHeaderAuto360 {

    @FindBy(xpath = "//*[@class= 'auto-360-menu']/li/a")
    private List<WebElement> headerMenu;

    @FindBy(xpath = "//*[@class= 'auto-360-menu']/li/following::ol/li/a")
    private List<WebElement> headerMenuItems;

    private String headerMenuItemList = "//*[@class= 'auto-360-menu']/li/./following::ol/li/a[normalize-space(text()) = '%s']";

    private String headerMenuList = "//*[@class= 'auto-360-menu']/li/a[text()= '%s']";

    @Override
    public boolean isAt() {
        return false;
    }

    @Override
    public SahibindenHeaderAuto360 clickItemOnHeader(HeaderItemAuto360 menuItemAuto360) {
        WebElement itemElement = browser.findElement(By.xpath(String.format(headerMenuList, menuItemAuto360.getText())));
        browser.hoverAndClick(itemElement);
        return this;
    }

    @Override
    public SahibindenHeaderAuto360 clickItemOnMenu(MenuItemAuto360 menuItemAuto360) {
        browser.click(By.xpath(String.format(headerMenuItemList, menuItemAuto360.getText())));
        return null;
    }


}
