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

public class Filter {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("open login page user")
    public void openLoginPageUser() {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseUrl);
    }

    @When("input username user")
    public void inputUsernameUser() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }


    @And("input password user")
    public void inputPasswordUser() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login buttonn")
    public void clickLoginButtonn() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("user on the product page")
    public void userOnTheProductPage() {
        String successLogin = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(successLogin, "Products");
    }

    @And("choose filter")
    public void chooseFilter() {
        driver.findElement(By.className("product_sort_container")).click();
    }

    @Then("display product according to the selected filter")
    public void displayProductAccordingToTheSelectedFilter() {
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
    }
}
