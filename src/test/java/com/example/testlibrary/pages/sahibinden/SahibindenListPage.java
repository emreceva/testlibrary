package com.example.testlibrary.pages.sahibinden;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.interfaces.sahibinden.SahibindenList;
import com.example.testlibrary.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@LazyComponent
public class SahibindenListPage extends BasePage implements SahibindenList {

    @FindBy(css = ".searchResultsItem")
    private List<WebElement> searchResultItems;

    @FindBy(css = ".facetedFilteredLink")
    private List<WebElement> filters;

    @FindBy(id = "advancedSorting")
    private WebElement filter;

    @FindBy(css = ".sort-order-menu li")
    private List<WebElement> sortingTypes;

    @FindBy(css = ".classified-price-container span")
    private List<WebElement> prices;


    @Override
    public boolean isAt() {
        return false;
    }

    @Override
    public SahibindenListPage clickSortingType(String sortingType) {
        browser.waitUntil(ExpectedConditions.visibilityOfAllElements(sortingTypes));
        sortingTypes.stream().filter(element -> browser.readText(element).equals(sortingType)).findFirst().ifPresent(element -> browser.click(element));
        return this;
    }

    @Override
    public SahibindenListPage verifySearchResultItem() {
        Assertions.assertTrue(searchResultListNotEmpty(), "List could not be generated.");
        return this;
    }

    @Override
    public SahibindenListPage verifyFilterFunction(String sortingType) {
        List<String> previousPricesList = new ArrayList<>();
        for(WebElement element : prices) {
            previousPricesList.add(browser.readText(element));
        }
        Assertions.assertFalse(isSortedByDescendingPrice(previousPricesList));
        clickSortingType(sortingType);
        List<String> nextPricesList = new ArrayList<>();
        for(WebElement element : prices) {
            nextPricesList.add(browser.readText(element));
        }
        Assertions.assertTrue(isSortedByDescendingPrice(nextPricesList));
        return this;
    }

    private boolean isSortedByDescendingPrice(List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }

        try {
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.compare(Integer.parseInt(s2), Integer.parseInt(s1));
                }
            });
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: One or more items in the list are not valid numbers.");
            return false;
        }
    }

    private boolean searchResultListNotEmpty() {
        while (!searchResultItems.isEmpty()) {
            browser.executeScript("document.querySelector(arguments[0],':before').click();", filters.get(filters.size()-1));
        }
        return true;
    }
}
