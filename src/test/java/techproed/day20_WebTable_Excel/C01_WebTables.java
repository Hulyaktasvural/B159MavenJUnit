package techproed.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    /*
    WEBTABLE;
        <table> tagı ile başlar
            <thead> başlıklar için bu tag ile devam eder
                <tr> başlıkların satırı
                <th> table head
                    <td> başlıktaki veriler
                <tbody> başlıklar altındaki verileri temsil eder
                        <tr> table row(satır)
                            <td> table data (tablodaki veri)

     */
    @Test
    public void test01() {
        extentReport("Chrome", "WebTable");
        extentTest= extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdırıldı");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*********************************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3. Satır verileri yazdırıldı");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatır = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
                                                //last() --> İstenene göre son satır yada sütun bilgilerini verir
        System.out.println("1.Tablo Son Satır Bilgileri : "+ sonSatır.getText());
        extentTest.info("Son satır verileri yazdırıldı");

        //    Task 4 : 5. Sütun verilerini yazdırın
        System.out.println("**************************");
        WebElement beşinciBaşlık = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("beşinci sütun başlığı :" + beşinciBaşlık.getText()); //-->5.sutun başlığı
        List<WebElement> beşinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        beşinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5.Sütun verileri yazdırıldı");

        // Task 5: 3.Satırdaki 1. ve 2. sütun bilgilerini yazdırınız
        System.out.println("*************************");
        List<WebElement> üçüncüSatır = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        üçüncüSatır.forEach(t-> System.out.println(t.getText()+"\t"));
        extentTest.info("3.Satırdaki 1. ve 2. sütun bilgileri yazdırıldı");

        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();
        //WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));//fbach@yahoo.com
        printData(2,3);
        extentTest.info("2.Satır 3.sütun bilgileri yazdırıldı");

        //3.satır 2.sütun bilgisinin Jack olup olmadığını doğrulayın
        printData(3,2);
        String actualData = printData(3,2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3.Satır 2.sütun bilgisinin Jack değil,Jason olduğu görüldü");
        extentTest.pass("Sayfa Kapatıldı");
        extentReports.flush();

    }

    private String printData(int satır, int sütun) {
        WebElement satırSütun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satır+"]//td["+sütun+"]"));
        return satırSütun.getText();
    }

    //ÖDEV
    //C01_WebTables class'ı için aldığımız rapora gidelim
    //NOT:driver.get("testOutput/extentReports/extentReport_01_51_13_06082023.html")
    //Başlığın Extent Report olduğunu test edelim
    //Rapor temasını dark yapalım
    //Dashboard bölümüne gidip tabloyu yazdırınız
    //Tester'ın "isminiz" olduğunu doğrulayalım
    //Sayfayı kapatalım

}
