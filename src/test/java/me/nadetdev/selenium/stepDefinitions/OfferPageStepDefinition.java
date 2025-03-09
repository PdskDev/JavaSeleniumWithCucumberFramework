package me.nadetdev.selenium.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Iterator;
import java.util.Set;

import me.nadetdev.selenium.utils.TestContextSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OfferPageStepDefinition {
  private final TestContextSetup testContextSetup;

  public OfferPageStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Then("user searched for {string} shortname in Offers page")
  public void userSearchedForSameShortnameInOffersPageToCheckIfProductExist(String shortName) throws InterruptedException {
    testContextSetup.getDriver().findElement(By.linkText("Top Deals")).click();

    Set<String> windowHandles =  testContextSetup.getDriver().getWindowHandles();
    Iterator<String> windowIterator = windowHandles.iterator();

    String parentWindow = windowIterator.next();
    String childWindow = windowIterator.next();

    testContextSetup.getDriver().switchTo().window(childWindow);

    testContextSetup.getDriver().findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    Thread.sleep(2000);

    String offerPageProductName =  testContextSetup.getDriver().findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
    testContextSetup.setOfferPageProductName(offerPageProductName);
  }

  @And("validate product name in Offers page matches with landing page")
  public void validateProductNameInOffersPageMatchesWithLandingPage() {
    Assert.assertEquals(testContextSetup.getLandingPageProductName(), testContextSetup.getOfferPageProductName());
  }
}
