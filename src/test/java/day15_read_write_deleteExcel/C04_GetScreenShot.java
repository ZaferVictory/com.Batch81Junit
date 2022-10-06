package day15_read_write_deleteExcel;

import Utulities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        // amazon sayfasına gıdelım tum sayfanın resmını alalım

        driver.get("https://amazon.com");


       /*
        Bir web sayfanın resmini alabilmek için TakesScreenshot class'ın obje oluşturup
        Geçici bir File class'ından değişkene TakesScreenShot'dan oluşturduğum obje'den getScreenShotAs
        methonu kullanarak geçici bir file oluştururuz
         */



/*
        LocalDateTime date=LocalDateTime.now();
       // System.out.println(date); dırek yazdırdıgımda bozuk yazdırıyoer asagıdakı gibi işlem yapmam lazım
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(formatter);// dosya kaydederken noktalama işaretlerini kaydetmıyor o yuzden fotmatter yaptık
        System.out.println(date);
        System.out.println(tarih);

        bunu testbasebeforeafter claasına attım kı bir daha bir daha yazmayayım

 */

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));

    }
}
