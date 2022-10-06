package day15_read_write_deleteExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_readexcel {
    @Test
    public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/resources/ulkeler (1).xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyayolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //excel tablosundakı tüm tabloyu konsola yaazdırın.
        int sonsatır=workbook.getSheet("sayfa1").getLastRowNum();

        String tablo="";
        for (int i = 0; i < sonsatır; i++) {
            tablo=workbook.getSheet("sayfa1").getRow(i).getCell(0).toString()+", "+
                    workbook.getSheet("sayfa1").getRow(i).getCell(1).toString()+", "+
                    workbook.getSheet("sayfa1").getRow(i).getCell(2).toString()+", "+
                    workbook.getSheet("sayfa1").getRow(i).getCell(3).toString();
            System.out.println(tablo);
        }

    }
}
