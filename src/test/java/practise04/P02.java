package practise04;

import Utulities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        //Projemizde pom.xml dosyasının olduğunu doğrulayın => lütfen 4 dakika içinde deneyin
        String path="C:\\com.Batch81Junit\\pom.xml";// pom.xml dosyasına gıttık. sag click yaparak dosyanın uzantısını aldık sonra dogrulattık

        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
