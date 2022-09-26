package CoinGeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class login {
    WebDriver driver;

    @Test
    void openWeb(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://exchange.stage-coingeb.com/login");
    }

    @Test(priority = 1)
    void login() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shiva.mahajan@antiersolutions.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@123");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector(".ui.primary.button.loginUIButton")).click();
    }
    @AfterClass(enabled = false)
    void  closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    void secondUser() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().to("https://exchange.stage-coingeb.com/trading/sxpbtc");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='ui simple dropdown dropNav white user-info hideUpper']//i[@class='user icon']")).click();
        driver.findElement(By.xpath("//div[@class='visible menu transition']//div[2]")).click();
        driver.get("https://exchange.stage-coingeb.com/login");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shiva.mahajan+3@antiersolutions.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@123");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector(".ui.primary.button.loginUIButton")).click();

    }
}
