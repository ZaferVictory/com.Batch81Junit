package day05_UnitBeforeAfter.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev3 {
    /*
    1. “https://www.saucedemo.com” Adresine gidin
            2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin

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
    public void test1() throws InterruptedException {
      //  1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
      //  2. Username kutusuna “standard_user” yazdirin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
      //  3. Password kutusuna “secret_sauce” yazdirin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
      //  4. Login tusuna basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
      //  5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        Thread.sleep(1000);
       String isminikaydet=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
       driver.findElement(By.xpath("(//*[@class='inventory_item_img'])[1]")).click();
      //  6. Add to Cart butonuna basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
      //  7. Alisveris sepetine tiklayin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
      //  8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Thread.sleep(1000);
       String dogrula=driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
       if (isminikaydet.equals(dogrula)){
           System.out.println("urun basarılı passed");
       }else{
           System.out.println("urun basarısız failed");
       }

      //  9. Sayfayi kapatin
    }
}
