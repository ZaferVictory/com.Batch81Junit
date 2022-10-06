package day11_Action_Faker_FileExists.odev;

import Utulities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class odev extends TestBaseBeforeAfter {
    /*
    Yeni Class olusturun ActionsClassHomeWork
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
     2- Hover over Me First" kutusunun ustune gelin
    Link 1" e tiklayin
    Popup mesajini yazdirin
    Popup'i tamam diyerek kapatin
    “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin
    8- “Double click me" butonunu cift tiklayin

     */

    @Test
    public void test1() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //     2- Hover over Me First" kutusunun ustune gelin
        WebElement usutunegel= driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions action=new Actions(driver);
        action.moveToElement(usutunegel).perform();

        //    Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        //    Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //    Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //    “Click and hold" kutusuna basili tutun
        WebElement basılıtut= driver.findElement(By.xpath("//*[@id='click-box']"));
        action.contextClick(basılıtut).perform();
        //    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(action.toString());
        //    8- “Double click me" butonunu cift tiklayin
        WebElement cifttıkla= driver.findElement(By.xpath("//*[@id='double-click']"));
        action.doubleClick().perform();

    }
}
