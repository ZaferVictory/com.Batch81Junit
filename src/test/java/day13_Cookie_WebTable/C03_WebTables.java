package day13_Cookie_WebTable;

import Utulities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
/*
Bir onceki class'taki adrese gidelim
login() methodunu kullanarak sayfaya giris yapalim
input olarak verilen satir ve sutun sayisina sahip
cell'deki texti yazdiralim.
Price baslıgındakı tum numaraları yazdırınız

int satir = 3;
int sutun = 4;

 */

    @Test
    public void test1() {
        //Bir onceki class'taki adrese gidelim
        //login() methodunu kullanarak sayfaya giris yapalim
        login();
        int satir = 3;
        int sutun = 4;
        //input olarak verilen satir ve sutun sayisina sahip cell'deki texti yazdiralim.
        WebElement cell= driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("satır ve sutundakı text :"+ cell.getText());
        //price baslıgındakı tum numaraları yazdırınız
        List<WebElement> pricebaslıgı=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w:pricebaslıgı) {
            System.out.println("price değerleri "+ w.getText());

        }



    }

    private void login() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
