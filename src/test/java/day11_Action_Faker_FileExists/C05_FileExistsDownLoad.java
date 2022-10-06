package day11_Action_Faker_FileExists;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistsDownLoad extends TestBaseBeforeAfter {
    /*
https://the-internet.herokuapp.com/download adresine gidelim.
test.txt dosyasını indirelim
Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

     */

    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\TR\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // indirildiğini konsolda gosterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));



    }

}
