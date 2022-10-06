package day12_Actions_FileExistUpload_SenkronizasyonWait;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_FileExistUpload extends TestBaseBeforeAfter {

    @Test
    public void test1() {


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyasec= driver.findElement(By.xpath("//*[@name='file']"));//burada click yapamadık. direk yukledik dosyayı
        /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */
        //Yuklemek istediginiz dosyayi secelim.
        String dosyayolu="C:\\Users\\TR\\Downloads\\test.txt";
        dosyasec.sendKeys(dosyayolu);
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue( driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
