package day15_read_write_deleteExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class odev {
    /*
    1.satirdaki 2.hucreye gidelim ve yazdiralim
1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
Satir sayisini bulalim
Fiziki olarak kullanilan satir sayisini bulun
Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */

    @Test
    public void test1() throws IOException {
        String dosyayolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("sayfa1").getRow(1).getCell(1));
        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String ıkıncısatır= String.valueOf(workbook.getSheet("sayfa1").getRow(1).getCell(1));
        System.out.println(ıkıncısatır);
        //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedcell="Kabil";
        String actualcell= String.valueOf(workbook.getSheet("sayfa1").getRow(1).getCell(3));
        Assert.assertEquals(expectedcell,actualcell);

        //Satir sayisini bulalim
        int sonsatır=workbook.getSheet("sayfa1").getLastRowNum();
        System.out.println(sonsatır);

        //Fiziki olarak kullanilan satir sayisini bulun
          int fiziki=  workbook.getSheet("safa1").getPhysicalNumberOfRows();

        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    }
}
