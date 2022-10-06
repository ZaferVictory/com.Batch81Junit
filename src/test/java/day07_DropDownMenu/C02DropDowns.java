package day07_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02DropDowns {

     /*
          ●https://www.amazon.com/ adresinegidin.
          -Test1
          Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
          oldugunu testedin
          -Test2
          1.Kategori menusunden Books seceneginisecin
          2.Arama kutusuna Java yazin vearatin
          3.Bulunan sonuc sayisiniyazdirin
          4.Sonucun Java kelimesini icerdigini testedin
*/

    WebDriver driver;
    Select select;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //          oldugunu testedin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        /*
        dropdown menuye ulasmakk ıcın select clasından bir obje olustururuz
        ve locate ettıgımız  dropdown web elementini select clasına tanımlarız ve
        getOption metodunu kullanarak dropdown' bir liste atarak menunun butun elemanlarını sayısına ulabiliriz
         */
        List<WebElement>ddmL=select.getOptions();
        System.out.println(ddmL.size());
        int expectedsayi=45;
        int actualDds=ddmL.size();//buraya 28 de yazabillirdim
        Assert.assertNotEquals(expectedsayi,actualDds);
    }
    @Test
    public  void test2(){
        // 1.Kategori menusunden Books seceneginisecin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select= new Select(ddm);
        select.selectByVisibleText("Books");//en cok kullanacagız bu eger dropdown dakı menuye string olarak
                                            // ulasmak ıstersek bu menuyu kullanırız

        System.out.println(select.getFirstSelectedOption().getText());// dropdown menude  sectiğimiz option a ulasmak ıstersek select.getFirstSelectedOption()
                                                                      // metodunu kullanırız

        //select.selectByIndex(5);// buda aynı sonucu verir.index ile ulasmak ıstersek bunu kullanırız
        //select.selectByValue("search-alias=stripbooks-intl-ship");>> burada da value ile yaptık.value yi direk aldık
                                                                    //>>ve yapıstırdık

        // 2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // 3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }

}
