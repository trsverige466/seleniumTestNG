package tests.practice;


    import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
    public class Q5 {
        /*
            //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
            //maximize the window
            //click on action dialog button
            //if need use explicitly wait
            //click on the ok button
            //accept the alert message
         */
        WebDriver driver;
        @BeforeMethod
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @Test
        public void Test() throws InterruptedException {
            //go to web site
            driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
            //maximinize the window
            driver.manage().window().maximize();
            //click on action dialog button
            driver.findElement(By.id("action")).click();
            //if need use expicity wait
            WebDriverWait wait = new WebDriverWait( driver , Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("dialog-mycodemyway-action"))));
            //click on the ok button
            driver.findElement(By.id("dialog-mycodemyway-action")).click();
            //accept the alert message
            driver.switchTo().alert().accept();
        }
        @AfterClass
        public void tearDown(){
            driver.quit();
        }
    }

