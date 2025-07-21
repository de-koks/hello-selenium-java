package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.HomePage;

public class SearchSuggestionsTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod (alwaysRun = true)
    public void browserClosure() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldDisplaySearchSuggestions() {
        List<WebElement> expectedSearchSuggestions = new HomePage(driver)
            .openPage()
            .enterSearchQuery("getting started")
            .getSearchSuggestions();
        
        Assert.assertFalse(expectedSearchSuggestions.isEmpty(),
         "No search suggestions after 'getting started' input."
        );
    }
    
}
