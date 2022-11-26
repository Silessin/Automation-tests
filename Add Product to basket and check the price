import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

    public class SeleniumShopBasket {

        public static WebDriver driver;

        @Test
        public void orderProduct() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.selenium-shop.pl");
            driver.findElement(By.linkText("SKLEP")).click();

            Select productListFilter = new Select(driver.findElement(By.className("orderby")));
            productListFilter.selectByVisibleText("Sortuj od najnowszych");

            WebElement thirdNewestProduct = driver.findElement(By.xpath(("//ul[contains(@class,'products')]/li[3]")));
            thirdNewestProduct.click();

            String nameOne = driver.findElement(By.className("product_title")).getText();
            String priceOne = driver.findElement(By.xpath("//*[@id=\"product-48\"]/div[2]/p/span")).getText();

            System.out.println(nameOne);
            System.out.println(priceOne);

            driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).sendKeys("2");

            driver.findElement(By.name("add-to-cart")).click();

            driver.findElement(By.linkText("Zobacz koszyk")).click();

            String nameTwo = driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[3]/a")).getText();
            String priceAll = driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[6]/span")).getText();

            System.out.println(nameTwo);
            System.out.println(priceAll);

            String correctPriceAll = "240,00 ZŁ";

            Assert.assertEquals(nameOne, nameTwo);
            Assert.assertEquals(priceAll,correctPriceAll);

            driver.quit();


