package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01CMIBankLogin {

    public static void main(String[] args) {

        https://www.gmibank.com adresine gidiniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.gmibank.com");
        //driver.close();

        //sign in tıkla
        driver.findElement(By.xpath("(//*[@class='dropdown-toggle nav-link'])[2]")).click();

        driver.findElement(By.xpath("//*[@id='login-item']")).click();



        // 3) Username: Batch81, Password: Batch81+
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Batch81+");

        //giriş e tıkla
        driver.findElement(By.xpath("(//*[text()='Sign in'])[4]")).click();

    }
}
