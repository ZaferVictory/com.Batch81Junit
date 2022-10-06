package day05_UnitBeforeAfter.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev2 {
    /*
    1-C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
            3- cookies uyarisini kabul ederek kapatin
4 Sayfa basliginin “Google” ifadesi icerdigini test edin
5 Arama cubuguna “Nutella” yazip aratin
6 Bulunan sonuc sayisini yazdirin
7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8 Sayfayi kapatin

     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        //driver.close();
    }
    @Test
    public void test1(){
        //    2-https://www.google.com/adresinegidin
        driver.get("https://www.google.com/");
        //4-Sayfabasliginin“Google”ifadesiicerdiginitestedin
        System.out.println("Title = "+driver.getTitle().contains("Google"));
        // 5-Aramacubuguna“Nutella”yazip aratin
        driver.findElement(By.xpath("//*[@jsaction='paste:puy29d;']")).sendKeys("Nutella"+ Keys.ENTER);
        // 6-Bulunansonucsayisiniyazdirin
        String[] sonucSayisi=driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonucu=sonucSayisi[1];
        System.out.println(sonucu);
        //  7-sonuc sayisinin 10milyon’dan fazla oldugunu test edin
        int cikanSonucSayisi=Integer.parseInt(sonucu.replace(".",""));//google'dan dönen sayinin aralarinda
        System.out.println(cikanSonucSayisi);                                          // nokta var,onun için replace yaptık
        if (cikanSonucSayisi>10000000) {
            System.out.println("10 milyondan fazla");
        }else System.out.println("10 milyondan az");
    }
}
