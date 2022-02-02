package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebelement extends TestBase {

    @Test
    public void nutellaTesti() throws IOException, InterruptedException {
        // amazon sayfaina gidem
        driver.get("https://www.amazon.com");

        // nutella için arama yapalım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        // sonuçların nutella içerdigini test edelim.
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucSayisiStr=sonucYazisiElementi.getText();
        Assert.assertTrue(sonucSayisiStr.contains("nutella"));

        // testin calistiginin ispati icin sonuc yazisi webelementinin screenshot'ini alalim
        // tum sayfa screenshot icin 4 adim gerekli

        // 1.adim screenshot cekecegimiz webelemnti locate edelim
        // yukarida etmistik

        // 2. adim screenshot'i kaydedecegimiz bir file olusturalim
        File webelementSS=new File("target/screenShot/webelement.jpeg");

        // 3. adim gecici dosya olustur
        File geciciResim=sonucYazisiElementi.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici resmi kayit yapacagimiz asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,webelementSS);


        Thread.sleep(3000);
    }
}
