package webdriver.methods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class WebDriverMethodsQuiz {
    WebDriver driver;
    WebElement element;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
/**
 * Go here "https://the-internet.herokuapp.com/dropdown"
 * Select option 1 from the dropdown
 * Assert that option 1 is selected
 * Assert taht option 2 is NOT selected
 * */

    @Test
    public void dropdown () {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        element.click();
        WebElement option1 = element.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = element.findElement(By.cssSelector("option[value='2']"));
        option1.click();
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
    }

    /*
     * Go to "https://the-internet.herokuapp.com/hovers"
     * Hover over the first image
     * Assert that on hover there is text that is displayed below "name: user1"
     * */

    @Test
    public void hover()  {
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[contains(text(),'name: user1')]"));
        assertTrue("user1 should appear because we hovered over that image",
                element.isDisplayed());
    }

    /*
     * https://the-internet.herokuapp.com/context_menu
     * Right click
     * close alert
     * driver.switchTo().alert().accept();
     * */

    @Test
    public void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }

    // go to "https://the-internet.herokuapp.com/key_presses"
    // send right arrow key to the input box
    // assert that you got this text back "You entered: RIGHT"

    @Test
    public void keyPresses() {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target"));
        element.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).pause(1000).perform();
        element = driver.findElement(By.id("result"));
        assertEquals("Clicked right arrow key","You entered: RIGHT", element.getText());
    }

    // go to https://ultimateqa.com/simple-html-elements-for-automation/
    // find element with text "Clickable Icon"
    // Assert href attribute =  https://ultimateqa.com/link-success/
    // Get CSS value: "background-origin"
    // Assert that it equals "padding-box"

    @Test
    public void getCSSValue() {
        //Get the href attribute from the Clickable Icon element
        driver.navigate().to("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.linkText("Clickable Icon"));
        String link = element.getAttribute("href");
        assertEquals("https://ultimateqa.com/link-success/", link);
        /*
         * Before we used to need to do Assert.something()...
         * Now, we can use static imports to do the following
         * import static org.junit.Assert.assertTrue;
         * import static org.junit.Assert.fail;
         * Notice these lines of code on top of our file
         * */

        assertEquals("padding-box", element.getCssValue("background-origin"));
    }
}
