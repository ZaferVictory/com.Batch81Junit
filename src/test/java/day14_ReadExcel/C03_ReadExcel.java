package day14_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readexceltest1() throws IOException {
        /*
        belirtilen satır no ve sutun no degerlerini parametre olarak alıp
        o cell deki datayoı konsola yazdıralım.
        sonra sonucun kosolda yazanla aynı oldugunu dogrulayalım.

         */

        int satırNo=12;
        int sutun=2;
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler (1).xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        String actualData=workbook.getSheet("Sayfa1")
                .getRow(satırNo-1)//index sıfırdan basladıgı ıcın bizden istenen satıra ulasabilmemiz için bir eksiğini alırız
                .getCell(sutun-1)// burada da aynı bir eksiğini aldık. baslıktan baslıyor saymaya
                .toString();

        System.out.println(actualData);

        //sonra sonucun kosolda yazanla aynı oldugunu dogrulayalım.
        String konsoldayazan="Baku";
        Assert.assertEquals(konsoldayazan,actualData);


    }
}
