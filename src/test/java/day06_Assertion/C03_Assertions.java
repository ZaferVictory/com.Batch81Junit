package day06_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }
    @After
    public void steackDown(){
       // driver.close();
    }
    @Test
    public void test1(){
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals(expectedTitle,actualTitle);
    }
    @Test
    public void test2(){
   //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
       // 2.yol
       // Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());


    WebElement youtubelogo=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
    Assert.assertTrue(youtubelogo.isDisplayed());
    }
    @Test
    public void test3(){
    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[3]")).isEnabled());
    }
    @Test
    public void test4(){
        //* wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String unExpectedTitle = "youtube";
        Assert.assertNotEquals(unExpectedTitle,actualTitle);
    }
}
