package tests.day20;

import org.apache.poi.ss.usermodel.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel
{
    @Test
    public void test01() throws IOException {

        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        // bu satir ile excel'deki veriler selale oldu akti fis icinde toplandi ama bu hala bbenim kullanabailecegim formatta degil

        // workbook icin maven'dan kutuphane almamiz gerekiyor
        // apache poi dependency aliyoruz, ustteki 2 tanesini de aliyoruz
        // ikisi de ayni sey, birbirlerini tamamliyorlar

        Workbook workbook = WorkbookFactory.create(fis);
        // burada new ile obje uretmiyoruz
        // workbook icerisine fis yardimiyla okudumuz bilgileri getirdik
        // workbook okuyacagimiz excel dosyasinin kopyasi olarak dusun
        // okudugummu buraya yazacagim
        // sanirim tum office belgelerini workbook ile okuyabiliyoruz, hoca da tam bilmiyormus
        Sheet sheet = workbook.getSheet("Sayfa1");
        // burada workbook objesi uzerinden sheet olusturuyoruz
        // workbook'un sheetleri olarak dusun
        // once sayfayi acacagiz
        Row row = sheet.getRow(4); // burasi index'tir 0'dan baslar
        // simdi de sayfadaki hangi satiri okumak istedigimizi belirtiyoruz
        // workbook'u acmistik, okuyacagimiz sayfaya geldik, okuyacagimiz satira geldik
        // simdi de satirdaki okumak istedigimiz hucreye bakacagiz
        Cell cell = row.getCell(2); // burasi index'tir 0'dan baslar

        // simdi yukarida 4. satirin 2. datasini okumak istedigimizi soylemisiz
        // bunu yazdirmayi deneyelim
        System.out.println(cell);

        /*
            Biz fileinputStream ile okudugumuz excel dosyasini projemiz icerisinde kullanabilmek icin apache poi dependency
            yardimiyla bir workbook olusturduk

            Bu workbook bizim projemizin icerisinde ulkeler excel'inin bir kopyasini kullanmamizi sagliyor

            Excel'in yapisi geregi bir hucreye(cell) ulasabilmek icin workbook'dan baslayarak sirasiyla
            sheet > row > cell objeleri olusturmamiz gerekiyor

         */

        //  index'i 4 olan satirdaki index'i 2 olaan hucrenin Andorra oldugunu test ediniz
        String expectedData = "Andorra";

        Assert.assertEquals(cell.getStringCellValue(),expectedData);
        // urada cell objesinden gelen ogenin data type'i Cell'dir
        // bzim expected result'imiz ise string
        // dolayisiyla bir donusum yapmadan test etmeye kalkarsak
        // expected da actual da Andorra olmasina ragmen failed olur cunku type'lari farki
        // o yuzden ya cell.toString() diyecegiz ya da cell.getStringCellValue() diyecegiz

        // 5. indexteki satirin, 3. indexteki hucre bilgisini yazdiralim
        row = sheet.getRow(5);
        cell = row.getCell(3);
        System.out.println(cell);





    }
}
