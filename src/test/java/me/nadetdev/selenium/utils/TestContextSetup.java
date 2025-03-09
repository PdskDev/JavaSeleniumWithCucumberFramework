package me.nadetdev.selenium.utils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class TestContextSetup {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;

    public TestContextSetup() {
    }

    public TestContextSetup(WebDriver driver) {
        this.driver = driver;
    }

    public TestContextSetup(WebDriver driver, String landingPageProductName, String offerPageProductName) {
        this.driver = driver;
        this.landingPageProductName = landingPageProductName;
        this.offerPageProductName = offerPageProductName;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getLandingPageProductName() {
        return landingPageProductName;
    }

    public void setLandingPageProductName(String landingPageProductName) {
        this.landingPageProductName = landingPageProductName;
    }

    public String getOfferPageProductName() {
        return offerPageProductName;
    }

    public void setOfferPageProductName(String offerPageProductName) {
        this.offerPageProductName = offerPageProductName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TestContextSetup that = (TestContextSetup) o;
        return Objects.equals(driver, that.driver) && Objects.equals(landingPageProductName, that.landingPageProductName) && Objects.equals(offerPageProductName, that.offerPageProductName);
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
