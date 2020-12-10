import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.Console;

public class openBrowser {

    @Test
    public void firstOpenBrowser() throws InterruptedException{
        //Set Chrome Browser Driver
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //Create ChromeDriver instance
        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        //to open the browser
        wd.get("https://www.gmail.com");
        //to maximize the browser
        wd.manage().window().maximize();
        //wait for 5 sec
        Thread.sleep(5000);
        //close the browser
        wd.close();
    }

    @Test
    public void openFirefoxBrowser() throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        WebDriver wd = new FirefoxDriver();
        wd.get("https://www.facebook.com/");
        wd.manage().window().maximize();
        Thread.sleep(10000);
        wd.get("https://www.gmail.com");
        wd.manage().window().maximize();
        Thread.sleep(10000);
        wd.close();
    }



    @Test
    public void testTheTitle() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver wd = new FirefoxDriver();
        wd.get("https://automationpractice.itsutra.com/");
        wd.manage().window().maximize();
        Thread.sleep(10000);
        String expectedTitle = "Contoso University";
        String actualTitle = wd.findElement(By.xpath("/html/body/div[2]/div[1]/h1")).getText().toString();
        //Assert.assertEquals(true, wd.contains(expectedTitle), "Title is not matching");
        Assert.assertEquals(expectedTitle, actualTitle );
        wd.close();
    }
}