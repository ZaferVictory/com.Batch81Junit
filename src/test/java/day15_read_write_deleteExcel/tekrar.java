package day15_read_write_deleteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class tekrar {
    @Test
    public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyayolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet=workbook.getSheet("sayfa1");
        Row row=sheet.getRow(14);
        Cell cell=row.getCell(5);

        row.removeCell(cell);

        FileOutputStream fos=new FileOutputStream(dosyayolu);
        workbook.write(fos);

    }
}
