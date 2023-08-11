package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C02_Log4j extends TestBase {
    @Test
    public void test01() {
        Logger logger = LogManager.getLogger(C02_Log4j.class);
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        logger.info("Techpro sayfasına gidildi");
        //Bende çıkmıyor
        logger.info("Sayfada çıkan reklam kapatıldı");

        //Başlığın Eğitim içerdiğini doğrulayalım
        Assert.assertFalse(driver.getTitle().contains("Eğitim"));
        logger.error("Sayfa başlığı Eğitim yazısı içermiyor");
    }
}
