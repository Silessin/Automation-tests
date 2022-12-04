import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class AssertsPractice {

    public static WebDriver driver;

    @Test
    public void doAsserts() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.selenium-shop.pl");

        String correctWebsiteTitle = "Selenium Shop Automatyzacja Testów";
        String correctMyAccountTitle = "Moje konto – Selenium Shop Automatyzacja Testów";
        String correctShopTitle = "Produkty – Selenium Shop Automatyzacja Testów";


        Assert.assertEquals(driver.getTitle(), correctWebsiteTitle, "Website title is incorrect");

        driver.findElement(By.xpath("//*[@id=\"menu-item-136\"]/a")).click();
        Assert.assertEquals(driver.getTitle(), correctMyAccountTitle, "My Account site title is incorrect");

        WebElement loginInput = driver.findElement(By.id("username"));
        Assert.assertTrue(loginInput.isDisplayed(), "Login is not displayed");

        WebElement rememberMe = driver.findElement(By.id("rememberme"));
        Assert.assertFalse(rememberMe.isSelected(), "Rember me is selected");

        driver.findElement(By.linkText("SKLEP")).click();
        Assert.assertEquals(driver.getTitle(), correctShopTitle, "Site title is incorrect");

        List<WebElement> allProducts = driver.findElements(By.xpath("//li[contains(@class,'product')]"));
        int numberOfProducts = allProducts.size();

        Assert.assertEquals(numberOfProducts, 12,"Number of Products is incorrect");
        System.out.println("Number of products is " + numberOfProducts + ", expected 12");

        WebElement sortList = driver.findElement(By.className("orderby"));
        Assert.assertTrue(sortList.isDisplayed(), "Sort list is not visible");
        System.out.println("Sort list is visible");

        driver.findElement(By.xpath("//li[contains(@class,'product')]")).click();
        Assert.assertTrue(driver.findElement(By.className("qty")).isEnabled());

        driver.findElement(By.linkText("MOJE KONTO")). click();
        Assert.assertTrue(driver.findElement(By.className("woocommerce-form-login__submit")).isDisplayed(), "Login button is not displayed");
        Assert.assertTrue(driver.findElement(By.className("woocommerce-form-register__submit")).isDisplayed(), "Regiter button is not displayed");

        System.out.println("Login and register buttons are displayed");

        driver.quit();

        }
    }
