package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class object {


    @Test
    void test() throws InterruptedException {
        test1 t = new test1();
        t.openWeb();
        t.secondUser();
    }
}
