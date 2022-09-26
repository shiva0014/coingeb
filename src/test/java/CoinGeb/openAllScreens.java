package CoinGeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class openAllScreens {
    WebDriver driver;

    @Test
    void openWeb() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://exchange.stage-coingeb.com/");



        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='cookie-banner']//button[1]")).click();

        for(int i = 0;i <= 1; i ++){

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)","");
            Thread.sleep(1000);
        }

        for(int i = 1; i <=5;i++){
            driver.findElement(By.cssSelector(".ui.attached.tabular.menu>a:nth-child("+i+")")).click();
        }

    }
}
