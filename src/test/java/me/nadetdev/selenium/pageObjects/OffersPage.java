package me.nadetdev.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    private final WebDriver driver;

    private static final By topDealLinkLocator = By.linkText("Top Deals");
    private static final By searchFieldLocator = By.xpath("//input[@type='search']");
    private static final By productNameLocator = By.cssSelector("tbody tr td:nth-child(1)");

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopDealsLink() {
        driver.findElement(topDealLinkLocator).click();
    }

    public void searchProduct(String productName) {
        driver.findElement(searchFieldLocator).sendKeys(productName);
    }

    public String getReturnedProductName() {
       return driver.findElement(productNameLocator).getText();
    }
}
