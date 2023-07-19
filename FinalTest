import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FinalTest {

    public static WebDriver driver;
    public void takeScreenShot(int NrTestu) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + NrTestu + "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    @BeforeTest
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.selenium-shop.pl/");
        driver.manage().window().maximize();


    }

    @AfterTest
    public void quitBrowser() {
    driver.quit();

    }

    @Test (priority = 1)
    public void clickProduct() {
        driver.findElement(By.linkText("KOSZULKA WEST HAM UNITED")).click();
        takeScreenShot(1);
    }

    @Test (priority = 2)
    public void verifyProductName() {
        String productTitle = driver.findElement(By.className("product_title")).getText();
        String correctTitle = "KOSZULKA WEST HAM UNITED";
        Assert.assertEquals(productTitle, correctTitle);

    }

    @Test (priority = 3)
    public void verifyProductPrice() {
        String productPrice = driver.findElement(By.className("woocommerce-Price-amount")).getText();
        String correctPrice = "90,00 ZŁ";
        Assert.assertEquals(productPrice, correctPrice);

    }

    @Test (priority = 4)
    public void verifyProductQuantity() {
        String productQuantity = driver.findElement(By.className("qty")).getAttribute("value");
        String correctQuantity = "1";
        Assert.assertEquals(productQuantity, correctQuantity);

    }

    @Test (priority = 5)
    public void addToCart() {
        driver.findElement(By.className("single_add_to_cart_button")).click();
        WebDriverWait wait30 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait30.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));
        String addToCartMessage = driver.findElement(By.className("woocommerce-message")).getText();
        String correctAddToCartMessage = "Zobacz koszyk\n" +
                "“Koszulka West Ham United” został dodany do koszyka.";
        Assert.assertEquals(addToCartMessage, correctAddToCartMessage);

    }

    @Test (priority = 6)
    public void goToCart() {
        driver.findElement(By.className("wc-forward")).click();
        String currentPageTitle = driver.getTitle();
        String correctCartPageTitle = "Koszyk – Selenium Shop Automatyzacja Testów";
        Assert.assertEquals(currentPageTitle, correctCartPageTitle);
        takeScreenShot(6);

    }

    @Test (priority = 7)
    public void verifyShippingMethod() {
        String freeShippingButtonChecked = driver.findElement(By.id("shipping_method_0_free_shipping2")).getAttribute("checked");
        Assert.assertEquals(freeShippingButtonChecked, "true");
        String paidShippingButtonChecked = driver.findElement(By.id("shipping_method_0_flat_rate1")).getAttribute("checked");
        Assert.assertEquals(paidShippingButtonChecked, null);
    }

    @Test (priority = 8)
    public void goToCheckout() {
        driver.findElement(By.className("checkout-button")).click();
        Assert.assertEquals(driver.getTitle(), "Zamówienie – Selenium Shop Automatyzacja Testów");
        takeScreenShot(8);
    }

    @Test (priority = 9)
    public void verifyProductNameInCheckout() {
        String productNameInCheckout = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tbody/tr/td[1]")).getText();
        String correctProductName = "Koszulka West Ham United  × 1";
        Assert.assertEquals(productNameInCheckout, correctProductName);

    }

    @Test (priority = 10)
    public void verifyProductPriceInCheckout() {
        String productPriceInCheckout = driver.findElement(By.className("woocommerce-Price-amount")).getText();
        String correctProductPriceInCheckout = "90,00 zł";
        Assert.assertEquals(productPriceInCheckout, correctProductPriceInCheckout);
    }

    @Test (priority = 11)
    public void verifyFreeShippingInCheckout() {
        String freeShippingButtonChecked = driver.findElement(By.id("shipping_method_0_free_shipping2")).getAttribute("checked");
        Assert.assertEquals(freeShippingButtonChecked, "true");
    }

    @Test (priority = 12)
    public void verifyFinalPrice() {
        String finalPrice = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[3]/td/strong/span")).getText();
        String correctFinalPrice = "90,00 zł";
        Assert.assertEquals(finalPrice, correctFinalPrice);
    }



}
