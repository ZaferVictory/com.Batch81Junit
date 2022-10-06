package day14_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class tekrar {
    @Test
            public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler (1).xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosFileInputStream fis = new FileInputStream(dosyaYolu);
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-Turkce baskentler sutununu yazdiralim
       int sonsatır=workbook.getSheet("sayfa1").getLastRowNum();
        System.out.println(sonsatır);
        String turkcebaskenler="";
        int count=1;
        for (int i = 0; i <=sonsatır ; i++) {
            turkcebaskenler=workbook.getSheet("sayfa1").getRow(i).getCell(3).toString();
            System.out.println(count+ turkcebaskenler);
            count++;
        }



        }





    }


