import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VOLTcolumns {

    public static WebDriver driver;

    @Test
    public void columnVerification() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.voltboulderownia.pl/");

        List<WebElement> allColumns = driver.findElements(By.className("column-link"));

        int numberOfColumns = allColumns.size();

        System.out.println("Number of columns on main website = " + numberOfColumns);

        Assert.assertEquals(numberOfColumns, 2);

        for (int i = 0; i < numberOfColumns; i++){
            System.out.println(allColumns.get(i).getAttribute("href"));
        }

        driver.close();
        driver.quit();

    }
}
