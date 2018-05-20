package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {


    public HomePage(WebDriver driver) {
        super(driver);

    }



    public HomePage selectBatteryHydrometersUsingSearchFilters(){
        WebElement mnAllProducts = driver.findElement(By.xpath("//a[@title='All Products']"));
        mnAllProducts.isEnabled();
        mnAllProducts.click();
        WebElement lnkBatteries = driver.findElement(By.linkText("Batteries"));
        lnkBatteries.isEnabled();
        lnkBatteries.click();
        WebElement lnkAutomotiveBatteryMaintenance = driver.findElement(By.linkText("Automotive Battery Maintenance"));
        lnkAutomotiveBatteryMaintenance.click();
        WebElement lnkBatteryHydrometers = driver.findElement(By.linkText("Battery Hydrometers"));
        lnkBatteryHydrometers.isEnabled();
        lnkBatteryHydrometers.click();

        return new HomePage(driver);
    }

    public String getGoBehindTheBrandText(){
        WebElement bnGoBehindTheBrand = driver.findElement(By.xpath("//div[@class='heroBanner_text']//h1"));
        bnGoBehindTheBrand.isEnabled();
        return bnGoBehindTheBrand.getText();
    }

    public HomePage searchForItem(String searchTerm){
        WebElement tbSearchBox = driver.findElement(By.id("searchTerm"));
        WebElement btnSearch = driver.findElement(By.id("btnSearch"));
        tbSearchBox.isEnabled();
        tbSearchBox.clear();
        tbSearchBox.sendKeys(searchTerm);
        btnSearch.isEnabled();
        btnSearch.click();

        return new HomePage(driver);
    }
}
