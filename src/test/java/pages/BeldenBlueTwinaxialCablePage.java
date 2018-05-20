package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeldenBlueTwinaxialCablePage extends PageBase {

    public BeldenBlueTwinaxialCablePage(WebDriver driver) {
        super(driver);
    }

    public BeldenBlueTwinaxialCablePage addToBasket(){
        WebElement btnAddItemToBasket = driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Add to basket')]"));
        WebElement itemMainHeader = driver.findElement(By.xpath("//h1[@class='col-xs-12 main-page-header']"));
        itemMainHeader.isEnabled();
        btnAddItemToBasket.isEnabled();
        btnAddItemToBasket.click();

        return new BeldenBlueTwinaxialCablePage(driver);
    }

    public BeldenBlueTwinaxialCablePage viewBasket(){
        WebElement btnViewBasket = driver.findElement(By.xpath("//button[@type='button'][contains(text(),'View Basket')]"));
        //WebElement btnViewBasket = driver.findElement(By.xpath("//div[@class='addToBasketMessageText']/div[2][contains(text(),'View Basket')]"));
        btnViewBasket.isEnabled();
        btnViewBasket.click();

        return new BeldenBlueTwinaxialCablePage(driver);
    }

    public String getManufacturesrNumber() {
        WebElement lbManufacturesrNumber = driver.findElement(By.xpath("//span[contains(text(),'9463 J221000')]"));
        lbManufacturesrNumber.isEnabled();

        return lbManufacturesrNumber.getText();
    }
}
