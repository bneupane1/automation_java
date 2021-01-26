


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class seleniumBasicCodes {
    WebDriver driver;
    private By.ById element;

    @Before
    public void start() {

        WebDriverManager.chromedriver().setup();
        //Create chrome driver's instance
        driver = new ChromeDriver();
        //Set implicit wait of 10 seconds
        //This is required for managing waits in selenium webdriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //used to set webdriver
        //Launch sampleSiteForSelenium
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
    }

    @Test
    public void get_text() throws InterruptedException {
        //Fetch the text "This is sample text!" and print it on the console
        //Use the id of the div to locate it and then fecth text using the getText() method
        String sampleText = driver.findElement(By.id("idOfDiv")).getText();
        System.out.println(sampleText);

        //Waiting for 3 seconds just for the user to efficiently check automation
        //Its not mandatory though
        Thread.sleep(3000);
    }

    @Test
    public void click_link() throws InterruptedException {
        //Using linkText locator to find the link and then using click() to click on it
        driver.findElement(By.linkText("This is a link")).click();

        Thread.sleep(3000);
    }

    @Test
    public void write_name() throws InterruptedException {
        //Finding textbox using id locator and then using send keys to write in it

        driver.findElement(By.id("fname")).sendKeys("Kuldeep Rana");
        Thread.sleep(3000);
    }

    @Test
    public void clear_name() throws InterruptedException {
        //Clear the text written in the textbox
        driver.findElement(By.id("fname")).clear();

        Thread.sleep(3000);
    }

    @Test
    public void click_button() throws InterruptedException {
        //Clicking on button using click() command
        driver.findElement(By.id("idOfButton")).click();

        Thread.sleep(3000);
    }

    @Test
    public void click_radio_button() throws InterruptedException {
        //Find radio button by name and check it using click() function
        driver.findElement(By.id("male")).click();

        Thread.sleep(3000);
    }

    @Test
    public void checkbox_click() throws InterruptedException {
        //Find checkbox by cssSelector and check it using click() function
        driver.findElement(By.cssSelector("input.Automation")).click();

        Thread.sleep(3000);
    }

    @Test
    public void drop_down() throws InterruptedException {
        //Using Select class for for selecting value from dropdown
        Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
        dropdown.selectByIndex(1);
        dropdown.selectByIndex(2);
        dropdown.selectByVisibleText("Automation Testing");
        //Thread.sleep(50000);
    }
    @Test
    public void click_male() throws InterruptedException{
        WebElement clickonmale = driver.findElement(By.cssSelector("#male"));
        clickonmale.click();
        Thread.sleep(2000);

    }
    @Test
    public void dropdown() throws InterruptedException{
        Select testing_type = new Select(driver.findElement(By.id("testingDropdown")));
        List<WebElement> options = testing_type.getOptions();
        for (WebElement n:
             options) {
            System.out.println(n.getText());
        }


        //testing_type.selectByIndex(1);
        //testing_type.selectByIndex(2);
        //testing_type.deselectByIndex(3);

    }

    @After
    public void quit() {
        //Close the browser
        driver.close();

    }

}

