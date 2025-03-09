package me.nadetdev.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private final WebDriver driver;
    private final By searchFieldLocator = By.xpath("//input[@type='search']");
    private final By productNameLocator = By.cssSelector("h4.product-name");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String nameOfProduct) {
        driver.findElement(searchFieldLocator).sendKeys(nameOfProduct);
    }

    public String getProductName() {
        return this.extractProductName(driver.findElement(productNameLocator).getText());
    }

    private String extractProductName(String productName) {
        return productName.split("-")[0].trim();
    }
}
