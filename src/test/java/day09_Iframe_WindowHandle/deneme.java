package day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class deneme {
    /*
     ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
            ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
            ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    dogrulayin ve konsolda yazdirin

     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void teardown(){
        //driver.close();
    }
    @Test
    public void test1(){

        //Tests package’inda yeni bir class olusturun: WindowHandle2
        //    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
          WebElement text=driver.findElement(By.xpath("//*[text()='Opening a new window']"));
               Assert.assertTrue(text.getText().contains("Opening a new window")); ;
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());

        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //    Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> handlelistesi=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handlelistesi.get(1));

        //    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertTrue(driver.getTitle().contains("New Window"));

        //    Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement text1=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text1.getText().contains("New Window"));
        //    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(handlelistesi.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

    }
}
