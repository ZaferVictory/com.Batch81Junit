package day10_Actions;

import Utulities.TestBaseBeforeClassAfterClass;
import org.junit.Test;

public class C02_ilktestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){
        driver.get("https://amazon.com");
    }
}
