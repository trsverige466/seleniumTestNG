package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
public class Q6 {
    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"
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
        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        // click  "Alert with OK" and click 'click the button to display an alert box:'
        WebElement click = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        click.click();
        // accept Alert(I am an alert box!) and print alert on console
        driver.switchTo().alert();
        String alertMessage1=driver.switchTo().alert().getText();
        System.out.println("Alert Text : "+alertMessage1); //Alert Text : I am an alert box!
        driver.switchTo().alert().accept();
        // cancel Alert  (Press a Button !)
        //1.yol
        // driver.switchTo().alert().dismiss();
        //2.yol
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        Thread.sleep(3000);
        // and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProeducation");
        driver.switchTo().alert().accept();
        // finally print on console this message "Hello TechproEducation How are you today"
        String expectedMessage= "Hello TechProeducation How are you today";
        String actualmessageLast = driver.findElement(By.id("demo1")).getText();
        System.out.println("System Message: "+actualmessageLast); //System Message: Hello TechProeducation How are you today
        Thread.sleep(2000);
        Assert.assertEquals(actualmessageLast,expectedMessage);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}