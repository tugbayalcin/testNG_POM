package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCWebTablePage
{
    public HMCWebTablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> headerBirinciSatirDatalar;

    @FindBy(xpath = "//tbody")
    public WebElement tumBodyWeElementi;

    @FindBy(xpath = "//tbody")
    public List<WebElement> tumBodyDatalariList;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    // bu methodda dogrudan elementi dondurmek istedik
    public WebElement satirGetir(int satirNo){
        // 1. method satir numarasi verdigimde bana o satirdaki datalari yazdirsin
        // 2. satiri yazdir desek locate su sekilde olur --> //tbody//tr[2]
        // 7. satiri yazdir desek locate su sekilde olur --> //tbody//tr[7]
        String rowDynamicXpath = "//tbody//tr["+ satirNo +"]";
        WebElement satirElementi = Driver.getDriver().findElement(By.xpath(rowDynamicXpath));
        return satirElementi;
    }

    // locate'imiz mathod icerisinde oldugu icin eski usul locate yaptik
    // locate'imiz dynamic olsun diye string olarak vergidimiz lcoate'i parcaladik ve araya yine
    // string olarak algilanacak sekilde parametremizi yazdik, concate olacak,
    // bu emthodda sadece elementin tuttugu yaziyi dondurmek istedik
    public String hucreWebElementGetir(int satirNo, int sutunNo){
        // 2. satirin 4. datasinin locate'i --> //tbody//tr[2]//td[4]
        // 4. satirin 5. datasinin locate'i --> //tbody//tr[4]//td[5]
        String cellDynamicXpath = "//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";
        WebElement hucreElementi = Driver.getDriver().findElement(By.xpath(cellDynamicXpath));
        String cellData = hucreElementi.getText();
        return cellData;
    }

    public void sutunYazdir(int sutun) {
        // table'da sutun yapisi olmadigindan her satira gidipo istenilen sutuna denk gelen hucredeki datayi alacagiz

        // her bir satirdaki istenen sutun elementini yazdirabilmek icin once satir sayisini bilmeye ihtiyacimiz var
        int satirSayisi = satirlarListesi.size();
        for(int i=1; i<=satirSayisi; i++){
            System.out.println(hucreWebElementGetir(i, sutun));
        }
    }
}
