import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;


public class TwoTabs {

    public static WebDriver driver;



    @Test
    public void startBrowser() {
        
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://www.selenium-shop.pl/o-nas");
        driver.manage().window().maximize();

        System.out.println("Website title: " + driver.getTitle());
        System.out.println("Survey tab ID: " + driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@value='Otwórz nowe okno']")).click();

        Set<String> browserTabs = driver.getWindowHandles();
        System.out.println("Number of open tabs: " + browserTabs.size());

        for (String tab: browserTabs){
            System.out.println("Browser tab: " + tab);
        }

        Iterator<String> iterator = browserTabs.iterator();
        String parent = iterator.next();
        String child = iterator.next();

        driver.switchTo().window(child);

        WebElement nameInput = driver.findElement(By.id("imie_nazwisko"));
        nameInput.sendKeys("Bob the Builder");

        System.out.println("Website title: (child tab) " + driver.getTitle());
        System.out.println("Survey tab ID: (child tab) " + driver.getWindowHandle());

        Assert.assertEquals(nameInput.getAttribute("value"), "Bob the Builder");

        driver.quit();


    }
}
