package stepDefs;

import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ServiceHooks
{
    //public static WebDriver driver;
    @Before
/**
 * Delete all cookies at the start of each scenario to avoid
 * shared state between tests
 */
    public void openBrowser() throws MalformedURLException {
        //System.out.println("Called openBrowser");
        //driver = new FirefoxDriver();
        //driver.manage().deleteAllCookies();
        //driver.navigate().to("https://uk.rs-online.com/web/");

    }
    @After
/**
 * Embed a screenshot in test report if test is marked as failed
 */
    public void embedScreenshot(Scenario scenario) {
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        /*if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }  */
      //  driver.quit();
    }
}
