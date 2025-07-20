import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumGettingStartedTest {

    @Test
    public void gettingStartedSearchProvidesSuggestions() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");

        WebElement openSearchButton = driver.findElement(By.className("DocSearch"));
        openSearchButton.click();

        WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys("getting started");

        List<WebElement> searchSuggestions = new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//li[@class='DocSearch-Hit']")
                ));

        Assert.assertFalse(searchSuggestions.isEmpty());
    }

    @Test
    public void searchSuggestionNavigatesToGettingStartedUrl() {

    }
}
