package day16_GetScreeenShotWe_JSExcuter;

import Utulities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExcutor extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Aşağıdaki carrers butonunu görünceye kadar js ile scroll yapalım
        WebElement carrers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);//Locate ettiğimiz carrers kısmı  görünene kadar
                                                                              // mouse'un aşağı-yukarı tuşları ile web sayfasını kaydır.
        //Carrers butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",carrers);
    }
}
