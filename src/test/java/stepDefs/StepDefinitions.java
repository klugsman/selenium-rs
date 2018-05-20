package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pages.*;

//import static stepDefs.ServiceHooks.driver;

public class StepDefinitions {

    WebDriver driver;
    HomePage homepage;
    BatteryHydrometersPage batteryHydrometersPage;
    MyBasketPage myBasketPage;
    LogInOrContinueAsGuestDialog logInOrContinueAsGuestDialog;
    CheckoutPage checkoutPage;
    BeldenBlueTwinaxialCablePage beldenBlueTwinaxialCablePage;
    SearchFiltersPage searchFiltersPage;

    @When("^I try to checkout after adding a Battery Hydrometer to my basket using search filters$")
    public void i_try_to_checkout_after_adding_a_Battery_Hydrometer_to_my_basket_using_search_filters() throws Throwable {
        homepage = new HomePage(driver);
        homepage.navigateTo();
        Assert.assertEquals(homepage.getGoBehindTheBrandText(),"Go behind the brand");
        homepage.selectBatteryHydrometersUsingSearchFilters();
        System.out.println("thE FIRST WHEN");
        batteryHydrometersPage = new BatteryHydrometersPage(driver);
        batteryHydrometersPage.addBatteryHydrometerToBasket();
        batteryHydrometersPage.selectViewBasketButton();
        myBasketPage = new MyBasketPage(driver);
        myBasketPage.selectCheckoutButton();
        logInOrContinueAsGuestDialog = new LogInOrContinueAsGuestDialog(driver);
        logInOrContinueAsGuestDialog.typeGuestEmail();

    }

    @Then("^I can see the checkout page$")
    public void i_can_see_the_checkout_page() throws Throwable {
        Assert.assertEquals(logInOrContinueAsGuestDialog.getExistingUserText(),"I have ordered RS products over the phone but have not registered online");
        logInOrContinueAsGuestDialog.selectGuestCheckout();

    }
    
    @When("^I try to checkout after adding a Belden Blue Twinaxialuse to my basket using the search box$")
    public void i_try_to_checkout_after_adding_a_Belden_Blue_Twinaxialuse_to_my_basket_using_the_search_box() throws Throwable {
        homepage = new HomePage(driver);
        homepage.navigateTo();
        Assert.assertEquals(homepage.getGoBehindTheBrandText(),"Go behind the brand");
        homepage.searchForItem("136-6349");
        beldenBlueTwinaxialCablePage = new BeldenBlueTwinaxialCablePage(driver);
        beldenBlueTwinaxialCablePage.addToBasket();
        Assert.assertEquals(beldenBlueTwinaxialCablePage.getManufacturesrNumber(),"9463 J221000");
        beldenBlueTwinaxialCablePage.viewBasket();
        myBasketPage = new MyBasketPage(driver);
        myBasketPage.selectCheckoutButton();
        logInOrContinueAsGuestDialog = new LogInOrContinueAsGuestDialog(driver);
        logInOrContinueAsGuestDialog.typeGuestEmail();

    }

    @Then("^I can start to checkout$")
    public void i_can_start_to_checkout() throws Throwable {
        Assert.assertEquals(logInOrContinueAsGuestDialog.getExistingUserText(),"I have ordered RS products over the phone but have not registered online");
        logInOrContinueAsGuestDialog.selectGuestCheckout();

    }

    @When("^I search for a productone using the Search filters$")
    public void i_search_for_a_productone_using_the_Search_filters() throws Throwable {
        homepage = new HomePage(driver);
        homepage.navigateTo();
        Assert.assertEquals(homepage.getGoBehindTheBrandText(),"Go behind the brand");
        homepage.searchForItem("Optical Rotary Encoders");
        searchFiltersPage = new SearchFiltersPage(driver);
        searchFiltersPage.selectFilter("Brand");
        searchFiltersPage.selectFilterCheckbox("Broadcom");
        searchFiltersPage.selectApplyFilters();
        
    }

    @Then("^productOne appears in search results$")
    public void productone_appears_in_search_results() throws Throwable {
        Assert.assertEquals(searchFiltersPage.getFilteredMatchesNumber(),"3");
        Assert.assertEquals(searchFiltersPage.getFirstProductNameFromFilteredResults(),"Broadcom 1000 Pulse Code Wheel with a 0.5 in, Through Hole");


    }

    @When("^I search for a producttwo using the Search filters$")
    public void i_search_for_a_producttwo_using_the_Search_filters() throws Throwable {
        homepage = new HomePage(driver);
        homepage.navigateTo();
        Assert.assertEquals(homepage.getGoBehindTheBrandText(),"Go behind the brand");
        homepage.searchForItem("Robot Grippers");
        searchFiltersPage = new SearchFiltersPage(driver);
        searchFiltersPage.selectFilter("Gripper Type");
        searchFiltersPage.selectFilterCheckbox("Pneumatic");
        searchFiltersPage.selectApplyFilters();
                
    }

    @Then("^producttwo appears in search results$")
    public void producttwo_appears_in_search_results() throws Throwable {
        Assert.assertEquals(searchFiltersPage.getFilteredMatchesNumber(),"2");
        Assert.assertEquals(searchFiltersPage.getFirstProductNameFromFilteredResults(),"ST Robotics Pneumatic Parallel Pneumatic Gripper");
    }

    @When("^I search for a productthree using the Search filters$")
    public void i_search_for_a_productthree_using_the_Search_filters() throws Throwable {
        homepage = new HomePage(driver);
        homepage.navigateTo();
        Assert.assertEquals(homepage.getGoBehindTheBrandText(),"Go behind the brand");
        homepage.searchForItem("Laptop Accessories");
        searchFiltersPage = new SearchFiltersPage(driver);
        searchFiltersPage.selectFilter("For Use With");
        searchFiltersPage.selectFilterCheckbox("PC Tower");
        searchFiltersPage.selectApplyFilters();
    }

    @Then("^productthree appears in search results$")
    public void productthree_appears_in_search_results() throws Throwable {
        Assert.assertEquals(searchFiltersPage.getFilteredMatchesNumber(),"1");
        Assert.assertEquals(searchFiltersPage.getFirstProductNameFromFilteredResults(),"HAMA Laptop Stand for use with PC Tower");
    }
     
    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extenstions");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options); 

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
