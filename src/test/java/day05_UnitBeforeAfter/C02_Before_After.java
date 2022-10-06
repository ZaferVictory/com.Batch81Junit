package day05_UnitBeforeAfter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Before_After {

    // @Before kullaniyorsak method icin istedigimiz ismi kullanabiliriz ancak genel olarak kullanımı setUp seklindedir
    //@Before kullandığımızda testlerimizden önce yapmak zorunda oldugumuz driver objelerini yazmak yerine @Before ile bir kere yazarız
    //yani her testten önce burayı calıstır, sonra testlerimizi calıstır.
    // diğer testlerimizde rahat kullanabilmek icin bunu class seviyesinde tanımlamamız gerekir.
    //driver objesini direk kullanabilmek icin class seviyesine WebDriver driver yaz!!

    WebDriver driver;
    @After
    //After notasyonu her testten sonra çalışır
    public void tearDown() {
        driver.close();
    }
    @Before
    // Before notasyonu her testten önce çalışır
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1() {
        //1 sıra before methodu çalışır
        driver.get("https://amazon.com");//2.sıra burası calısır.test metodlarının hepsınde böyle devam edıyor
        //3.sırada da burası calısır.
    }
    @Test
    public void method2() {
        //1 defa before methodu çalışır
        driver.get("https://techproeducation.com");
        //1 defa da after methodu çalışır
    }
    @Test
    public void method3() {
        //1 defa before methodu çalışır
        driver.get("https://hepsiburada.com");
        //1 defa da after methodu çalışır
    }

}


