package AutomationExerciseSayfasıSoruları;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class soru2 {
    /*
   1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' url'sine gidin
3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
6. Doğru e-posta adresini ve şifreyi girin
7. 'Giriş' düğmesini tıklayın
8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
9. 'Hesabı Sil' düğmesini tıklayın
10. 'HESAP SİLİNDİ!' görünür

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
        driver.close();
    }
    @Test
    public void test1(){
       //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed();

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();

        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[1]"))
                .sendKeys("akhisarli@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("12345678");
        //7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();

        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed();

        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[2]")).click();

        //10. 'HESAP SİLİNDİ!' görünür
        driver.findElement(By.xpath("//*[@class='btn btn-danger button-form js-tooltip']")).click();
        driver.findElement(By.xpath("//*[text()='Delete Account']")).isDisplayed();
    }
}
