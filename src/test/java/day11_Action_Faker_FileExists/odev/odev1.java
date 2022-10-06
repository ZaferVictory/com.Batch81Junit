package day11_Action_Faker_FileExists.odev;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class odev1 extends TestBaseBeforeAfter {
    /*
    Bir Class olusturalim KeyboardActions2
    https://html.com/tags/iframe/ sayfasina gidelim  3- video’yu gorecek kadar asagi inin
    videoyu izlemek icin Play tusuna basin
    videoyu calistirdiginizi test edin

     */

    @Test
    public void test1() throws InterruptedException {
        //Bir Class olusturalim KeyboardActions2

        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 3- video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
                .perform();
        //videoyu izlemek icin Play tusuna basin

        List<WebElement> list=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(list.get(0));
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //videoyu calistirdiginizi test edin
        Thread.sleep(2000);
        WebElement youtubeLinki=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLinki.isDisplayed());
        driver.switchTo().defaultContent( );


    }
}
