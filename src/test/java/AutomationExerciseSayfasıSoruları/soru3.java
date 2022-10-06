package AutomationExerciseSayfasıSoruları;

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

public class soru3 {
    /*
    1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' url'sine gidin
3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
6. Yanlış e-posta adresi ve şifre girin
7. 'Giriş' düğmesini tıklayın
8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
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


    }
    @Test
    public void test1(){
        // 1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed();

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        //System.out.println(driver.findElement(By.xpath("//*[text()='Login to your account']")).getText());
        driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();

        //6. Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[1]"))
                .sendKeys("akhisar@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("12345");
        //7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();
        //8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür

        WebElement dogrulama=driver.findElement(By.xpath("//*[@style='color: red;']"));
        Assert.assertTrue(dogrulama.isDisplayed());
        // String metin="Your email or password is incorrect!";
       // Assert.assertTrue(metin,dogrulama);

    }
}
