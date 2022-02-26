package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonMainPage
{
    // Bir page class'i actigimizda ilk yapmmamiz gereken sey, parametresiz bir constructor olusturup
    // bu constructor icinde Pagefactory ile driver'a ilk deger atamasini yapmak olmalidir

    public AmazonMainPage(){
        PageFactory.initElements(Driver.getDriver(),this); // bizim driver'imizi burada da kullanilabilir hale getiriyor
        // normalde bizim driver'imiz baska class'ta idi, artik burada da kullanabiliyoruz
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonAramaKutusu;
    // bir daha amazon'un arama kutusunu locate etmeyecegiz :)

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;


}
