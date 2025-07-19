import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");

        // find HTML element by class and click it
        WebElement openSearchButton = driver.findElement(By.className("DocSearch"));
        openSearchButton.click();

        // find another element and input a text into it
        WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys("getting started");

        // creating a custom fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for element timeout exceeded.");

        // explicit wait for list of elements presence and click 1st of them
        List<WebElement> searchSuggestions = wait.until(new Function<WebDriver, List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver webDriver) {
                List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='DocSearch-Hit']"));
                return suggestions.isEmpty() ? null : suggestions;
            }
        });
        searchSuggestions.get(0).click();

        // sleep to watch scenario results and close browser
        Thread.sleep(3000);
        driver.quit();
    }
}
