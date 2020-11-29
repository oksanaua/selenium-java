import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumTest {


    @Test
    public void safariTest() {
        WebDriver driver = new SafariDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.quit();
    }
    @Test
    public void cypressTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://example.cypress.io/");
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void shoppingCartTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        Thread.sleep(3000);
        driver.quit();
    }

}
