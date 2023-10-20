package cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AddCart {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("open login page cart")
    public void openLoginPageCart() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("input username cart")
    public void inputUsernameCart() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("input password cart")
    public void inputPasswordCart() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("click login button cart")
    public void clickLoginButtonCart() {
        driver.findElement(By.id("login-button")).click();
    }

    @When("user is on the product page cart")
    public void userInProductPageCart() {
        String successLogin = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(successLogin, "Products");
    }

    @When("user adds a product to the cart")
    public void userAddsProductToCart() {
        // Your implementation for adding a product to the cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("user open cart page")
    public void userOpenCartPage() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
