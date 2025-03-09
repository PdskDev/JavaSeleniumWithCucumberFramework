package me.nadetdev.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class TestContextSetup {
    public static WebDriver driver;
    public static String landingPageProductName;
    public static String offerPageProductName;
    public final String LANDING_PAGE_URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
    public final String OFFERS_PAGE_URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
    public final String CHROME_DRIVER_PATH = "src/test/resources/chrome/chromedriver.exe";

    public TestContextSetup() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        TestContextSetup.driver = driver;
    }

    public String getLandingPageProductName() {
        return landingPageProductName;
    }

    public void setLandingPageProductName(String landingPageProductName) {
        TestContextSetup.landingPageProductName = landingPageProductName;
    }

    public String getOfferPageProductName() {
        return offerPageProductName;
    }

    public void setOfferPageProductName(String offerPageProductName) {
        TestContextSetup.offerPageProductName = offerPageProductName;
    }

    public String getLANDING_PAGE_URL() {
        return LANDING_PAGE_URL;
    }

    public String getOFFERS_PAGE_URL() {
        return OFFERS_PAGE_URL;
    }

    public void initBrowserDriver(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        this.setDriver(new ChromeDriver());
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, landingPageProductName, offerPageProductName);
    }

    @Override
    public String toString() {
        return "TestContextSetup{" +
                "driver=" + driver +
                ", landingPageProductName='" + landingPageProductName + '\'' +
                ", offerPageProductName='" + offerPageProductName + '\'' +
                '}';
    }
}
