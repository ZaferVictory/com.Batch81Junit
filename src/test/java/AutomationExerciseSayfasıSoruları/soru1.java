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

public class soru1 {
    /*
    1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' URL'sine gidin
            3. Giriş sayfasının başarıyla göründüğünü doğrulayın
4. 'Kayıt / Giriş' düğmesine tıklayın
5. 'Yeni Kullanıcı Kaydı!' ifadesinin görünür olduğunu doğrulayın
6. Adı ve e-posta adresini girin
7. 'Kaydol' düğmesine tıklayın
8. 'HESAP BİLGİLERİNİ GİRİN' seçeneğinin görünür olduğunu doğrulayın
9. Ayrıntıları doldurun: Unvan, İsim, E-posta, Şifre, Doğum tarihi
10. 'Bültenimize kaydolun!' onay kutusunu işaretleyin.
11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu işaretleyin.
12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Telefonu Numarası
13. 'Hesap Oluştur düğmesine' tıklayın
14. "HESAP OLUŞTURULDU!"nun görünür olduğunu doğrulayın
15. 'Devam' düğmesine tıklayın
16. "Kullanıcı adı olarak oturum açtı" seçeneğinin görünür olduğunu doğrulayın
17. 'Hesabı Sil' düğmesine tıklayın
18. 'HESAP SİLİNDİ!' ifadesinin görünür olduğunu doğrulayın ve 'Devam' düğmesini tıklayın

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
    public void steakdown(){
       // driver.close();
    }
    @Test
    public void test1(){
        // 1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Giriş sayfasının başarıyla göründüğünü doğrulayın

        //4. 'Kayıt / Giriş' düğmesine tıklayın
        WebElement kayıtgirisetıkla=driver.findElement(By.xpath("//*[@href='/login']"));
        kayıtgirisetıkla.click();

        //5. 'Yeni Kullanıcı Kaydı!' ifadesinin görünür olduğunu doğrulayın
        WebElement metinGorunuyorMu=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        metinGorunuyorMu.isDisplayed();

        //6. Adı ve e-posta adresini girin
        WebElement adıGir=driver.findElement(By.xpath("//*[@name='name']"));
        adıGir.sendKeys("tepe");
        WebElement epostagir=driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        epostagir.sendKeys("akhisarli@gmail.com");

        //7. 'Kaydol' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' seçeneğinin görünür olduğunu doğrulayın
        WebElement hesapbilgierigorunuyormu= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        hesapbilgierigorunuyormu.isDisplayed();

        //9. Ayrıntıları doldurun: Unvan, İsim, E-posta, Şifre, Doğum tarihi
           WebElement sec= driver.findElement(By.xpath("//*[@for='id_gender1']"));
           sec.click();
           WebElement passwordgir=driver.findElement(By.xpath("//*[@id='password']"));
           passwordgir.sendKeys("12345678");
           driver.findElement(By.xpath("//*[@id='days']")).sendKeys("16");
           driver.findElement(By.xpath("//*[@id='months']")).sendKeys("November");
           driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1987");

        //10. 'Bültenimize kaydolun!' onay kutusunu işaretleyin.
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        driver.findElement(By.xpath("//*[@id='optin']")).click();

        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Telefonu Numarası
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("mehmett");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("demirr");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("demiroglii");
        driver.findElement(By.xpath("//*[@name='address1']")).sendKeys("mevlana mahallesii");
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("3602 sokakk");
        driver.findElement(By.xpath("//*[@id='country']")).sendKeys("Canadaa");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Hallicee");
        driver.findElement(By.xpath("//*[@name='city']")).sendKeys("Orlandoo");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("357500");
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("125487893211");

        //13. 'Hesap Oluştur düğmesine' tıklayın
            driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        //14. "HESAP OLUŞTURULDU!"nun görünür olduğunu doğrulayın
       WebElement actual=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(actual.isDisplayed());

        //15. 'Devam' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        //16. "Kullanıcı adı olarak oturum açtı" seçeneğinin görünür olduğunu doğrulayın
        WebElement gorunuyorMU =driver.findElement(By.xpath("//*[@class='fa fa-user'] "));
        gorunuyorMU.isDisplayed();

        //17. 'Hesabı Sil' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //18. 'HESAP SİLİNDİ!' ifadesinin görünür olduğunu doğrulayın ve 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]")).isDisplayed();
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();

    }
}
