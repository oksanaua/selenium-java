import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {
    @Test
    public void firstTest() {
        //Telling the system where to find chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1.Instantiate the driver
        WebDriver driver = new ChromeDriver();

        //2. Navigate to the URL
        driver.get("https://www.saucedemo.com/");

        //7. Quit the driver
        driver.quit();
    }
}
