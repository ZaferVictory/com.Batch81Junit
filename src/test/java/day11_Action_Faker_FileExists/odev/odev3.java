package day11_Action_Faker_FileExists.odev;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class odev3 extends TestBaseBeforeAfter {
    /*
    -  amazon gidin
Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
dropdown menude 40 eleman olduğunu doğrulayın
Test02
dropdown menuden elektronik bölümü seçin
arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
sonuc sayisi bildiren yazinin iphone icerdigini test edin
ikinci ürüne relative locater kullanarak tıklayin
ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

Test03

yeni bir sekme açarak amazon anasayfaya gidin
dropdown’dan bebek bölümüne secin
bebek puset aratıp bulundan sonuç sayısını yazdırın
sonuç yazsının puset içerdiğini test edin
5-üçüncü ürüne relative locater kullanarak tıklayin
6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

Test 4

1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */

    @Test
    public void test1() {
        // -  amazon gidin
        driver.get("https://www.amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> droplist=new ArrayList<>(driver.findElements(By.xpath("//*[@id='searchDropdownBox']")));
        for (WebElement w:droplist) {
            System.out.println(w.getText());
        }
        //dropdown menude 40 eleman olduğunu doğrulayın
        int actualsayı=droplist.size();
        int expextedsayı=40;
        Assert.assertNotEquals(actualsayı,expextedsayı);

    }

    @Test
    public void test2() {

        //Test02
        driver.get("https://www.amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
        WebElement sonucsayisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucsayisi.getText());

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucsayisi.getText().contains("iphone"));

        //dorduncu ürüne relative locater kullanarak tıklayin.
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[5]")).click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String title=driver.getTitle();
       WebElement sepet= driver.findElement(By.xpath("(//*[@class=\"nav-line-2\"])[3]"));
       sepet.click();
       sepet.sendKeys(title);

    }
}
