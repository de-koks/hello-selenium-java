package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private static final String HOMEPAGE_URL = "https://www.selenium.dev";
    private WebDriver driver;

    private WebElement openSearchButton = driver.findElement(By.className("DocSearch"));
    private WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public HomePage enterSearchQuery(String query) {
        openSearchButton.click();
        searchInput.sendKeys(query);
        return this;
    }

    public List<WebElement> getSearchSuggestions() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//li[@class='DocSearch-Hit']")
                ));
    }
}
