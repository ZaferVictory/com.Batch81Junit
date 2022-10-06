package day07_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev {
/*
1. http://zero.webappsecurity.com/ Adresine gidin
            2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

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
    public  void teardown(){
    //driver.close();
    }
    @Test
    public void test1(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //6. Pay Bills sayfasina gidin
        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. “amount” kutusuna bir sayi girin
        //10. “US Dollars” in secilmedigini test edin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.


        /* siteye girilemiyor soru yarım kaldı*/
    }
}

