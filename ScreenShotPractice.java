import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShotPractice {

    public static WebDriver driver;

    // TEST COMMENT

    //test commit 1
    //test commit 2
    //test commit 3
    //test commit 4

    @BeforeTest
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.selenium-shop.pl/");
        driver.manage().window().maximize();

    }


    @AfterTest
    public void quitBrowser() {
        driver.quit();

    }

    public void takeScreenShot(int TestNumber) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + TestNumber + "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }


    @Test(priority = 1)
    public void checkTitleScreen(){

        driver.get("http://www.selenium-shop.pl/");
        Assert.assertEquals(driver.getTitle(), "Selenium Shop Automatyzacja Testów");
        System.out.println(driver.getTitle());

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }

        takeScreenShot(1);


        }
    @Test (priority = 2)
    public void checkShopScreen() {

        driver.get("http://www.selenium-shop.pl/");
        driver.findElement(By.linkText("SKLEP")).click();
        Assert.assertEquals(driver.getTitle(), "Produkty – Selenium Shop Automatyzacja Testów");
        System.out.println(driver.getTitle());

        takeScreenShot(2);
    }

    @Test (priority = 3)
    public void checkBasketScreen(){

        driver.get("http://www.selenium-shop.pl/");
        driver.findElement(By.linkText("KOSZYK")).click();
        Assert.assertEquals(driver.getTitle(), "Koszyk – Selenium Shop Automatyzacja Testów");
        System.out.println(driver.getTitle());

        takeScreenShot(3);
    }
}