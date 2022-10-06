package day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
    https://the-internet.herokuapp.com/windows adresine gidin.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    Click Here butonuna basın.
    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

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
       driver.quit();
    }
    @Test
    public void Test1(){
//Tests package’inda yeni bir class olusturun: WindowHandle2
//    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
//    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
//    Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
        bir web sitesine gittiğinizde bir web elementi tıkladıgınızda yeni bir sekme ya da pencere acılırsa bu yenı acılan
        sekmenın handle degerını bulabılmek ıcın drıver.getWindowHandles() metodunu bir arry liste atıp butun sayfaların listesine ulasabilirim.
        ilk actıgım pencerenın index i sıfırdır. 2. acılan sekmenin index i birdir. 2. acılan pencerede ya da sekmede  işlem yapabılmek ıcın
        driver.swicthTo().Window(Listadi.get(1)) metodunu kullanırız
         */
        List<String>windowList=new ArrayList<String>(driver.getWindowHandles());
        System.out.println("window handle degerleri = "+windowList);
        driver.switchTo().window(windowList.get(1));

//    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(),"New Window");

//    Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
//    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet", driver.getTitle());

}

}