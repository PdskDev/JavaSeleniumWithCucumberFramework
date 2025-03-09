package me.nadetdev.selenium.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Iterator;
import java.util.Set;

import me.nadetdev.selenium.utils.TestContextSetup;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OfferPageStepDefinition {
  private final TestContextSetup testContextSetup;

  public OfferPageStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Then("user searched for {string} shortname in Offers page")
  public void userSearchedForSameShortnameInOffersPageToCheckIfProductExist(String shortName) throws InterruptedException {
    testContextSetup.getDriver().findElement(By.linkText("Top Deals")).click();

    this.switchToOffersPage();

    testContextSetup.getDriver().findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    Thread.sleep(2000);

    String offerPageProductName =  testContextSetup.getDriver().findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
    testContextSetup.setOfferPageProductName(offerPageProductName);
  }

  @And("validate product name in Offers page matches with landing page")
  public void validateProductNameInOffersPageMatchesWithLandingPage() {
    Assert.assertEquals(testContextSetup.getLandingPageProductName(), testContextSetup.getOfferPageProductName());
  }

  public void switchToOffersPage(){
    Set<String> windowHandles =  testContextSetup.getDriver().getWindowHandles();
    Iterator<String> windowIterator = windowHandles.iterator();

    String parentWindow = windowIterator.next();
    String childWindow = windowIterator.next();

    testContextSetup.getDriver().switchTo().window(childWindow);
  }
}
