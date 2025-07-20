import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumGettingStartedTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void browserClosure() {
        driver.quit();
        driver = null;
    }

    @Test (description = "Jira ticket ID can be here.")
    public void gettingStartedSearchProvidesSuggestions() {
        driver.get("https://www.selenium.dev");

        WebElement openSearchButton = driver.findElement(By.className("DocSearch"));
        openSearchButton.click();

        WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys("getting started");

        List<WebElement> searchSuggestions = new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//li[@class='DocSearch-Hit']")
                ));

        Assert.assertFalse(searchSuggestions.isEmpty(), "No search suggestions after 'getting started' input.");
    }
}
