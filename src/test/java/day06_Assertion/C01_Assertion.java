package day06_Assertion;

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

public class C01_Assertion {

    /*
    amazon sayfasına gidelım
    3 farklı test metodu olusturalım
      a- url'nin amazon içerdiğini tetst edelim
      b- title'ın facebook içermediğini test edlim
      c- sol ust kosede amazon logosunun gorundugunu test edelim
      d- url' nin www.facebook.com oldugunu test edin
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");// her bir test sayfasında amazonu calıstırmak ıstedığim için
                                        // buraya yazdım

    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
       // a- url'nin amazon içerdiğini tetst edelim

        String expectedurl="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedurl));
    }
    @Test
    public void test2(){
    //title'ın facebook içermediğini test edelim
        String actualTitle= driver.getTitle();
        String expectedTitle="facebook";// amazon safasının facebook içermediğini biliyorum bu yuzden falseu kullandım.
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
    @Test
    public  void test3(){
        //c- sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement logo=driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test4(){
        //d- url' nin www.facebook.com oldugunu test edin
        String expectedUrl="www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
         Assert.assertNotEquals(expectedUrl,actualUrl);// eşit olmadıgını bildiğim için notequels metodunu kullandım
    }


}
