import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tryCatchPractice {

    public static WebDriver driver;

    @Test
    public void tryCatch(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/moje-konto/");

        WebElement registerButton;

        try{
            driver.findElement(By.name("register")).click();
        }catch (NoSuchElementException e1){

            System.out.println("The button REGISTER is not existent on the website!");
            driver.navigate().refresh();

        }catch (ElementNotVisibleException e2){

            System.out.println("The REGISTER button is not visible on the webiste");
            driver.navigate().refresh();

        }catch (ElementNotInteractableException e3){

            System.out.println("It isnot possible to click the REGISTER button");
            driver.navigate().refresh();
        }

        driver.quit();


    }
}
