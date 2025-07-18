import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException {

        // create webdriver instance
        WebDriver driver = new ChromeDriver();
        // set implicit wait for 3 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // go to URL
        driver.get("https://www.selenium.dev");

        // find HTML element by class and click it
        WebElement openSearchButton = driver.findElement(By.className("DocSearch"));
        openSearchButton.click();

        // find another element and input a text into it
        WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys("getting started");

        // find a list of elements and click the 1st of them
        List<WebElement> searchSuggestions = driver.findElements(By.xpath("//li[@class='DocSearch-Hit']"));
        searchSuggestions.get(0).click();

        // wait 2 sec just to watch the result
        Thread.sleep(2000);
        driver.quit();
    }
}
