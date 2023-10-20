package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("open login page CH")
    public void openLoginPageCH() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("input username CH")
    public void inputUsernameCH() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input password CH")
    public void inputPasswordCH() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button CH")
    public void clickLoginButtonCH() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("user is on the product page CH")
    public void userIsOnTheProductPageCH() {
        String successLogin = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(successLogin, "Products");
    }

    @And("user adds a product to the CH")
    public void userAddsAProductToTheCH() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("user open cart page CH")
    public void userOpenCartPageCH() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("click checkout button CH")
    public void clickCheckoutButtonCH() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("input first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Yusron");
    }

    @And("input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Laksono");
    }

    @And("input postal code")
    public void inputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("123456abcde");
    }

    @And("click continue button")
    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("click finish button")
    public void clickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user success checkout")
    public void userSuccessCheckout() {
        driver.findElement(By.className("checkout_complete_container")).click();
    }
}
