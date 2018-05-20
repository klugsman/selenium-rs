package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchFiltersPage extends PageBase {

    public SearchFiltersPage(WebDriver driver) {
        super(driver);
    }

    public SearchFiltersPage selectFilter(String filterName){
        String filterNameXpath = "//rs-facets[1]/a[*][contains(.,'" + filterName + "')]";
        WebElement btnFilterName = driver.findElement(By.xpath(filterNameXpath));
        btnFilterName.isEnabled();
        btnFilterName.click();
        return new SearchFiltersPage(driver);
    }

    public SearchFiltersPage selectFilterCheckbox(String filterCheckboxName){
        String filterCheckboxNameXpath = "//span[@class='filterCheckboxLabelText']/span[contains(.,'" + filterCheckboxName + "')]";
        WebElement cbFilterCheckbox = driver.findElement(By.xpath(filterCheckboxNameXpath));
        cbFilterCheckbox.isEnabled();
        cbFilterCheckbox.click();
        return new SearchFiltersPage(driver);
    }

    public SearchFiltersPage selectApplyFilters(){
        WebElement btnApplyFilters = driver.findElement(By.xpath("//rs-apply-button[@apply-function='applyFiltersFunction()']//button[@ng-click='applyButtonEnabled && applyFunction()'][contains(text(),'Apply filters')]"));
        btnApplyFilters.isEnabled();
        btnApplyFilters.click();

        return new SearchFiltersPage(driver);
    }
    public String getFilteredMatchesNumber(){
        WebElement lbFilteredMatchesNumber = driver.findElement(By.xpath("//span[@class='number']"));
        lbFilteredMatchesNumber.isEnabled();

        return lbFilteredMatchesNumber.getText();
    }

    public String getFirstProductNameFromFilteredResults(){
        //WebElement lbFirstProductNamefromFilteredResults = driver.findElement(By.xpath("//tr[1]/td[2]/div[1]/a[1]"));
        WebElement lbFirstProductNamefromFilteredResults = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]/div[1]/a[1]"));
        WebElement lbDescriptionColumnHeader = driver.findElement(By.xpath("//th[@class='descriptionCol'][contains(text(),'Description')]"));
        lbDescriptionColumnHeader.isEnabled();
        lbFirstProductNamefromFilteredResults.isDisplayed();
        lbFirstProductNamefromFilteredResults.isEnabled();

        return  lbFirstProductNamefromFilteredResults.getText();
    }

}
