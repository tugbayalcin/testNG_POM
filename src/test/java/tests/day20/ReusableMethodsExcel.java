package tests.day20;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReusableMethodsExcel
{
    // Bir method olusturalim
    // Dosya yolu, sayfa ismi ve satir, hucre indeksini verince hucre bilgisini yazdirsin

    public static Cell hucreGetir(String path, String sayfaIsmi, int satirIndex, int hucreIndex)
    {
        // buradaki exception'i throws yaptirirsak methodun cagirildigi yer de firlatmak zorunda kalir
        // o yuzden surraund try-catch yapmak daha guzel
        // wprkbook create satirinda da mevcut olan try-catch'e yeni bir catch ekletmek daha guzel duruyor
        Cell cell = null;
        try {
            FileInputStream fileInoputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInoputStream);
            cell = workbook.getSheet(sayfaIsmi).getRow(satirIndex).getCell(hucreIndex);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return cell;
    }

    public static Map<String,String> mapOlustur(String path, String sayfaAdi)
    {
        //
        Map<String,String> excelMap = new HashMap();
        Workbook workbook = null;
        // ilk adim excel'de istenen sayfaya ulasmak
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int satirSayisi = workbook.getSheet(sayfaAdi).getLastRowNum();
        String key = "";
        String value = "";
        for(int i=0; i<=satirSayisi; i++) {
            // ikinci adim ,: tablodaki hucreleri map'e uygun hale donusturmek
            key = workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();
            value = workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString() +
                    ", " + workbook.getSheet(sayfaAdi).getRow(i).getCell(2).toString() +
                    ", " + workbook.getSheet(sayfaAdi).getRow(i).getCell(3).toString();

            // ucuncu adim key-value haline getirdigimiz satirlari map'e eklemek
            excelMap.put(key,value);
        }

        return excelMap;
    }
}
