package me.nadetdev.selenium.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import me.nadetdev.selenium.pageObjects.LandingPage;
import me.nadetdev.selenium.utils.TestContextSetup;

public class LandingPageStepDefinition {
  private final TestContextSetup testContextSetup;

  public LandingPageStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("user is on GreenKart landing page")
  public void userIsOnGreenKartLandingPage() {
    testContextSetup.initBrowserDriver();
    testContextSetup.getDriver().get(testContextSetup.getLANDING_PAGE_URL());
  }

  @When("user searched with shortname {string} and extracted actual name of product")
  public void userSearchedWithShortnameAndExtractedActualNameOfProduct(String shortName) throws InterruptedException {
    LandingPage landingPage = new LandingPage(testContextSetup.getDriver());
    landingPage.searchItem(shortName);
    Thread.sleep(2000);
    testContextSetup.setLandingPageProductName(landingPage.getProductName());
  }
}
