package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // ulkeler excel'inin 3. satirini yazdirin
        // satir sabit, sutunlar degisken
        String path = "src/test/java/resources/ulkeler.xlsx"; // adim 1
        FileInputStream fis = new FileInputStream(path); // adim 2

        Workbook workbook = WorkbookFactory.create(fis); // adim 3

        for(int i=0; i<4; i++){
            System.out.println(workbook.getSheet("Sayfa1").getRow(2).getCell(i).toString());
        }
        System.out.println("*****************");

        // ilk 20 ulkenin baskentlerinin turkce isimlerini yazdirin
        // sutun sabit, satirlar degisken, rowlar i ile degisecek

        for(int i=0; i<=20; i++){ // basliklar da ciksin diye 0'dan babslattik
            System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(3).getStringCellValue());
        }



    }
}
