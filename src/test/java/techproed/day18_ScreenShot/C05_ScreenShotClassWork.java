package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //sayfanın resmini alalım
        tumSayfaResmi();

        //Arama bölümünde java aratalım
        //driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']")).
        //        sendKeys("java", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        //WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        //webElementResmi(sonucYazisi);//-->Method ile weblement'in resmini aldık

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        tumSayfaResmi();

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement amazonSonuçYazısı = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(amazonSonuçYazısı);

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchWindow(0);
        tumSayfaResmi();

    }
}
