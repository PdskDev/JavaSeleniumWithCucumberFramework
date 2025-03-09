package me.nadetdev.selenium.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinition {
  private WebDriver driver;
  private String landingPageProductName;
  private String offerPageProductName;

  @Given("user is on GreenKart landing page")
  public void userIsOnGreenKartLandingPage() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
  }

  @When("user searched with shortname {string} and extracted actual name of product")
  public void userSearchedWithShortnameAndExtractedActualNameOfProduct(String shortName) throws InterruptedException {
    System.out.println("shortName: " + shortName);
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    Thread.sleep(2000);
    landingPageProductName =
        driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    System.out.println("productName: " + landingPageProductName);
  }

  @Then("user searched for {string} shortname in Offers page")
  public void userSearchedForSameShortnameInOffersPageToCheckIfProductExist(String shortName) throws InterruptedException {
    driver.findElement(By.linkText("Top Deals")).click();

    Set<String> windowHandles = driver.getWindowHandles();
    Iterator<String> windowIterator = windowHandles.iterator();

    String parentWindow = windowIterator.next();
    String childWindow = windowIterator.next();

    driver.switchTo().window(childWindow);

    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
    Thread.sleep(2000);
    offerPageProductName = driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
  }

  @And("validate product name in Offers page matches with landing page")
  public void validateProductNameInOffersPageMatchesWithLandingPage() {
    Assert.assertEquals(landingPageProductName, offerPageProductName);
  }
}
