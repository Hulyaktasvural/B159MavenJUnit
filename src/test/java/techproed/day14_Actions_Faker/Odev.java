package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Odev extends TestBase {
    @Test
    public void test01() {
        //  1- "http://webdriveruniversity.com/Actions" sayfasina gidin
      driver.get("http://webdriveruniversity.com/Actions");

        //  2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        //  3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        bekle(2);

        //  4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //  5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(2);

        //  6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldKutusu = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHoldKutusu).perform();
        bekle(2);

        //  7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldKutusu.getText());

        //  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClickMeButonu = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickMeButonu).perform();
        bekle(2);

    }
}
