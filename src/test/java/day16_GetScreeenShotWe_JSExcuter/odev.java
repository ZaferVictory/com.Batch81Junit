package day16_GetScreeenShotWe_JSExcuter;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class odev extends TestBaseBeforeAfter {
    /*
    Yeni bir class olusturun : ScroolInto
    hotelmycamp anasayfasina gidin
2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak

asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
istediginiz oda inceleme sayfasi acildigini test  edin
     */

    @Test
    public void test1() throws InterruptedException {
       // Yeni bir class olusturun : ScroolInto
        //hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com");
        //2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak
        WebElement oda=driver.findElement(By.xpath("//*[text()='dsafsaf']"));

        actions.moveToElement(oda).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='dsafsaf']")).click();

        //asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        //istediginiz oda inceleme sayfasi acildigini test  edin
        String expectedURL="https://www.hotelmycamp.com/rooms.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(expectedURL.contains(actualUrl));

    }

    @Test
    public void test2() {
        WebElement oda=driver.findElement(By.xpath("//*[text()='dsafsaf']"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntıWiev(true):",oda);
        js.executeScript("arguments[0].click",oda);

        //istediginiz oda inceleme sayfasi acildigini test  edin
        String expectedURL="https://www.hotelmycamp.com/rooms.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(expectedURL.contains(actualUrl));
    }
}
