package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_SatirSayisi
{
    @Test
    public void test01() throws IOException {
        // ulkeler excel'indeki Sayfa1 ve Sayaf2'deki satir sayilarini ve kullanilan satir sayilarini bulunuz
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        int sayfa1SatirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        int sayfa1FizikiKullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        System.out.println("1. Sayfa Satir Sayisi: " + sayfa1SatirSayisi); // indexle geliyor
        System.out.println("1. Sayfa Fiziki Kullanilan Satir Sayisi: " + sayfa1FizikiKullanilanSatirSayisi); // sayma sayilari ile geliyor
        // fiziki kullanilan satir sayisi index ile degil sayma sayilari ile calisir

        int sayfa2SatirSayisi = workbook.getSheet("Sayfa2").getLastRowNum();
        int sayfa2FizikiKullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("2. Sayfa Satir Sayisi: " + sayfa2SatirSayisi); // indexle geliyor
        System.out.println("2. Sayfa Fiziki Kullanilan Satir Sayisi: " + sayfa2FizikiKullanilanSatirSayisi);

    }
}
