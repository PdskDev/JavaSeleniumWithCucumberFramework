package me.nadetdev.selenium.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Iterator;
import java.util.Set;

import me.nadetdev.selenium.pageObjects.OffersPage;
import me.nadetdev.selenium.utils.TestContextSetup;
import org.testng.Assert;

public class OfferPageStepDefinition {
  private final TestContextSetup testContextSetup;

  public OfferPageStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Then("user searched for {string} shortname in Offers page")
  public void userSearchedForSameShortnameInOffersPageToCheckIfProductExist(String shortName) throws InterruptedException {
    OffersPage offersPage = new OffersPage(testContextSetup.getDriver());
    offersPage.clickTopDealsLink();
    this.switchToOffersPage();
    offersPage.searchProduct(shortName);
    Thread.sleep(2000);
    testContextSetup.setOfferPageProductName(offersPage.getReturnedProductName());
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
