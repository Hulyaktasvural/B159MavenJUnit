package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        /*
        Cookie'leri listemek istersek
                driver.manage().getCookies() methoduyla bir Set yada ArrayList'e atarak listeleyebiliriz
         */
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println); -->Lambda ile Cookie'leri yazdırdık
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w: cookieSet){
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". cookieName : "+w.getName()); //-->Sadece Cookie'lerin isim'lerini alırız
            System.out.println(sayac+". cookieValue : "+w.getValue()); //-->Sadece Cookie'lerin value'lerini alırız
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookie'lerin Sayısı = "+cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue =driver.manage().getCookieNamed("i18n-prefs").getValue();
        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gerçek değerini actualCookieValue değişkenine assing ettik
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test
        cookieSet = driver.manage().getCookies();
        for (Cookie each :cookieSet){
            System.out.println(each);
        }
        Assert.assertEquals("cikolatali",driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println("Cookie'lerin sayısı = "+cookieSet.size());
        System.out.println("Cookie'lerin sayısı = "+Arrays.stream(driver.manage().getCookies().toArray()).count());

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenÖnce = cookieSet.size();
        System.out.println("silinmedenÖnce = " + silinmedenÖnce);
        bekle(2);
        driver.manage().deleteCookieNamed("skin"); //-->ismi skin olan cookie'i sildik
        bekle(2);
        cookieSet = driver.manage().getCookies(); //Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        int silindiktenSonra = cookieSet.size();
        System.out.println("silindiktenSonra = " + silindiktenSonra);
        Assert.assertEquals(1,(silinmedenÖnce-silindiktenSonra));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies(); // --> Tüm cookie'leri sildik
        cookieSet = driver.manage().getCookies(); //--> Tekrar cookieSet'i güncelledik
        Assert.assertTrue(cookieSet.isEmpty());//-->Ve cookiSet'in içinin boş olduğunu isEmpty() methoduyla test ettik

    }
}
