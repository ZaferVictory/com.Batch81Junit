package day08_AllertBasicIframe;

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

public class deneme {
    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
    Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1acceptAlert(){

        //1.butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();
        // ve result mesajının “You successfully clicked an alert” oldugunu test edin.
       String resultMesajı=driver.findElement(By.xpath("//*[@id='result']")).getText();
       String mesaj="You successfully clicked an alert";

        Assert.assertTrue(mesaj.contains(resultMesajı));

    }
    @Test
    public void test2dismissAlert (){
        //2. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        // Alert üzerindeki mesajı yazdırınız
        System.out.println(driver.switchTo().alert().getText());
        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        // ve result mesajının “successfuly” icermedigini test edin.
        String ResultMesajı=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String mesajj="successfuly";

        Assert.assertFalse(mesajj.contains(ResultMesajı));

    }
    @Test
    public void test3sendKeysAlert(){
       // 3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("zafer kosktepe");
        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        // ve result mesajında isminizin görüntülendiğini doğrulayın.
       WebElement goruntuleniyorMu= driver.findElement(By.xpath("//*[@id='result']"));
       goruntuleniyorMu.getText();
       Assert.assertTrue(goruntuleniyorMu.isDisplayed());


    }
}
