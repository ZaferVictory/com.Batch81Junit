package day14_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    /*
    //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
     */
    @Test
    public  void test() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/resources/ulkeler (1).xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyayolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 15, kullanilan satir sayisinin ise 4 oldugunu test edin
        int sonsatır=workbook.getSheet("sayfa2").getLastRowNum();
        System.out.println(sonsatır);
        int expectedLastRow=6;
        Assert.assertEquals(expectedLastRow,sonsatır+1);// benden 6. satırı istiyor o yuzden 1 ekledim
        int kullanılansatır=workbook.getSheet("sayfa2").getPhysicalNumberOfRows();//kullanılan satır sayısını verir
        System.out.println(kullanılansatır);
        int expectedkullanılansatır=4;
        Assert.assertEquals(expectedkullanılansatır,kullanılansatır);

    }
}
