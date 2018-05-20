package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageBase {
    //protected WebDriver driver;
    public static WebDriver driver;
    //public static final WebDriver driver = new FirefoxDriver();

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public HomePage navigateTo() {
        driver.navigate().to("https://uk.rs-online.com/web/");
        return new HomePage(driver);
    }

}
