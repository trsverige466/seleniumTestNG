package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q3 {
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
//-->Task1 Find Dropdown on Multi Selection
//-->Task2 Find Dropdown Elements
//-->Task3 printout DropDown Elements' number
//-->Task4 choose all dropdown elements and printout dropdown elements' name
//-->Task5 check until choise 6'
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

    }
    @Test
    public void test(){

    }

}
