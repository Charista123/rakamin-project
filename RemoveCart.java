package cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RemoveCart {

    private final Login login = new Login();
    private final AddCart addcart = new AddCart();

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("open login page RC")
    public void openLoginPageRC() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("input username RC")
    public void inputUsernameRC() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("input password RC")
    public void inputPasswordRC() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("click login button RC")
    public void clickLoginButtonRC() {
        driver.findElement(By.id("login-button")).click();
    }

    @When("user is on the product page RC")
    public void userInProductPageRC() {
        String successLogin = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(successLogin, "Products");
    }

    @When("user adds a product to the cart RC")
    public void userAddsProductToCart() {
        // Your implementation for adding a product to the cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @When("user open cart page RC")
    public void userOpenCartPageRC() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("user remove product on cart RC")
    public void userRemoveProductOnCartRC() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
    }
}
