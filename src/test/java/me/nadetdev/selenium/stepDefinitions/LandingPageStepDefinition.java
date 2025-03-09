package me.nadetdev.selenium.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import me.nadetdev.selenium.utils.TestContextSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageStepDefinition {
  private final TestContextSetup testContextSetup;

  public LandingPageStepDefinition(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
  }

  @Given("user is on GreenKart landing page")
  public void userIsOnGreenKartLandingPage() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
    testContextSetup.setDriver(new ChromeDriver());
    testContextSetup.getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");
  }

  @When("user searched with shortname {string} and extracted actual name of product")
  public void userSearchedWithShortnameAndExtractedActualNameOfProduct(String shortName) throws InterruptedException {
    System.out.println("shortName: " + shortName);
    testContextSetup.getDriver().findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    Thread.sleep(2000);
    String landingPageProductName =testContextSetup.getDriver().findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    testContextSetup.setLandingPageProductName(landingPageProductName);

    System.out.println("productName: " +  testContextSetup.getLandingPageProductName());
  }
}
