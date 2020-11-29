package locating.elements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocationExamTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void locatorExam(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. navigate to the URL
        driver.get("https://www.saucedemo.com/");

        //Use CSS selector
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".btn_action")).click();

        //Use CSS and XPath
        //Adding an item to a cart
        driver.findElement(By.xpath("//*[@class='btn_primary btn_inventory']")).click();
        //Clicking on a cart
        driver.findElement(By.cssSelector("#shopping_cart_container")).click();
        //Clicking on the Next button
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();

        //Use the best locator
        driver.findElement(By.id("first-name")).sendKeys("first name");
        driver.findElement(By.id("last-name")).sendKeys("last name");
        driver.findElement(By.id("postal-code")).sendKeys("zip");
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();

        //By link test
        driver.findElement(By.linkText("FINISH")).click();

        //Test result
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkout_complete_container")).isDisplayed());

    }
}
