import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseActionsPractice {

    public static WebDriver driver;


    @Test
    public void startBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://www.selenium-shop.pl/o-nas");
        driver.manage().window().maximize();

        WebElement doubleClickButton = driver.findElement(By.xpath("//*[@value='Dwuklik pokaż komunikat']"));
        Actions builder = new Actions(driver);
        builder.doubleClick(doubleClickButton).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Przycisk dwuklik został kliknięty']")).isDisplayed());

        WebElement rightClickButton = driver.findElement(By.xpath("//*[@value='Kliknij RIGHT']"));
        builder.contextClick(rightClickButton).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Przycisk RIGHT został kliknięty']")).isDisplayed());

        WebElement inputName = driver.findElement(By.id("Imię"));
        Action textCaps = builder.keyDown(inputName, Keys.SHIFT).sendKeys(inputName, "tomasz").build();

        textCaps.perform();

        Assert.assertEquals(inputName.getAttribute("value"), "TOMASZ");

        driver.quit();


    }
}
