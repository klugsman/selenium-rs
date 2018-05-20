package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBasketPage extends PageBase {

    //WebDriver driver;

    public MyBasketPage(WebDriver driver) {
        super(driver);
    }

    public MyBasketPage selectCheckoutButton(){
        WebElement btnCheckoutSecurely = driver.findElement(By.id("checkoutSecurelyAndPuchBtn"));
        btnCheckoutSecurely.isEnabled();
        btnCheckoutSecurely.click();

        return new MyBasketPage(driver);
    }

}
