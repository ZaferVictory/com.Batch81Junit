package day09_Iframe_WindowHandle;

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

public class C01Iframe {

     /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */
     WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.close();

    }
    @Test
    public void test1() throws InterruptedException {
        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());
        //○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textbox=driver.findElement(By.id("mce_0_ifr"));// frame geciş yapmadan once orayı ıd ile locate ederim
        driver.switchTo().frame(textbox);//sonrada locate ettğimi frame gecmek için bu metodu kullanırız.
        WebElement textboxFrame= driver.findElement(By.xpath("//p"));//merhaba dunya yazdırabılmek için tekrar locate ettim
        textboxFrame.clear();// clear metodu text box ın içini temizler
        Thread.sleep(2000);
        textboxFrame.sendKeys("merhaba dunya");
        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin

        driver.switchTo().defaultContent();// ıframe den cıkıp ana sayfaya gecmek ıcın bu metod kullanılır.
                                            // bunu yapmadan alttakını yazdırmaz
        WebElement ElementFrame=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(ElementFrame.isDisplayed());
        System.out.println(ElementFrame.getText());
        WebElement linkiver=driver.findElement(By.partialLinkText("Elemental Selenium"));
        System.out.println(linkiver);



        /*nadir de olsa karsılarsınız dedı hoca frameler hakkjnda */

    }
}
