package day10_Actions;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //Yeni bir class olusturalim: MouseActions1

        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizgilialan= driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgilialan).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
       String actual= driver.switchTo().alert().getText();
        System.out.println(actual);
       String expected="You selected a context menu";
        Assert.assertTrue(actual.contains(expected));

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
            Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    /*
     @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Cizili alan bölümün uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        //Tamam diyerek alert’i kapatalim
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());

        bu hocanın yaptıgı
     */
    }
}
