package day07_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_ {
    /*
    Bir class oluşturun: DropDown
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Tüm dropdown değerleri(value) yazdırın
    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.

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
    public void test1(){

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dropdown");

        //    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ındex=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(ındex);
        select.selectByIndex(1);
        //ındex.sendKeys("Option 1");// 2.yontem de nu
        System.out.println(select.getFirstSelectedOption().getText());//option 1 i yazdıracak
        System.out.println("===================================");

        //    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());// option 2 yazdıracak
        System.out.println("===================================");

        //    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("===================================");

        //    Tüm dropdown değerleri(value) yazdırın.
      //  List<WebElement> butunDropDown=driver.findElements(By.xpath("//option"));
      //  butunDropDown.forEach(t-> System.out.println(t.getText()));
      //  /* hocanoın yaptıgı bu*/

       WebElement dropdegerler=driver.findElement(By.xpath("//*[@id='dropdown']"));
       select=new Select(dropdegerler);//select clası olusturarak select variable'nin ıcıne drop degerleri attım
       List<WebElement> dropdegerlerlist=select.getOptions();//onları da list'in içine attım
       System.out.println(dropdegerlerlist.size());// oda size'sini 3 olarak dondurdu
       for (WebElement w:dropdegerlerlist) {//burada da her bir elementi for each ile aldım ve yazdırdım
           System.out.println(w.getText());

            //dropdegerlerlist.forEach(t-> System.out.println(t.getText()));>> lambda ıle yazılımı bu sekılde


        }
        //    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //    False yazdırın.
        System.out.println("drop down boyutu: "+dropdegerlerlist.size());

       if (dropdegerlerlist.size()==4){
           System.out.println("true");
       }else System.out.println("false");
       Assert.assertNotEquals(dropdegerlerlist.size(),4);


    }

}