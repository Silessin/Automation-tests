import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ActionPractice {
    public static WebDriver driver;

    @BeforeTest
    public void StartBrowser(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.selenium-shop.pl");
        driver.findElement(By.linkText("ANKIETA")).click();

    }

    @AfterTest
    public void CloseBrowser(){
        driver.quit();
    }
    @Test
    public void doActions() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions builder = new Actions(driver);
        js.executeScript("window.scrollBy(0,2000)");

        WebElement doubleclickButton = driver.findElement(By.xpath("//*[contains(@value,'Dwuklik pokaż komunikat')]"));


        builder.moveToElement(doubleclickButton).doubleClick().perform();
        String doubleclickText = driver.findElement(By.id("p-doubleClick")).getText();
        Assert.assertEquals(doubleclickText, "Przycisk dwuklik został kliknięty");
        System.out.println("\n" + doubleclickText);

        js.executeScript("window.scrollBy(0,-2000)");
        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();
        Action typeInCAPS = builder.keyDown(surnameInput, Keys.SHIFT)
                .sendKeys(surnameInput, "nowak")
                .keyUp(surnameInput, Keys.SHIFT)
                .build();
        typeInCAPS.perform();
        String expectedMessage = "NOWAK";
        Assert.assertEquals(surnameInput.getAttribute("value"), expectedMessage, "Surname is incorrect/not in CAPS");

    }

    @Test
    public void doRightClick() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions builder = new Actions(driver);
        js.executeScript("window.scrollBy(0,2000)");

        builder.moveToElement(driver.findElement(By.xpath("//*[contains(@value,'Kliknij RIGHT')]"))).contextClick().perform();
        String rightclickText = driver.findElement(By.id("rightClickInfo")).getText();
        Assert.assertEquals(rightclickText, "Przycisk RIGHT został kliknięty");
        System.out.println("\n" + rightclickText);
    }
}
