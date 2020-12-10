import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gmailLoginCheckWithInvalidPassword {
    WebDriver wd;         //wd is a variable declared which type is webDriver
    @Before                //before the @test begins start() function within @before will run
    public void start(){
        // System.setProperty("webdriver.chrome.driver","chromedriver_old.exe");
        WebDriverManager.chromedriver().setup();
        wd=new ChromeDriver();  // specific implementation of WebDriver
        // you can switch to test on a different WebBrowser by using new FirefoxDriver()
        wd.get("https://www.gmail.com");
        wd.manage().window().maximize();
    }

    @Test
    public void loginwithinvalidpassword() throws InterruptedException {
        //Locate Element
        //WebElement emailElement=wd.findElement(By.id("identifierId"));
        WebElement emailtxtbox=wd.findElement(By.name("identifier"));
        String email="qatesting00567@gmail.com";
        emailtxtbox.sendKeys(email);
        WebElement nextButtonElement=wd.findElement(By.xpath("//*[@id='identifierNext']"));
        nextButtonElement.click();
        //Wait in Selenium
        Thread.sleep(5000);
        //password
        WebElement txtPwd = wd.findElement(By.name("password"));
        txtPwd.sendKeys("Test@1");                //password is invalid
        WebElement btnNext = wd.findElement(By.id("passwordNext"));
        btnNext.click();
        Thread.sleep(5000);
        String expectedTitle = "Wrong password. Try again or click Forgot password to reset it.";
        WebElement actualTitle = wd.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"));
        //Assert.assertEquals(true, wd.contains(expectedTitle), "Title is not matching");
        Assert.assertEquals(expectedTitle, actualTitle.getText());

        //Case 1: Gmail does as expected i.e. shows wrong password on screen
        // Ask page if it contains the text "Wrong Password"
        // if it contains "Wrong Password" -> Test pass
        // else -> test fail

        Thread.sleep(5000);

        //Assertion... inbox..
        //Assertion ... SentItem..
    }
    @Test
    public void loginWithInvalidUsername () throws InterruptedException{
        Thread.sleep(5000);
        wd.findElement(By.name("identifier")).sendKeys("");
        String expectedTitle = "Enter an email or phone number.";
        WebElement actualTitle = wd.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div"));
        Assert.assertEquals(expectedTitle, actualTitle.getText());


        WebElement nextButtonElement=wd.findElement(By.xpath("//*[@id='identifierNext']"));
        //nextButtonElement.click();
        Thread.sleep(5000);
        WebElement txtPwd = wd.findElement(By.name("password"));
        txtPwd.sendKeys("Test@123");
        WebElement btnNext = wd.findElement(By.id("passwordNext"));
        btnNext.click();
        Thread.sleep(5000);






    }













    @After
    public void end(){
        wd.quit();
    }
}
