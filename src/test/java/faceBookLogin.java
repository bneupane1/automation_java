import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

    public class faceBookLogin {
        WebDriver wd;         //wd is a variable declared which type is webDriver
        @Before                //before the @test begins start() function within @before will run
        public void start(){
            // System.setProperty("webdriver.chrome.driver","chromedriver_old.exe");
            WebDriverManager.chromedriver().setup();
            wd=new ChromeDriver();
            wd.get("https://www.facebook.com/");
            //wd.manage().window().maximize();

        }
        @Test
        public void login() throws InterruptedException {
            Thread.sleep(3000);
            //Locate Element
            WebElement facebookElement=wd.findElement(By.xpath("//*[@id=\"email\"]"));
            String email="neupanebhawana11@gmail.com";
            facebookElement.sendKeys(email);

            //Wait in Selenium
           Thread.sleep(3000);
            //password
            WebElement txtPwd = wd.findElement(By.name("pass"));  //to locate box to enter password
            txtPwd.sendKeys("abc");
            WebElement loginButton = wd.findElement(By.name("login"));
            Thread.sleep(3000);
            loginButton.click();
            Thread.sleep(10000);
            //Assertion... inbox..
            //Assertion ... SentItem..
        }

        @Test
                public void invalidPasswordLogin() throws InterruptedException {
            Thread.sleep(3000);
            //Locate Element
            //WebElement emailElement=wd.findElement(By.id("identifierId"));
            WebElement facebookElement = wd.findElement(By.xpath("//*[@id=\"email\"]"));
            String email = "neupanebhawana11@gmail.com";
            facebookElement.sendKeys(email);
            //WebElement nextButtonElement=wd.findElement(By.xpath("//*[@id='identifierNext']"));
            //nextButtonElement.click();
            //Wait in Selenium
            Thread.sleep(3000);
            //password
            WebElement txtPwd = wd.findElement(By.name("pass"));
            txtPwd.sendKeys("finance@123");
            WebElement loginButton = wd.findElement(By.name("login"));
            Thread.sleep(3000);
            loginButton.click();
            Thread.sleep(10000);

        }
        @After
        public void end(){
            wd.quit();
        }
    }


