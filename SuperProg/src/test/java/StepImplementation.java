import Driver.BaseTest;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.*;

import static org.junit.Assert.assertEquals;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest {
    Logger logger = LogManager.getLogger(StepImplementation.class);

    @Step("<wait> saniye bekle")
    public void waitForSecond(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    //-------------Assert
    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlId(String id, String text) {
        try {
            Assert.assertTrue("Element text değerini içerir", appiumDriver.findElement(By.id(id)).getText().contains(text));
            logger.info("İçerik görüntülenemedi");
        } catch (Exception e) {
            logger.info("İçerik görüntülenemedi");
        }
    }

    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlXpath(String xpath, String text) {
        try {
            Assert.assertTrue("Element text değerini içerir", appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
            logger.info("İçerik görüntülendi");
        } catch (Exception e) {
            logger.info("İçerik görüntülenemedi");
        }
    }

    //--------------- Click
    @Step("<selectorid> id'li elemente tıkla")
    public void clickByid(String selectorid) {
        try {
            appiumDriver.findElement(By.id(selectorid)).click();
            logger.info("İstenilen elemente tıklanıldı");
        } catch (Exception e) {
            logger.info("İstenilen elemente tıklanılamadı");
        }
    }

    @Step("<selectorxpath> xpath'li elemente tıkla")
    public void clickByXPath(String selectorxpath) {
        try {
            appiumDriver.findElement(By.xpath(selectorxpath)).click();
            logger.info("İstenilen elemente tıklanıldı");
        } catch (Exception e) {
            logger.info("İstenilen elemente tıklanılamadı");
        }
    }

    //--------------- Send Keys
    @Step("<id> id'sine <text> textini yaz")
    public void sendKeysById(String id, String text) {
        try {
            appiumDriver.findElement(By.id(id)).sendKeys(text);
            logger.info("İstenilen text yazıldı");
        } catch (Exception e) {
            logger.info("İstenilen text yazılamadı");
        }
    }

    @Step("<xpath> xpath'ine <text> textini yaz")
    public void sendKeysByXpath(String xpath, String text) {
        try {
            appiumDriver.findElement(By.xpath(xpath)).sendKeys(text);
            logger.info("İstenilen text yazılamadı");
        } catch (Exception e) {
            logger.info("İstenilen text yazılamadı");
        }
    }

    //--------------- Assertion
    @Step("check <idControl> id")
    public void controlFromId(String idControl) {

    }


    @Step("Sayfayı kaydır")
    public void scrollAction() {
        try {
            final int ANIMATION_TIME = 200;
            final int PRESS_TIME = 200;
            int edgeBorder = 10;
            PointOption pointOptionStart, pointOptionEnd;
            Dimension dims = appiumDriver.manage().window().getSize();
            pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            logger.info("Sayfa scroll edildi");
        } catch (Exception e) {
            logger.info("Sayfa scroll edilemedi");
        }
    }

        @Step("<xpath> inden  rastgele ürün seç")
        public void selectRandomProduct (String xpath){
            try {
                List<MobileElement> allProducts2 = appiumDriver.findElements(By.xpath(xpath));
                Random rand2 = new Random();
                int randomProduct2 = rand2.nextInt(allProducts2.size());
                allProducts2.get(randomProduct2).click();
                logger.info("Sayfadan rastgele ürün seçildi");
            }catch (Exception e) {
                logger.info("Sayfadan rastgele ürün seçilemedi");
            }
    }
}
