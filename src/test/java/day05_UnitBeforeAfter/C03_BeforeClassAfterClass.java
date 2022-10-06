package day05_UnitBeforeAfter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
BeforeClass ve AfterClass notasyonlari kullaniyorsak
olusturacagimiz method'u static yapmammiz gerekiyor.before ve afterdan farkı bu
 */

    static  WebDriver driver;
    @BeforeClass// notasyon olusturduk bunun adı bu
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static  void tearDown(){
        driver.close();
    }
    @Test
    @Ignore("zaferin testi")// test olmasını ıstemediğim yere  @test notasyonun altına @Ignore yazıyoruz
                            // gordugun gıbı ıgnorun yanına () iççinde acıklama yapılabılır.

    public void method1(){// burada static yapmadım bu afterclass ve before class da gecrli
        driver.get("https://www.amazon.com");
    }
    @Test
    public void method2(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("https://www.hepsiburada.com");

        /*
        >>>>>>onemlı before after yada
        >>>>>>onemli beforeclass afterclass
        >>>>>> bu ıkısınden hangısını istersem onu kullan hoca ıkıncıyı pek kullanmadım dedi
         */
    }
}
