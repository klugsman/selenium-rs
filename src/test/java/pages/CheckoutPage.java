package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="checkoutSecurelyBtn")
    WebElement btnContinueToPayment;

    public CheckoutPage selectfirstName() {

        WebElement tbFirstName = driver.findElement(By.id("deliveryCollectionForm:CustomerContactDetailsWidgetAction_firstName_decorate:CustomerContactDetailsWidgetAction_firstName"));
        tbFirstName.isEnabled();
        tbFirstName.click();
        return new CheckoutPage(driver);
    }





}
