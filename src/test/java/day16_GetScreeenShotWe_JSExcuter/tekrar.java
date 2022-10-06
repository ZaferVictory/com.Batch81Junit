package day16_GetScreeenShotWe_JSExcuter;

import Utulities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class tekrar extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

       WebElement ilkresimresmi= driver.findElement(By.xpath("(//*[@class='a-cardui fluid-quad-card fluid-card fluid-quad-image-label fluid-quad-image-label'])[1]"));

        File ilkresim=ilkresimresmi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ilkresim,new File("target/ekrangoruntusu/bilgisayar"+tarih+".jpg"));

        //
        //*[@id='w8dpOckmkJ17ZeFZ9kHZ7Q']
    }
}
