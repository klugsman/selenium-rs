package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BatteryHydrometersPage extends PageBase {

    public BatteryHydrometersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="atbBtn-1")
    WebElement buttonAddToBasket;

    @FindBy(xpath="//div[@class='addToBasketMessageText']/div[2][contains(.,'View Basket')]")
    WebElement buttonViewBasket;

    public BatteryHydrometersPage addBatteryHydrometerToBasket(){
        WebElement btnAddToBasket = driver.findElement(By.id("atbBtn-1"));
        btnAddToBasket.click();

        return new BatteryHydrometersPage(driver);
    }

    public BatteryHydrometersPage selectViewBasketButton(){
        WebElement btnViewBasket = driver.findElement(By.xpath("//a[@href='https://uk.rs-online.com/web/ca/basketsummary/']//i[@class='icon-cart']"));
        btnViewBasket.isEnabled();
        btnViewBasket.click();

        return new BatteryHydrometersPage(driver);
    }

}
