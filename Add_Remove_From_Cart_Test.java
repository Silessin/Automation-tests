import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Montiko {

    public static WebDriver driver;

    @Test
    public void DodajiUsuńzKoszyka() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://montiko.pl/");


        WebElement nowoscMenu = driver.findElement(By.linkText("Nowości"));
        nowoscMenu.click();

        WebElement blackOut = driver.findElement(new By.ByPartialLinkText("0911 black out/0520"));
        blackOut.click();

        WebElement rozmiarStopy = driver.findElement(By.cssSelector("a.projector_sizes__item[data-type='88']"));
        rozmiarStopy.click();

        WebElement dodajDoKoszyka = driver.findElement(By.xpath("//button[@id='projector_button_basket']"));
        dodajDoKoszyka.click();

        WebElement przejdzDoKoszyka = driver.findElement(By.cssSelector("#menu_preloader_add > div.added__block > div > div > div.added__buttons > a.btn.--solid.--medium.added__button.--add"));
        przejdzDoKoszyka.click();

        WebElement usunZKoszyka = driver.findElement(By.xpath("//*[@id=\"Basket\"]/form/div[1]/div[2]/div[5]/div[3]"));
        usunZKoszyka.click();

        driver.close();
        driver.quit();

    }
}

