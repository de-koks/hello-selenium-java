import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");

        // find HTML element by class and click it
        WebElement openSearchButton = driver.findElement(By.className("DocSearch"));
        openSearchButton.click();

        // find another element and input a text into it
        WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys("getting started");

        // explicit wait for list of elements presence and click 1st of them
        List<WebElement> searchSuggestions = new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//li[@class='DocSearch-Hit']")
                ));
        searchSuggestions.get(0).click();

        // sleep to watch scenario results and close browser
        Thread.sleep(3000);
        driver.quit();
    }
}
