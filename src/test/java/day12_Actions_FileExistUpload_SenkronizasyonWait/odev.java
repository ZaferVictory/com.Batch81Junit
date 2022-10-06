package day12_Actions_FileExistUpload_SenkronizasyonWait;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class odev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a  kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        // 4.Diger window'a gecin
       List<String> windowlistesi= new ArrayList<String>(driver.getWindowHandles());
       driver.switchTo().window(windowlistesi.get(1));
        //5."username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("zafer");
        actions.sendKeys(Keys.TAB).sendKeys("1234567").

        //6."login" butonuna basin
            sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertTrue(driver.switchTo().alert().getText().contains("validation failed"));

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //Ilk sayfaya geri donun
        driver.switchTo().window(windowlistesi.get(0));
        //Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("http://webdriveruniversity.com/"));
    }
}
