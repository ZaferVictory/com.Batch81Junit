package day10_Actions;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_Actionns extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        //Actions actions = new Actions(driver);
        //Extends yaptığımız TestBase Class'da Actions clasını oluşturduğumuz için direk objeyi burda kullandık
        Thread.sleep(2000);
        actions.dragAndDrop(dragMe,dropHere).perform();
        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}
