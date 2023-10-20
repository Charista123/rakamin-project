package cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("open login page")
    public void openLoginPage() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @When("input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("invalid_password");
    }

    @When("click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user is on the product page")
    public void userInProductPage() {
        String successLogin = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(successLogin, "Products");
    }


    @Then("user gets an error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorLogin);
    }
}
