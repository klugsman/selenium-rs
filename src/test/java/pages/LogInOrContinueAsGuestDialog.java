package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInOrContinueAsGuestDialog extends PageBase {

    public LogInOrContinueAsGuestDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="guestCheckoutForm:GuestWidgetAction_emailAddress_decorate:GuestWidgetAction_emailAddress")
    WebElement textbGuestEmailAddress;

    @FindBy (id="guestCheckoutForm:guestCheckout")
    WebElement buttonGuestCheckout;

    public LogInOrContinueAsGuestDialog typeGuestEmail(){
        WebElement tbGuestEmailAddress = driver.findElement(By.id("guestCheckoutForm:GuestWidgetAction_emailAddress_decorate:GuestWidgetAction_emailAddress"));
        tbGuestEmailAddress.isEnabled();
        tbGuestEmailAddress.click();
        tbGuestEmailAddress.clear();
        tbGuestEmailAddress.sendKeys("hkgkg@youremail.com");

        return new LogInOrContinueAsGuestDialog(driver);
    }

    public LogInOrContinueAsGuestDialog selectGuestCheckout(){
        WebElement btnGuestCheckout  = driver.findElement(By.id("guestCheckoutForm:guestCheckout"));
        btnGuestCheckout.click();

        return new LogInOrContinueAsGuestDialog(driver);
    }

    public String getExistingUserText(){
        WebElement lbExistingUserText = driver.findElement(By.xpath("//span[@class='text existingAcUserText']"));
        return lbExistingUserText.getText();
    }
}
