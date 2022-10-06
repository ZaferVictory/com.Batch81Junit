package day10_Actions;

import Utulities.TestBaseBeforeAfter;
import org.junit.Test;

public class C01ilktestbaseclass extends TestBaseBeforeAfter {

    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
    }
}
