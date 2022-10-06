package day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class odev {

    /*
    ● Bir class olusturun: IframeTest02
1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) sayfadaki iframe sayısını bulunuz.
3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
4) ilk iframe'den çıkıp ana sayfaya dönünüz
5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
tıklayınız

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
        //driver.close();

    }
    @Test
    public void Test1(){
       // ● Bir class olusturun: IframeTest02
       // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

          // 2) sayfadaki iframe sayısını bulunuz.
         List<WebElement> iflist=new ArrayList<>(driver.findElements(By.tagName("iframe")));
         System.out.println("sayfadakı iframe sayısı "+ iflist.size());
         driver.switchTo().frame(iflist.get(0));


        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

       // 4) ilk iframe'den çıkıp ana sayfaya dönünüz


       // 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
       // tıklayınız

    }


}
