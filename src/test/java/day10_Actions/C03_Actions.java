package day10_Actions;

import Utulities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){
        //amazon sayfasına gıdelım
        driver.get("https://www.amazon.com");
        // acount menusunden create a list linkine tıklayalım
        WebElement accountList=driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        driver.findElement(By.xpath("(//*[@class='nav-link nav-item'])[1]")).click();




    }
}
