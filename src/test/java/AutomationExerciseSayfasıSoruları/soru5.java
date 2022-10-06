package AutomationExerciseSayfasıSoruları;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class soru5 extends TestBaseBeforeAfter {

    /*1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' url'sine gidin
3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
6. Adı ve kayıtlı e-posta adresini girin
7. 'Kaydol' düğmesini tıklayın
8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür

     */

    @Test
    public void test1() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        //6. Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.xpath("//*[@placeholder=\"Name\"]")).sendKeys("tepe");
        actions.sendKeys(Keys.TAB).sendKeys("akhisarli@gmail.com").

        //7. 'Kaydol' düğmesini tıklayın
        sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());



    }
}
