import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");

        WebElement openSearchButton = driver.findElement(By.className("DocSearch"));
        openSearchButton.click();

        WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
        searchInput.sendKeys("getting started");

        Thread.sleep(2000);
        WebElement searchSuggestion = driver.findElement(By.xpath("//li[@class='DocSearch-Hit'][1]"));
        searchSuggestion.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
