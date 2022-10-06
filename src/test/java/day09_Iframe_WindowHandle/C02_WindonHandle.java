package day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindonHandle {
    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım
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
    public  void test1(){
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();
        /*
        eger bize verilen task'te sayfalar arası gecis varsa her driver.get() metfodundan sonra
        driver' ın window habdle degerını string bir degıskene atarız
        sonrasında farklı bir sayfaya ya da sekmeye gıttıkten sonra tekrar ilk sayfaya donmemmız ıstenırse
        String degıskene atadıgımız window handle degerlerle sayfalar arası geciş yapabiliriz
         */

//2- Url'nin amazon içerdiğini test edelim
        String actualurl=driver.getCurrentUrl();
        String expectedUrl="amazon";
        Assert.assertTrue(actualurl.contains(expectedUrl));

//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);// yeni bir pencere acmak için bu metodu kullanırız
        driver.get("https://www.bestbuy.com");
        String BestBuy= driver.getWindowHandle();
//4- title'in BestBuy içerdiğini test edelim
        String expectedTitle="Best Buy";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

//5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);// sayfalar arası gecıs için bu metod kullanılır
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);

//6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramasonucu= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKleime="java";
        String actualSonuc=aramasonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKleime));
        //7- Yeniden bestbuy sayfasına gidelim
                driver.switchTo().window(BestBuy);

//8- Logonun görünürlüğünü test edelim
      WebElement logogorunuyormu=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
      Assert.assertTrue(logogorunuyormu.isDisplayed());
//9- Sayfaları Kapatalım
        driver.quit();
    }
}
