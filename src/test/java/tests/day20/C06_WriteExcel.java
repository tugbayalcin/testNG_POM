package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel
{
    @Test
    public void test01() throws IOException {
        // ulkeler excel'ine 5. sutun olarak nufus sutunu ekleyelim
        // 3. satirdaki ulkenin nufusunu 1000000 yapalim

        // 1.dosyaya ulasalim
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        // 2.class'ta calismak icin dosyanin bir kopyasi olan workbook'u olusturalim
        Workbook workbook = WorkbookFactory.create(fis);
        // bu workbook ulkeler excell'inin kendisi degildir
        // u class'daki kopyasidir !!!

        // 3.dosyada yapmak istedigimiz degisiklikleri kopya workbook uzerinde yapalim
        // ilk satirin 5. hucresine NUFUS basligini yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        // degisikliklerimizi ekledik

        // 3. satirdaki ulkenin nufusunu 1000000 yaptik
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");

        // 4.kopyada yaptigimiz degisiklikleri ana dosyaya kaydedelim
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        // EXCEL ACIK IKEN CALISTIRIRSAN DOSYAYI BOZARSIN, EXCEL KAPALI IKEN CALISTIRMALISIN !!!!!!!!!
    }
}
