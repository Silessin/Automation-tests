import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tryCatchPractice2 {

    public static WebDriver driver;

    @Test
    public void tryCatch() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/koszyk/");

        try {
            driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/div[2]/div/div/a")).click();

        } catch (NoSuchElementException e1) {
            System.out.println("Button does not exist");

        } catch (ElementNotVisibleException e2) {
            System.out.println("Button is not visible");

        } catch (NoAlertPresentException e3) {
            System.out.println("No Alert is present");

        } catch (TimeoutException e4) {
            System.out.println("Timed out");

        } catch (ElementNotInteractableException e5) {
            System.out.println("Not possible to interact with the button");

        }

        driver.quit();

    }
}
