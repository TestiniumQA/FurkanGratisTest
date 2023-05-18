package com.testinium;

import com.google.appengine.repackaged.com.google.common.collect.ImmutableMap;
import com.testinium.helper.RandomString;
import com.testinium.helper.StoreHelper;
import com.testinium.model.SelectorInfo;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class StepImpl extends HookImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private static String staticVariable;
    long startTime= 0;
    static List <String> user = new ArrayList<>();
    static List <String> password = new ArrayList<>();
    String accountUser;
    String accountpassword;

    public StepImpl() {

    }


    public List<MobileElement> findElements(By by) throws Exception {
        List<MobileElement> webElementList = null;
        try {
            webElementList = appiumFluentWait.until(new ExpectedCondition<List<MobileElement>>() {
                @Nullable
                @Override
                public List<MobileElement> apply(@Nullable WebDriver driver) {
                    List<MobileElement> elements = driver.findElements(by);
                    return elements.size() > 0 ? elements : null;
                }
            });

            if (webElementList == null) {
                throw new NullPointerException(String.format("by = %s Web element list not found", by.toString()));
            }

        } catch (Exception e) {
            throw e;
        }
        return webElementList;
    }

    public List<MobileElement> findElementsWithoutAssert(By by) {

        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(by);
        } catch (Exception e) {
        }
        return mobileElements;
    }

    public List<MobileElement> findElementsWithAssert(By by) {

        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(by);
        } catch (Exception e) {
            Assertions.fail("by = %s Elements not found ", by.toString());
            e.printStackTrace();
        }
        return mobileElements;
    }


    public MobileElement findElement(By by) throws Exception {
        MobileElement mobileElement;
        try {
            mobileElement = findElements(by).get(0);
        } catch (Exception e) {
            throw e;
        }
        return mobileElement;
    }

    public MobileElement findElementWithoutAssert(By by) {
        MobileElement mobileElement = null;
        try {
            mobileElement = findElement(by);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileElement;
    }

    public MobileElement findElementWithAssertion(By by) {
        MobileElement mobileElement = null;
        try {
            mobileElement = findElement(by);
        } catch (Exception e) {
            Assertions.fail(mobileElement.getAttribute("value") + " " + "by = %s Element not found ", by.toString());
            e.printStackTrace();
        }
        return mobileElement;
    }

    public MobileElement findElementByKeyWithoutAssert(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        MobileElement mobileElement = null;
        try {
            mobileElement = selectorInfo.getIndex() > 0 ? findElements(selectorInfo.getBy())
                    .get(selectorInfo.getIndex()) : findElement(selectorInfo.getBy());
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return mobileElement;
    }

    public MobileElement findElementByKey(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);

        MobileElement mobileElement = null;
        try {
            mobileElement = selectorInfo.getIndex() > 0 ? findElements(selectorInfo.getBy())
                    .get(selectorInfo.getIndex()) : findElement(selectorInfo.getBy());
        } catch (Exception e) {
            Assertions.fail("key = %s by = %s Element not found ", key, selectorInfo.getBy().toString());
            e.printStackTrace();
        }
        return mobileElement;
    }


    public List<MobileElement> findElemenstByKeyWithoutAssert(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(selectorInfo.getBy());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileElements;
    }

    public List<MobileElement> findElemenstByKey(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        List<MobileElement> mobileElements = null;
        try {
            mobileElements = findElements(selectorInfo.getBy());
        } catch (Exception e) {
            Assertions.fail("key = %s by = %s Elements not found ", key, selectorInfo.getBy().toString());
            e.printStackTrace();
        }
        return mobileElements;
    }

    @Step({"<str> elementine <str2> degerini gir", "<str> element write <str2> text"})
    public void sendK(String str, String str2) {
        findElementWithAssertion(By.id(str)).sendKeys(str2);
    }


    @Step({"Değeri <text> e eşit olan elementi bul ve tıkla",
            "Find element text equals <text> and click"})
    public void clickByText(String text) {
        findElementWithAssertion(By.xpath(".//*[contains(@text,'" + text + "')]")).click();
    }


    @Step({"İçeriği <value> e eşit olan elementli bul ve tıkla",
            "Find element value equals <value> and click"})
    public void clickByValue(String value) {
        findElementWithAssertion(MobileBy.xpath(".//*[contains(@value,'" + value + "')]")).click();
    }

    @Step("<key> csv dosyasindan rastgele kullanici sec")
    public void csvReader(String value) {
        try {
            String line = "";
            String splitBy = ",";

            BufferedReader br = new BufferedReader(new FileReader("data/"+value+".csv"));
            while ((line = br.readLine()) != null)
            {
                String[] keyValue = line.split(splitBy,2);
                user.add(keyValue[0]);
                password.add(keyValue[1]);
            }

            System.out.println("Maillere ait csv okundu");

            int number = createRandomNumber(user.size());

            accountUser = user.get(number);
            accountpassword = password.get(number);

            System.out.println("Kullanilacak Kullanici adi :" + accountUser);
            System.out.println("Kullanilacak Sifre :" + accountpassword);

        }catch (Exception e){
            System.out.println("Csv dosyasi oluşturulurken hatayla karsilasildi");
            System.out.println(user);
            System.out.println(password);
        }
    }





    @Step({"Değeri <text> e eşit olan <index>. elementi bul ve tıkla"})
    public void clickByText(String text, int index) {
        findElementWithAssertion(By.xpath("(.//*[contains(@text,'" + text + "')])[" + index + "]")).click();
    }

    @Step({"İçeriği <value> e eşit olan <index>. elementi bul ve tıkla"})
    public void clickByValue(String value, int index) {
        findElementWithAssertion(MobileBy.xpath("(.//*[contains(@value,'" + value + "')])[" + index + "]")).click();
    }

    @Step("<key> elementinin <index> .li elementi bul ve tıkla")
    public void clickByKeyIndex(String key, int index) {
        findElementsWithoutAssert(selector.getSelectorInfo(key).getBy()).get(index).click();
    }


    @Step({"Elementine tıkla <key>", "Click element by <key>"})
    public void clickByKey(String key) {
        doesElementExistByKey(key, 5);
        findElementByKey(key).click();
        logger.info(key + " elemente tıkladı");
    }

    @Step({"Check if element <key> exists",
            "Wait for element to load with key <key>",
            "Element var mı kontrol et <key>",
            "Elementin yüklenmesini bekle <key>"})
    public MobileElement getElementWithKeyIfExists(String key) throws InterruptedException {
        MobileElement element;
        try {
            element = findElementByKey(key);
            logger.info(key + " elementi bulundu.");
        } catch (Exception ex) {
            logger.info("Element: '" + key + "' doesn't exist.");
            return null;
        }
        return element;
    }
    @Step({"Rastgele secilen kullanici adi <key> elementine, sifre <key> elementine yazilir"})
    public void existElementt(String key,String key2) {
        findElementByKey(key).sendKeys(accountUser);
        findElementByKey(key2).sendKeys(accountpassword);
    }



    @Step({"<key> elementine sayacli tikla <key2> value degerini bekle"})
    public void clickByKeyWithCounter(String key,String key2) {
        if (findElementByKey(key).isDisplayed()) {
            System.out.println("Dongeye girdi");
            findElementByKey(key).click();
        }
        logger.info(key + " elementine tiklandi");
        clickExistElement(key,key2);
    }

    public void clickExistElement(String key1,String key) {
        startTime = System.currentTimeMillis();
        findElementByKey(key);
        //assertTrue(findElementByKey(key).isDisplayed(), "Element sayfada bulunamadı !");
        long finishTime = System.currentTimeMillis();
        long eventDuration = (finishTime - startTime) / 1000;  // Zamanı saniyeye çeviriyoruz
        long seconds = eventDuration % 60;  // Saniyeyi hesaplıyoruz
        long milliseconds = (finishTime - startTime) % 1000;  // Saliseyi hesaplıyoruz
        System.out.println("["+key1+"] ------> "+"["+key+"] " + seconds + " seconds, " + milliseconds + " milliseconds");
    }

    @Step({"<key> icin sayac tut"})
    public void existElement(String key) {
        startTime = System.currentTimeMillis();
        findElementByKey(key);
        finishCounter(key);
    }

    public void finishCounter(String key){
        long finishTime = System.currentTimeMillis();
        long eventDuration = (finishTime - startTime) / 1000;  // Zamanı saniyeye çeviriyoruz
        long seconds = eventDuration % 60;  // Saniyeyi hesaplıyoruz
        long milliseconds = (finishTime - startTime) % 1000;  // Saliseyi hesaplıyoruz
        logger.info("["+key+"] "+" elementi sayfada görüntülendi");
        System.out.println("["+key+"] " + seconds + " seconds, " + milliseconds + " milliseconds");
    }

    @Step("<key> elementinin <text> textini içerdiği kontrol edilir")
    public void checkTextByKey(String key, String text) {
        try {
            Thread.sleep(3000);
            System.out.println("******"+findElementByKey(key).getText()+"******");
            assertTrue(findElementByKey(key).getText().contains(text), "Element beklenen değeri taşımıyor !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step({"<key> li elementi bul ve varsa tıkla", "Click element by <key> if exist"})
    public void existClickByKey(String key) throws InterruptedException {
        MobileElement element;
        element = findElementByKeyWithoutAssert(key);
        if (element != null) {
            Point elementPoint = ((MobileElement) element).getCenter();
            TouchAction action = new TouchAction(appiumDriver);
            action.tap(PointOption.point(elementPoint.x, elementPoint.y)).perform();
        }
        waitBySecond(2);
    }


    @Step({"<key> li elementi bul ve varsa dokun", "Click element by <key> if exist"})
    public void existTapByKey(String key) {
        if (findElementByKey(key).isDisplayed()) {
            findElementByKey(key).click();
        }
    }

    @Step({"sayfadaki <X> <Y>  alana dokun"})
    public void coordinateTap(int X, int Y) {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int width = dimension.width;
        int height = dimension.height;

        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point((width * X) / 100, (height * Y) / 100))
                .release().perform();

    }

    @Step({"<key> li elementi bul, temizle ve <text> değerini yaz",
            "Find element by <key> clear and send keys <text>"})
    public void sendKeysByKey(String key, String text) {
        MobileElement webElement = findElementByKey(key);
        webElement.clear();
        webElement.setValue(text);
    }

    @Step({"<key> li elementin text degeri silinir"})
    public void keyClear(String key) {
        findElementByKey(key).clear();
    }


    @Step({"<t> textini <k> elemente yaz",
            "Find element by <key> and send keys <text>"})
    public void sendKeysByKeyNotClear(String t, String k) {
        doesElementExistByKey(k, 5);
        findElementByKey(k).sendKeys(t);
        logger.info(t+" texti"+k+" key elementine yazildi");
    }

    public int createRandomNumber(int max) {
        Random rand = new Random();

        int randomNumber = rand.nextInt(max);

        return randomNumber;
    }


    @Step({"<key> li elementi bul ve değerini <saveKey> olarak sakla",
            "Find element by <key> and save text <saveKey>"})
    public void saveTextByKey(String key, String saveKey) {
        StoreHelper.INSTANCE.saveValue(saveKey, findElementByKey(key).getText());
        logger.info("["+StoreHelper.INSTANCE.getValue(saveKey)+"]" + " degeri ["+ saveKey + "] ismiyle hafizaya kaydedildi");
    }

    @Step({"<key> li ve değeri <text> e eşit olan elementli bul ve tıkla",
            "Find element by <key> text equals <text> and click"})
    public void clickByIdWithContains(String key, String text) {
        List<MobileElement> elements = findElemenstByKey(key);
        for (MobileElement element : elements) {
            logger.info("Text !!!" + element.getText());
            if (element.getText().toLowerCase().contains(text.toLowerCase())) {
                element.click();
                break;
            }
        }
    }

    @Step({"<key> li ve değeri <text> e eşit olan elementli bulana kadar swipe et ve tıkla",
            "Find element by <key> text equals <text> swipe and click"})
    public void clickByKeyWithSwipe(String key, String text) throws InterruptedException {
        boolean find = false;
        int maxRetryCount = 10;
        while (!find && maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKey(key);
            for (MobileElement element : elements) {
                if (element.getText().contains(text)) {
                    element.click();
                    find = true;
                    break;
                }
            }
            if (!find) {
                maxRetryCount--;
                if (appiumDriver instanceof AndroidDriver) {
                    swipeUpAccordingToPhoneSize();
                    waitBySecond(1);
                } else {
                    swipeDownAccordingToPhoneSize();
                    waitBySecond(1);
                }
            }
        }
    }

    @Step({"<key> li elementi bulana kadar swipe et ve tıkla",
            "Find element by <key>  swipe and click"})
    public void clickByKeyWithSwipe(String key) throws InterruptedException {
        int maxRetryCount = 10;
        while (maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKey(key);
            if (elements.size() > 0) {
                if (elements.get(0).isDisplayed() == false) {
                    maxRetryCount--;
                    swipeDownAccordingToPhoneSize();
                    waitBySecond(1);

                } else {
                    elements.get(0).click();
                    logger.info(key + " elementine tıklandı");
                    break;
                }
            } else {
                maxRetryCount--;
                swipeDownAccordingToPhoneSize();
                waitBySecond(1);
            }

        }
    }


    private int getScreenWidth() {
        return appiumDriver.manage().window().getSize().width;
    }

    private int getScreenHeight() {
        return appiumDriver.manage().window().getSize().height;
    }

    private int getScreenWithRateToPercent(int percent) {
        return getScreenWidth() * percent / 100;
    }

    private int getScreenHeightRateToPercent(int percent) {
        return getScreenHeight() * percent / 100;
    }


    public void swipeDownAccordingToPhoneSize(int startXLocation, int startYLocation, int endXLocation, int endYLocation) {
        startXLocation = getScreenWithRateToPercent(startXLocation);
        startYLocation = getScreenHeightRateToPercent(startYLocation);
        endXLocation = getScreenWithRateToPercent(endXLocation);
        endYLocation = getScreenHeightRateToPercent(endYLocation);

        new TouchAction(appiumDriver)
                .press(PointOption.point(startXLocation, startYLocation))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(endXLocation, endYLocation))
                .release()
                .perform();
    }

    @Step({"<key> id'li elementi bulana kadar <times> swipe yap ",
            "Find element by <key>  <times> swipe "})
    public void swipeDownUntilSeeTheElement(String element, int limit) throws InterruptedException {
        for (int i = 0; i < limit; i++) {
            List<MobileElement> meList = findElementsWithoutAssert(By.id(element));
            meList = meList != null ? meList : new ArrayList<MobileElement>();
            logger.info(i + ". swipe yapiliyor");
            if (meList.size() > 0 &&
                    meList.get(0).getLocation().x <= getScreenWidth() &&
                    meList.get(0).getLocation().y <= getScreenHeight()) {
                break;
            } else {
                swipeDownAccordingToPhoneSize(50, 80, 50, 30);
                waitBySecond(1);

                break;
            }
        }
    }


    @Step({"<key> li elementi bulana kadar swipe et",
            "Find element by <key>  swipe "})
    public void findByKeyWithSwipe(String key) {
        int maxRetryCount = 10;
        while (maxRetryCount > 0) {
            List<MobileElement> elements = findElemenstByKeyWithoutAssert(key);
            if (elements.size() > 0) {
                if (elements.get(0).isDisplayed() == false) {
                    maxRetryCount--;

                    swipeDownAccordingToPhoneSize();

                } else {
                    System.out.println(key + " element bulundu");
                    break;
                }
            } else {
                maxRetryCount--;
                swipeDownAccordingToPhoneSize();

            }

        }
    }


    @Step("<yon> yönüne swipe et")
    public void swipe(String yon) {

        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;

        if (yon.equals("SAĞ")) {

            int swipeStartWidth = (width * 80) / 100;
            int swipeEndWidth = (width * 30) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        } else if (yon.equals("SOL")) {

            int swipeStartWidth = (width * 30) / 100;
            int swipeEndWidth = (width * 80) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);

            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();

        }
    }


    @Step({"<key> li elementin değeri <text> e içerdiğini kontrol et",
            "Find element by <key> and text contains <text>"})
    public void containsTextByKey(String key, String text) {
        By by = selector.getElementInfoToBy(key);
        assertTrue(appiumFluentWait.until(new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    currentValue = driver.findElement(by).getText();
                    return currentValue.contains(text);
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public String toString() {
                return String.format("text contains be \"%s\". Current text: \"%s\"", text, currentValue);
            }
        }));
    }

    @Step({"<key> li elementin değeri <text> e eşitliğini kontrol et",
            "Find element by <key> and text equals <text>"})
    public void equalsTextByKey(String key, String text) {
        assertTrue(appiumFluentWait.until(
                ExpectedConditions.textToBe(selector.getElementInfoToBy(key), text)));
    }

    @Step({"<seconds> saniye bekle", "Wait <second> seconds"})
    public void waitBySecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swipeUpAccordingToPhoneSize() {
        if (appiumDriver instanceof AndroidDriver) {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;
            System.out.println(width + "  " + height);

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 70) / 100;
            int swipeEndHeight = (height * 20) / 100;
            System.out.println("Start width: " + swipeStartWidth + " - Start height: " + swipeStartHeight + " - End height: " + swipeEndHeight);
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction((AndroidDriver) appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 80) / 100;
            int swipeEndHeight = (height * 20) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        }
    }


    public void swipeDownAccordingToPhoneSize() {
        if (appiumDriver instanceof AndroidDriver) {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 20) / 100;
            int swipeEndHeight = (height * 70) / 100;
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            // System.out.println("Start width: " + swipeStartWidth + " - Start height: " + swipeStartHeight + " - End height: " + swipeEndHeight);
            new TouchAction((AndroidDriver) appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 80) / 100;
            int swipeEndHeight = (height * 15) / 100;
            // appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        }
    }

    public boolean isElementPresent(By by) {
        return findElementWithoutAssert(by) != null;
    }


    @Step({"<times> kere aşağıya kaydır", "Swipe times <times>"})
    public void swipe(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            swipeDownAccordingToPhoneSize();
            waitBySecond(1);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("SWİPE EDİLDİ");
            System.out.println("-----------------------------------------------------------------");

        }
    }


    @Step({"<times> kere yukarı doğru kaydır", "Swipe up times <times>"})
    public void swipeUP(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            swipeUpAccordingToPhoneSize();
            waitBySecond(2);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("SWİPE EDİLDİ");
            System.out.println("-----------------------------------------------------------------");

        }
    }


    @Step({"Klavyeyi kapat", "Hide keyboard"})
    public void hideAndroidKeyboard() {
        try {

            if (localAndroid == false) {
                appiumDriver.hideKeyboard();
            } else {
                appiumDriver.hideKeyboard();
            }
        } catch (Exception ex) {
            logger.error("Klavye kapatılamadı "+ex.getMessage());
        }
    }

    @Step({"<text> değerini sayfa üzerinde olup olmadığını kontrol et."})
    public void getPageSourceFindWord(String text) {
        assertTrue(appiumDriver.getPageSource().contains(text), text + " sayfa üzerinde bulunamadı."
        );

        logger.info(text + " sayfa üzerinde bulundu");
    }
    @Step({"<key> değerini sayfa üzerinde olmadıgını kontrol et"})
    public void getPageSourceFindWordKey(String key) {

        MobileElement deneme = findElementByKeyWithoutAssert(key);

        if (deneme==null)
        {
            logger.info(key + " sayfa üzerinde olmadıgı kontrol edildi");
        }
        if (deneme!=null)
        {
            Assertions.fail("Element bulundu");
        }

    }

    @Step({"<key> değerini sayfa olmadığını kontrol et"})
    public void getPageSourceFindWordKeyy(String key) {
        assertFalse(appiumDriver.getPageSource().contains(key), key + " sayfa üzerinde bulunamadı."
        );

        logger.info(key + " sayfa üzerinde bulundu");
    }




    @Step({"<length> uzunlugunda random bir kelime üret ve <saveKey> olarak sakla"})
    public void createRandomNumber(int length, String saveKey) {
        StoreHelper.INSTANCE.saveValue(saveKey, new RandomString(length).nextString());
    }

    @Step("geri butonuna bas")
    public void clickBybackButton() {
        if (!localAndroid) {
            backPage();
        } else {
            ((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
        }

    }


    @Step("<StartX>,<StartY> oranlarından <EndX>,<EndY> oranlarına <times> kere swipe et")
    public void pointToPointSwipe(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();

        int height = d.height;
        int width = d.width;
        startX = (width * startX) / 100;
        startY = (height * startY) / 100;
        endX = (width * endX) / 100;
        endY = (height * endY) / 100;
        for (int i = 0; i < count; i++) {
            waitBySecond(1);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
        }


    }

    @Step("<key> elementinin hizasından sağdan sola <times> kere kaydır")
    public void swipeFromLeftToRightAligned(String key, int times) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();

        int height = d.height;
        int width = d.width;
        Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
        pointToPointSwipeWithCoordinats(width - 50, elementLocation.getY(), 40, elementLocation.getY(), times);
    }

    @Step("<key> li elementi hizala ve sagdan sola kaydır <times> kere y cordinatına <number> ekle")
    public void horizontalSwipeWithElement(String key, int times, int number) throws InterruptedException {

        Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
        logger.info("x==" + elementLocation.getX() + " y==" + elementLocation.getY() + "----------");

        pointToPointSwipeWithCoordinats(900, elementLocation.getY(), 40, elementLocation.getY(), times);
        logger.info("-----horizonal kaydırma işlemi tamamlandı-----");
    }

    @Step("<StartX>,<StartY> coordinatından <EndX>,<EndY> coordinatına <times> kere swipe et")
    public void pointToPointSwipeWithCoordinats(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();


        for (int i = 0; i < count; i++) {
            waitBySecond(1);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
        }


    }

    public void pointToPointSwipeForDayAndYear(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        int width = d.width;
        if (count > 200) {
            startX = (width * startX) / 100;
            startY = (height * startY) / 100;
            endX = (width * endX) / 100;
            endY = (height * endY) / 100;
            count = count - 2019;

        } else
            count--;
        for (int i = 0; i < count; i++) {
            waitBySecond(1);
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release().perform();
        }
    }

    @Step("uygulamayı yeniden başlat")
    public void restart() throws InterruptedException {
        appiumDriver.closeApp();
        appiumDriver.launchApp();
        logger.info("uygulama yeniden başlatıldı");
        waitBySecond(5);
        existClickByKey("ızınVer");

    }

    private void backPage() {
        appiumDriver.navigate().back();
    }


    private String getCapability(String text) {
        return appiumDriver.getCapabilities().getCapability(text).toString();

    }

    public boolean doesElementExistByKey(String key, int time) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        try {
            WebDriverWait elementExist = new WebDriverWait(appiumDriver, time);
            elementExist.until(ExpectedConditions.visibilityOfElementLocated(selectorInfo.getBy()));
            return true;
        } catch (Exception e) {
            logger.info(key + " aranan elementi bulamadı");
            return false;
        }

    }


    public void tapElementWithCoordinate(int x, int y) {
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.tap(PointOption.point(x, y)).perform();
    }

    @Step("<key> li elementin  merkezine tıkla ")
    public void tapElementWithKey(String key) {

        Point point = findElementByKey(key).getCenter();
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.tap(PointOption.point(point.x, point.y)).perform();
    }

    @Step("<key> li elementin x kordinatında <xInt> yüzdesi y ekseninde merkezine tıkla")
    public void tapElementCordinaateWithKey(String key, int xInt) {

        Point point = findElementByKey(key).getCenter();
        TouchAction a2 = new TouchAction(appiumDriver);
        System.out.println(point);
        a2.tap(PointOption.point(point.x*(xInt/50), point.y)).perform();
    }

    @Step("<key> li element varsa tıkla")
    public void tapElementWithKeyControl(String key) {

        logger.info("element varsa verilen tıkla ya girdi");
        MobileElement mobileElement;

        mobileElement = findElementByKeyWithoutAssert(key);

        if (mobileElement != null) {

            doesElementExistByKey(key, 5);
            findElementByKey(key).click();
            logger.info(key + "elemente tıkladı");

        }}

    @Step("<key> li element varsa tıkla <key2> tıkla")
    public void tapElementWithKeyControlLogin(String key, String key2) {

        logger.info("element varsa verilen tıkla girdi");
        MobileElement mobileElement;

        waitBySecond(2);

        mobileElement = findElementByKeyWithoutAssert(key);

        if (mobileElement != null) {

            doesElementExistByKey(key, 5);
            findElementByKey(key).click();
            findElementByKey(key2).click();
            logger.info(key + "elemente tıkladı");

        }
        else {
            System.out.println(key + " element bulunamadi");

        }
    }

    @Step("<key> li element varsa tıkla yoksa devam et")
    public void tapElementWithKeyControlArea(String key) {

        logger.info("element varsa verilen tıkla ya girdi");
        MobileElement mobileElement;

        mobileElement = findElementByKeyWithoutAssert(key);

        if (mobileElement != null) {

            doesElementExistByKey(key, 5);
            findElementByKey(key).click();
            logger.info(key + "elemente tıkladı");

        }
        else {
            System.out.println(key + " element bulunamadi, sıradaki step devam ediyor.");

        }}


    @Step("<key> li element varsa  <x> <y> koordinatına tıkla ")
    public void tapElementWithKeyCoordinate(String key, int x, int y) {

        logger.info("element varsa verilen koordinata tıkla ya girdi");
        MobileElement mobileElement;

        mobileElement = findElementByKeyWithoutAssert(key);

        if (mobileElement != null) {

            System.out.println("pakachu");
            Point point = mobileElement.getLocation();
            logger.info(point.x + "  " + point.y);
            Dimension dimension = mobileElement.getSize();
            logger.info(dimension.width + "  " + dimension.height);
            TouchAction a2 = new TouchAction(appiumDriver);
            a2.tap(PointOption.point(point.x + (dimension.width * x) / 100, point.y + (dimension.height * y) / 100)).perform();
        }
    }

    @Step("<key> li elementin  merkezine  press ile çift tıkla ")
    public void pressElementWithKey(String key) {

        Point point = findElementByKey(key).getCenter();
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.press(PointOption.point(point.x, point.y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .press(PointOption.point(point.x, point.y)).release().perform();

    }


    @Step("<key> li elementin  merkezine double tıkla ")
    public void pressElementWithKey2(String key) {
        Actions actions = new Actions(appiumDriver);
        actions.moveToElement(findElementByKey(key));
        actions.doubleClick();
        actions.perform();
        appiumDriver.getKeyboard();

    }

    @Step("<key> listesinden rastgele bir elemente sayacla tikla ve <key2> bekle")
    public void chooseRandomProduct(String key,String key2) {
        List<MobileElement> list = findElemenstByKey(key);
        startTime = System.currentTimeMillis();
        list.get(createRandomNumber(list.size()-1)).click();
        finishCounter(key);
    }


    @Step("<key> li elemente kadar <text> textine sahip değilse ve <timeout> saniyede bulamazsa swipe yap")
    public void swipeAndFindwithKey(String key, String text, int timeout) {
        MobileElement sktYil1 = null;
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        WebDriverWait wait = new WebDriverWait(appiumDriver, timeout);
        int count = 0;
        while (true) {
            count++;
            try {
                sktYil1 = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(selectorInfo.getBy()));
                if (text.equals("") || sktYil1.getText().trim().equals(text)) {
                    break;
                }
            } catch (Exception e) {
                logger.info("Bulamadı");

            }
            if (count == 8) {

                Assertions.fail("Element bulunamadı");
            }

            Dimension dimension = appiumDriver.manage().window().getSize();
            int startX1 = dimension.width / 2;
            int startY1 = (dimension.height * 75) / 100;
            int secondX1 = dimension.width / 2;
            int secondY1 = (dimension.height * 30) / 100;

            TouchAction action2 = new TouchAction(appiumDriver);

            action2
                    .press(PointOption.point(startX1, startY1))
                    .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                    .moveTo(PointOption.point(secondX1, secondY1))
                    .release()
                    .perform();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Step("<key>li elementi bulana kadar <limit> kere swipe yap ve elementi bul")
    public void swipeKeyy(String key, int limit) throws InterruptedException {


        boolean isAppear = false;

        int windowHeight = this.getScreenHeight();
        for (int i = 0; i < limit; ++i) {
            logger.info((i+1)+". kere swipe edilecek");
            try {

                Dimension phoneSize = appiumDriver.manage().window().getSize();
                Point elementLocation = findElementByKeyWithoutAssert(key).getLocation();
                logger.info(elementLocation.x + "  " + elementLocation.y);
                Dimension elementDimension = findElementByKeyWithoutAssert(key).getSize();
                logger.info(elementDimension.width + "  " + elementDimension.height);
                // logger.info(appiumDriver.getPageSource());
                if ((0 < elementLocation.y) && (elementLocation.y <= phoneSize.height - 30)) {
                    isAppear = true;
                    logger.info("aranan elementi buldu");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Element ekranda görülmedi. Tekrar swipe ediliyor");
            }
            System.out.println("Element ekranda görülmedi. Tekrar swipe ediliyor");

            swipeDownAccordingToPhoneSize();
            waitBySecond(1);
        }

    }


    @Step("<key> li  telefonun  <x> ve elementin <y> kordinatına göre tıkla")
    public void elementFindwithXandYcoordinate(String key, int x, int y) {

        WebElement element = findElementByKey(key);
        int height = element.getLocation().y + (element.getSize().height * y) / 100;
        int width = (appiumDriver.manage().window().getSize().width * x) / 100;
        System.out.println(height + "  " + width + "   ");
        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point(width, height)).perform();
    }

    @Step("<key> elementinin koordinatlarına x=<x> y=<y> degerlerini ekleyerek tıkla")
    public void coordinatClickWithAdds(String key, int x, int y) {
        MobileElement me = findElementByKey(key);
        tapElementWithCoordinate(me.getLocation().x + x, me.getLocation().y + y);
    }

    @Step("<x>,<y> koordinatlarına tıkla")
    public void koordinataTikla(int x, int y) {
        TouchAction a2 = new TouchAction(appiumDriver);
        a2.tap(PointOption.point(x, y)).perform();
        logger.info("tıklama yapıldı");
    }
    @Step({"Değeri <key> e eşit olan elementli bul"})
    public void clickByTexte(String key) {
        String Sec;
        Sec = findElementByKeyWithoutAssert(key).getAttribute("checked");
        String E2 = Sec;
        if (E2.equals("false")){
            doesElementExistByKey(key, 5);
            findElementByKey(key).click();
            logger.info(key + "elemente tıkladı");
        }
        else if(E2.equals("true"))
        {
            logger.info(key + " secili gelmistir");
        }

    }
    @Step("Enter tıkla")
    public void keyboardClickEnter() {

        tapElementWithCoordinate(999,1991);
        logger.info("'%s' objesi üzerinde ENTER tuşuna basıldı.");
    }

    @Step("Android Enter tıkla")
    public void keyboardClickEnterAndroid() {
        waitBySecond(2);
        ((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.ENTER);
        //tapElementWithCoordinate(1320,2700);
        logger.info("'%s' objesi üzerinde ENTER tuşuna basıldı.");
    }







    @Step("<x> elementinde <y> yilina git")
    public void clickByKeyRepeat(String key, int y) {
        y = 2022-y;
        for (int i=1; i<(y+1);i++)
        {
            doesElementExistByKey(key, 5);
            findElementByKey(key).click();
            logger.info(key + " elementine "+i+ ". kere tıkladı");
        }
    }


    @Step({"<key> Checkbox degerinin false geldigini kontrol et"})
    public void checkBoxControl(String key) {
        String Sec;
        Sec = findElementByKeyWithoutAssert(key).getAttribute("checked");
        String E2 = Sec;
        if (E2.equals("false")){
            logger.info(key + " checkbox boş olarak(false) olarak gelmiştir.");
        }
        else if(E2.equals("true"))
        {
            Boolean selected = true;
            assertFalse(selected,"Checkbox seçili(true) olarak gelmiştir.");

        }
    }


    private Long getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return (timestamp.getTime());
    }

    @Step({"<key> li elementi bul, temizle ve rasgele  email değerini yaz",
            "Find element by <key> clear and send keys  random email"})
    public void RandomeMail(String key) {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd-HH-mm-s");
        Date date = new Date(System.currentTimeMillis());
        logger.info(formatter.format(date));

        MobileElement webElement = findElementByKey(key);
        webElement.clear();
        webElement.setValue("testotomasyon" + formatter.format(date) + "@beymentest.com");
    }

    @Step({"<key> li elementi bul, temizle ve <length> uzunluğunda string değer yaz",
            "Find element by <key> clear and send keys <text>"})
    public void randomStringSendKeysByKey(String key, int length) {

        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; i++) {

            int index = random.nextInt(lowerAlphabet.length());
            char randomChar = lowerAlphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();

        logger.info("'"+randomString+ "' random kelime olarak oluşturuldu");
        MobileElement webElement = findElementByKey(key);
        webElement.clear();
        webElement.setValue(randomString);
    }

    @Step("<key>'li elementin <attr> degerini icerdigini kontrol et")
    public void checkByAttr(String key,String attr) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("***************"+dtf.format(now)+"***************");
        Dimension d = appiumDriver.manage().window().getSize();
        int height = d.height;
        String attribute = findElementByKey(key).getAttribute(attr);
        System.out.println("Height: "+height+" - Attribute: "+attribute);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("***************"+dtf.format(now2)+"***************");

    }

    @Step("<key> elementinin <text> textini içermediği kontrol edilir")
    public void checkTextByKeyFalse(String key, String text) {
        try {
            Thread.sleep(3000);
            String denemee = findElementByKey(key).getText();
            assertFalse(findElementByKey(key).getText().contains(text), "Element beklenen değeri taşıyor !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("<key> elementinin <attr> attribute degeri ile scrool bar kontrol edilir")
    public void checkScroolBar(String key, String attr) throws InterruptedException {
        String firstAttribute = findElementByKey(key).getAttribute(attr);
        logger.info("First attribute: " + firstAttribute);
        swipe(2);
        String secondAttribute = findElementByKey(key).getAttribute(attr);
        logger.info("Second attribute: " + secondAttribute);
        assertFalse(firstAttribute.equals(secondAttribute),"Scrool bar yok!");
        swipeUP(2);
    }

    @Step({"<key> li elementin text degerini hafizada <saveKey> olarak saklanan text ile karsilastir"})
    public void chechTextByKeyAndSaveKey(String key, String saveKey) {

        System.out.println("------------------------------------------------------");
        String saveElementTxt= StoreHelper.INSTANCE.getValue(saveKey);
        logger.info("Expected Value : "+saveElementTxt);
        String elementTxt = findElementByKey(key).getText();
        logger.info("Actual Value : "+elementTxt);
        System.out.println("------------------------------------------------------");
        assertTrue(elementTxt.contains(saveElementTxt),"Degerler birbirine esit degil!");
    }

    @Step({"<key> li elementin text degeri hafizada <saveKey> olarak saklanan text ile esit mi kontrol et"})
    public void equalsByKeyAndSaveKey(String key, String saveKey) {

        System.out.println("------------------------------------------------------");
        String saveElementTxt= StoreHelper.INSTANCE.getValue(saveKey);
        logger.info("Expected Value : "+saveElementTxt);
        String elementTxt = findElementByKey(key).getText();
        logger.info("Actual Value : "+elementTxt);
        System.out.println("------------------------------------------------------");
        assertEquals(elementTxt, saveElementTxt, "Degerler birbirine esit degil!");
    }

    @Step({"<key> li elementin text degerini hafizada <saveKey> olarak saklanan text ayni olmadigini kontrol et"})
    public void DifferentTextByKeyAndSaveKey(String key, String saveKey) {

        System.out.println("------------------------------------------------------");
        String saveElementTxt= StoreHelper.INSTANCE.getValue(saveKey);
        logger.info("Expected Value : "+saveElementTxt);
        String elementTxt = findElementByKey(key).getText();
        logger.info("Actual Value : "+elementTxt);
        System.out.println("------------------------------------------------------");
        assertFalse(elementTxt.contains(saveElementTxt),"Degerler birbirine esit!");
    }

    @Step({"<saveKey> olarak saklanan text degerinin uzunlugu <int> uzunlugunda mi kontrol et"})
    public void saveKeyLeght(String saveKey, int leghth) {

        System.out.println("------------------------------------------------------");
        String saveElementTxt= StoreHelper.INSTANCE.getValue(saveKey);
        logger.info("Save Value : "+saveElementTxt);
        assertTrue(saveElementTxt.length()==leghth,"Text degerinin uzunlugu esit degil");
    }


    @Step({"<key> li elementin text degerini, saklanan <saveKey> degeriyle ile <islem>"})
    public void calculateAndSave(String key, String saveKey,String islem) {

        MobileElement element;
        element = findElementByKeyWithoutAssert(key);

        if (element!=null){
            String lastSaveKey = StoreHelper.INSTANCE.getValue(saveKey);

            lastSaveKey = lastSaveKey.replaceAll("\\s", "");
            lastSaveKey = lastSaveKey.replaceAll(",", ".");
            lastSaveKey = lastSaveKey.replaceAll("TL", "");
            Float floatLastSaveKey =Float.parseFloat(lastSaveKey);
            logger.info("Birikimli odenecek tutar : "+lastSaveKey);

            String elementTxt = findElementByKey(key).getText();

            String price = findElementByKey(key).getText();
            elementTxt = elementTxt.replaceAll("\\s", "");
            elementTxt = elementTxt.replaceAll(",", ".");
            elementTxt = elementTxt.replace(elementTxt.substring(elementTxt.length()-2), "");
            Float floatElementTxt =Float.parseFloat(elementTxt);
            logger.info(key+" : "+elementTxt);


            if (islem.equals("topla"))
            {
                floatLastSaveKey = (floatLastSaveKey*100)+(floatElementTxt*100);
                floatLastSaveKey/=100;
                logger.info("Islem sonucu : "+floatLastSaveKey);

            }
            else if (islem.equals("cikar"))
            {
                floatLastSaveKey = (floatLastSaveKey*100)-(floatElementTxt*100);
                floatLastSaveKey/=100;
                logger.info("Islem sonucu : "+floatLastSaveKey);
            }
            else{
                logger.info("Islem adi yanlis girilmiştir!");
                assertTrue(0>1);

            }

            String strValue = Float.toString(floatLastSaveKey);
            strValue = strValue.replaceAll("\\.", ",");
            StoreHelper.INSTANCE.saveValue(saveKey,strValue);
        }

        else {
            logger.info("------ Islem icin ["+key+"] li element bulunamadi ------");
        }

    }


    @Step("Sipariste bulunan urunlerin toplam fiyati <key> degeri ile kontrol edilirerek <saveKey> ile saklanir")
    public void pointToPointSwipeWithCoordinatsForProduct(String key, String saveKey) throws InterruptedException {
        String strCount = appiumDriver.findElement(By.id("com.mobisoft.beymen:id/tvOrderStatus")).getText();
        strCount = strCount.substring(strCount.indexOf(":")+1);
        strCount = strCount.substring(1, 3);
        strCount = strCount.replaceAll("\\s", "");
        int count =Integer.parseInt(strCount);
        logger.info("Siparis verilmiş ürün sayisi : " + count);


        TouchAction action = new TouchAction(appiumDriver);
        action.press(PointOption.point(0, 375))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(0, 45))
                .release().perform();


        int startY=520;
        int endY=45;
        float result=0;
        Dimension d = appiumDriver.manage().window().getSize();

        for (int i = 0; i < count; i++) {
            waitBySecond(1);

            String price = findElementByKey(key).getText();
            price = price.replaceAll("\\s", "");
            price = price.replaceAll(",", ".");
            price = price.replace(price.substring(price.length()-2), "");
            Float itemPrice =Float.parseFloat(price);
            result = (result*100)+(itemPrice*100);
            result/=100;
            String strResult = Float.toString(result);
            strResult = strResult.replaceAll("\\.", ",");
            logger.info((i+1)+". urun degeri : " +itemPrice);
            StoreHelper.INSTANCE.saveValue(saveKey,strResult);


            action.press(PointOption.point(0, startY))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(0, endY))
                    .release().perform();


        }
        logger.info("Urunlerin toplam degeri : " +StoreHelper.INSTANCE.getValue(saveKey));
    }


    @Step({"<text> text degerine sahip elementin sayfada gorundugu kontrol edilir"})
    public void ifExistCompare(String text) throws InterruptedException {
        waitBySecond(1);
        String key = "(//*[contains(@text,'"+text+"')])";
        assertTrue(appiumDriver.findElement(By.xpath(key)).isDisplayed(), "Element sayfada bulunamadı !");
        logger.info(key+" elementi sayfada görüntülendiği kontrol edildi");
    }

    @Step({"<firstKey> li tarihin,<secondKey> li tarihten yeni oldugu kontrol edilir"})
    public void ifExistCompareeee(String firstKey,String secondKey) throws InterruptedException, ParseException {

        String firstDate = findElementByKey(firstKey).getText();
        String secondDate = findElementByKey(secondKey).getText();

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date date1 = sdf.parse(firstDate);
        Date date2 = sdf.parse(secondDate);

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        int result = date1.compareTo(date2);

        if (result == 0) {
            logger.info("Iki tarih birbirine esittir [" + firstDate+"]["+ secondDate+"]");
        } else if (result > 0) {
            logger.info("Iki tarih arasindan yeni olan : ["+firstDate+"]");

        } else if (result < 0) {
            logger.info("Iki tarih arasindan yeni olan : ["+secondDate+"]");

        } else {
            logger.info("Tarih kiyaslamada problem cikti!");
        }
        assertTrue((result>0 )|| (result==0),"Urunlerin tarih siralamasi dogru değil!");


    }

    @Step({"<saveKey> olarak hafizada saklanan degeri <key> elementine yaz"})
    public void getTextAndWriteForKey(String saveKey, String key){
        String saveElementTxt= StoreHelper.INSTANCE.getValue(saveKey);
        MobileElement webElement = findElementByKey(key);
        webElement.clear();
        webElement.setValue(saveElementTxt);
    }

    @Step({"<element> li elementi yukari kaydir"})
    public void swipeBirtdayUp(String key){

        String attribute = findElementByKey(key).getAttribute("bounds");

        String allString[] = attribute.split("]");
        String firstPart = allString[0].substring(1);
        String secondPart = allString[1].substring(1);
        String start[] = firstPart.split(",");
        String stringStartWidth = start[0];
        String stringStartHeight = start[1];
        String end[] = secondPart.split(",");
        String stringEndWidth = end[0];
        String stringEndHeight = end[1];
        int startWidth = Integer.parseInt(stringStartWidth);
        int startHeight = Integer.parseInt(stringEndHeight);
        int endWidth = Integer.parseInt(stringEndWidth);
        int endHeight = Integer.parseInt(stringEndHeight);
        int width = (startWidth+endWidth)/2;

        new TouchAction(appiumDriver)
                .press(PointOption.point(width, endHeight-90))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(width, startHeight+90))
                .release()
                .perform();
    }

    @Step({"<element> li elementi asagi kaydir"})
    public void swipeBirtdayDown(String key){

        String attribute = findElementByKey(key).getAttribute("bounds");

        String allString[] = attribute.split("]");
        String firstPart = allString[0].substring(1);
        String secondPart = allString[1].substring(1);
        String start[] = firstPart.split(",");
        String stringStartWidth = start[0];
        String stringStartHeight = start[1];
        String end[] = secondPart.split(",");
        String stringEndWidth = end[0];
        String stringEndHeight = end[1];
        int startWidth = Integer.parseInt(stringStartWidth);
        int startHeight = Integer.parseInt(stringEndHeight);
        int endWidth = Integer.parseInt(stringEndWidth);
        int endHeight = Integer.parseInt(stringEndHeight);
        int width = (startWidth+endWidth)/2;

        new TouchAction(appiumDriver)
                .press(PointOption.point(width,startHeight+90 ))
                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(width,endHeight-90 ))
                .release()
                .perform();
    }

    @Step({"Klavyede arama tusuna bas"})
    public void enterAndroidKeyboard() {
        try {

            if (localAndroid == false) {
                Actions action = new Actions(appiumDriver);
                action.sendKeys(Keys.ENTER).perform();
            }
            else {
                Actions action = new Actions(appiumDriver);
                action.sendKeys(Keys.ENTER).perform();
            }
        } catch (Exception ex) {
            logger.error("Klavye üzerinden arama başarısız "+ex.getMessage());
        }
    }

    @Step({"Favori ürünler silinir"})
    public void deleteFavElement() {

        try {

            Boolean dongu = true;

            while (dongu) {
                List<MobileElement> elements = findElemenstByKeyWithoutAssert("FAVORI_ELEMENT_SIL");
                int elementsSize = elements.size();
                System.out.println("Element size : " + elementsSize);
                for (int i = 0; i < elementsSize; i++) {
                    clickByKey("FAVORI_ELEMENT_SIL");
                    System.out.println("i : "+i);
                }
            }
        }catch (Exception e){
            logger.info("Tüm elementler silindi");
        }

    }

    @Step({"Sepetteki ürünler silinir"})
    public void deleteBasketElement() {

        try {

            Boolean dongu = true;

            while (dongu) {
                List<MobileElement> elements = findElemenstByKeyWithoutAssert("SEPETIM_ELEMENT_SIL");
                int elementsSize = elements.size();
                System.out.println("Element size : " + elementsSize);
                for (int i = 0; i < elementsSize; i++) {
                    clickByKey("SEPETIM_ELEMENT_SIL");
                    System.out.println("i : "+i);
                }
            }
        }catch (Exception e){
            logger.info("Tüm elementler silindi");
        }
    }

    @Step({"Urunlerin fotolari kontol edilir"})
    public void controlImageElement() {

        List<MobileElement> elements = findElemenstByKey("URUN_FOTO_SLIDER_BULLET");
        int elementsSize = elements.size();
        System.out.println("Element size : " + elementsSize);

        for (int i = 0; i < (elementsSize-1); i++) {
            waitBySecond(1);
            System.out.println("i : "+i);
            existElement("URUN_FOTO");
            elements.get(i+1).click();
        }

        for (int i = 0; i < (elementsSize-1); i++) {

            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = (width * 15) / 100;
            int swipeEndWidth = (width * 90) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);

            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        }

    }

    @Step({"<times> kere sağa kaydirilir"})
    public void swipeRight(int time) {



        for (int i = 0; i < time; i++) {

            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = (width * 90) / 100;
            int swipeEndWidth = (width * 15) / 100;

            int swipeStartHeight = height / 2;
            int swipeEndHeight = height / 2;

            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);

            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        }


    }

    @Step({"Fiyatların yazdığı <key1> li elementin degerinin fiyata gore azalan oldugu kontrol edilir"})
    public void compareTwoIntValue(String key1) throws InterruptedException {

        long firstValue = 0;
        long secondValue = 0;

        while (firstValue==secondValue)
        { String firtKeyTxt = findElementByKey(key1).getText();
            firtKeyTxt = firtKeyTxt.replaceAll("\\s", "");
            firtKeyTxt = firtKeyTxt.replace(firtKeyTxt.substring(firtKeyTxt.length()-2), "");
            firtKeyTxt = firtKeyTxt.replaceAll(",", "");
            firtKeyTxt = firtKeyTxt.replaceAll("\\.", "");
            firstValue =Long.parseLong(firtKeyTxt);
            logger.info("1.elementinin degeri : "+firstValue);

            swipe(1);

            String secondKeyText = findElementByKey(key1).getText();
            secondKeyText = secondKeyText.replaceAll("\\s", "");
            secondKeyText = secondKeyText.replace(secondKeyText.substring(secondKeyText.length()-2), "");
            secondKeyText = secondKeyText.replaceAll(",", "");
            secondKeyText = secondKeyText.replaceAll("\\.", "");
            secondValue =Long.parseLong(secondKeyText);
            logger.info("2.elementinin degeri : "+secondValue);

            if (firstValue!=secondValue)
                break;

            swipe(1);
        }
        assertTrue(firstValue>secondValue,firstValue+" elementinin degeri"+ secondValue+" elementinin degerinden kucuk");

    }

    @Step({"Fiyatların yazdığı <key1> li elementin degerinin fiyata gore artan oldugu kontrol edilir"})
    public void compareTwoIntValuee(String key1) throws InterruptedException {

        long firstValue = 0;
        long secondValue = 0;

        while (firstValue==secondValue)
        { String firtKeyTxt = findElementByKey(key1).getText();
            firtKeyTxt = firtKeyTxt.replaceAll("\\s", "");
            firtKeyTxt = firtKeyTxt.replace(firtKeyTxt.substring(firtKeyTxt.length()-2), "");
            firtKeyTxt = firtKeyTxt.replaceAll(",", "");
            firtKeyTxt = firtKeyTxt.replaceAll("\\.", "");
            firstValue =Long.parseLong(firtKeyTxt);
            logger.info(key1+" elementinin degeri : "+firstValue);

            swipeDownAccordingToPhoneSize();
            waitBySecond(1);

            String secondKeyText = findElementByKey(key1).getText();
            secondKeyText = secondKeyText.replaceAll("\\s", "");
            secondKeyText = secondKeyText.replace(secondKeyText.substring(secondKeyText.length()-2), "");
            secondKeyText = secondKeyText.replaceAll(",", "");
            secondKeyText = secondKeyText.replaceAll("\\.", "");
            secondValue =Long.parseLong(secondKeyText);
            logger.info(key1+" elementinin degeri : "+secondValue);

            if (firstValue!=secondValue)
                break;

            swipeDownAccordingToPhoneSize();
            waitBySecond(1);
        }
        assertTrue(secondValue>firstValue,secondValue+" elementinin degeri"+ firstValue+" elementinin degerinden büyük");

    }


    @Step({"<key> elementine dogru <element> elementini kaydir"})
    public void sliderElementiniKontrolEt(String key, String element){

        waitBySecond(2);

        Dimension dKey = findElementByKey(key).getSize();
        logger.info(key+" Y point "+ dKey.height);

        Point elementPoint = findElementByKey(element).getLocation();
        String elementY = String.valueOf(elementPoint.y);
        logger.info(element+" Y point " + elementY);
        int elementBottomY = Integer.parseInt(elementY);

        Dimension d = appiumDriver.manage().window().getSize();
        int width = d.width;
        int swipeStartWidth = width / 2, swipeEndWidth = width / 2;


        new TouchAction(appiumDriver)
                .press(PointOption.point(swipeStartWidth, elementBottomY))
                .waitAction(WaitOptions.waitOptions(ofMillis(3000)))
                .moveTo(PointOption.point(swipeEndWidth, dKey.height))
                .release()
                .perform();

    }

    @Step("<key> li  elementin x ekseninde merkezine, y ekseninde yukaridan %<int> deger kadar asagisina tikla")
    public void clickCenterXandIntY(String key, int x) {

        WebElement element = findElementByKey(key);
        int height = element.getLocation().y + (element.getSize().height)/ 100;
        int height2 = element.getLocation().y + (element.getSize().height*x)/ 100;
        int width = (appiumDriver.manage().window().getSize().width)/2;
        logger.info("Elementin height degeri : "+height+", Tiklanacak height degeri"+height2);
        logger.info("Elementin width degeri : "+width+", Tiklanacak width degeri"+width);
        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point(width, height2)).perform();
    }

    @Step("<String> alt kategorisinin goruntulendigi kontrol edilir")
    public void findCategory(String key) {

        String element = "//XCUIElementTypeStaticText[@name=\""+key+"\"]";
        appiumDriver.findElement(MobileBy.xpath(element));
        logger.info(key +" elementinin sayfa uzerinde goruntulendigi kontrol edilir");

    }

    @Step("<String> title degerinin goruntulendigi kontrol edilir")
    public void findTitleText(String key) {

        String element = "//XCUIElementTypeStaticText[@name=\""+key+"\"]";
        appiumDriver.findElement(MobileBy.xpath(element));
        logger.info(key +" elementinin sayfa uzerinde goruntulendigi kontrol edilir");

    }

    @Step("<String> text degerine sahip elementin goruntulendigi kontrol edilir")
    public void findTextXpath(String key) {

        String element = "//XCUIElementTypeStaticText[@name=\""+key+"\"]";
        appiumDriver.findElement(MobileBy.xpath(element));
        logger.info(key +" text degerine sahip elementin goruntulendigi kontrol edildi");
    }

    @Step("<String> text degerine sahip elemente tikla")
    public void clickWithText(String key) {

        String element = "//XCUIElementTypeStaticText[@name=\""+key+"\"]";
        appiumDriver.findElement(MobileBy.xpath(element)).click();
        logger.info(key +" text degerine sahip elemente tiklandi");
    }

    @Step("<String> text degerine sahip butonun goruntulendigi kontrol edilir")
    public void findButtonWithText(String key) {

        String element = "//XCUIElementTypeButton[@name=\""+key+"\"]";
        appiumDriver.findElement(MobileBy.xpath(element));
        logger.info(key +" text degerine sahip buton goruntulendi");
    }

    @Step("<String> text degerine sahip butona tikla")
    public void clickButtonWithText(String key) {

        String element = "//XCUIElementTypeButton[@name=\""+key+"\"]";
        appiumDriver.findElement(MobileBy.xpath(element)).click();
        logger.info(key +" text degerine sahip elemente tiklandi");
    }


    @Step("<key> ismiyle hafizada text degeri sakli elementin sayfada gorundugu kontrol edilir")
    public void clickButtonWithTextt(String key) {

        String saveElementTxt= StoreHelper.INSTANCE.getValue(key);

        String element = "//XCUIElementTypeStaticText[@name=\""+saveElementTxt+"\"]";
        appiumDriver.findElement(MobileBy.xpath(element));
        logger.info(saveElementTxt +" text degerine sahip elementin goruntulendigi kontrol edildi");

    }
    @Step("<key> ismiyle saklanan fiyat degerinin <key2> ismiyle saklanan degerden buyuk oldugu kontrol edilir")
    public void compareSavedTextForIntValue(String key,String key2) {



        String saveElement1Txt= StoreHelper.INSTANCE.getValue(key);
        String saveElement2Txt= StoreHelper.INSTANCE.getValue(key2);

        String element1txt = saveElement1Txt.substring(0,saveElement1Txt.length()-3);
        String element2txt = saveElement2Txt.substring(0,saveElement2Txt.length()-3);

        element1txt = element1txt.replace(",","");
        element2txt = element2txt.replace(",","");

        int price1 = Integer.parseInt(element1txt.replace(".",""));
        int price2 = Integer.parseInt(element2txt.replace(".",""));

        logger.info(key+" degerine ait text : ["+price1+"]");
        logger.info(key2+" degerine ait text : ["+price2+"]");

//        boolean compareResult = price1 > price2;

        assertTrue(price1>price2);
    }
    @Step("<key> ismiyle saklanan indirim yüzde degerinin <key2> ismiyle saklanan degerden buyuk oldugu kontrol edilir")
    public void compareSavedTextForPertanceValue(String key,String key2) {



        String saveElement1Txt= StoreHelper.INSTANCE.getValue(key);
        String saveElement2Txt= StoreHelper.INSTANCE.getValue(key2);

        saveElement1Txt = saveElement1Txt.replace("-","");
        saveElement2Txt = saveElement2Txt.replace("-","");

        int price1 = Integer.parseInt(saveElement1Txt.replace("%",""));
        int price2 = Integer.parseInt(saveElement2Txt.replace("%",""));

        logger.info(key+" degerine ait text : ["+price1+"]");
        logger.info(key2+" degerine ait text : ["+price2+"]");

        boolean compareResult = price1 > price2;

        assertTrue(compareResult);
    }

    @Step({"IOS icin login ise logout olunur"})
    public void ifLoginDoLogout() throws InterruptedException {
        MobileElement element;
        element = findElementByKeyWithoutAssert("digerProfilimSekmesi");
        if (element != null) {
            swipe(1);
            waitBySecond(5);
            System.out.println("Cikis yapilacak");
            clickByKeyWithCounter("cikisYapBtnn","cikisYapPopUpCikisBtn");
            waitBySecond(3);
            clickByKey("cikisYapPopUpCikisBtn");
            swipeUP(1);
        }
        System.out.println("Uygulama logout durumda");
    }

    @Step({"login ise logout olunur And"})
    public void ifLoginDoLogoutAndroid() throws InterruptedException {
        MobileElement element;
        waitBySecond(2);
        element = findElementByKeyWithoutAssert("girisYapBtn");
        //element = findElementByKeyWithoutAssert("girisYapBtn");
        if (element == null) {
            System.out.println("buraya girdi");
            existElement("loginMailText");
            swipe(1);
            waitBySecond(2);
            //findTextXpath("Çıkış");
            //clickWithText("Çıkış");
            clickByKey("cikisYapBtn");
            waitBySecond(2);
            existElement("popUpCikisBtn");
            clickByKey("popUpCikisBtn");
        }
        waitBySecond(4);
    }

    @Step({"logout ise <email> ve <sifre> ile login olunur Android"})
    public void ifLogoutDoLoginAndroid(String mail,String sifre) throws InterruptedException {
        MobileElement element;
        waitBySecond(2);
        element = findElementByKeyWithoutAssert("cikisYapBtn");
        if (element == null) {
            logger.info("****** Logout durumda ******");
            existElement("girisYapBtn");
            clickByKey("girisYapBtn");
            existElement("andEpostaGirisInput");
            sendKeysByKeyNotClear(mail,"andEpostaGirisInput");
            sendKeysByKeyNotClear(sifre,"andGirisYapSifreInputArea");
            clickByKey("andLoginBtn");
        }
        waitBySecond(2);
        logger.info("****** Basarili sekilde login olundu ******");

        //Doğru hesap kontrolu yapilmasi icin
        MobileElement element2;
        element2 = findElementByKeyWithoutAssert("andLoginMailText");

        if (element2!=null){

        if (!Objects.equals(findElementByKey("andLoginMailText").getText(), mail)){
            logger.info("****** Yanlis hepap ile login olunmus ******");
            waitBySecond(2);
            swipe(1);
            waitBySecond(2);
            clickByKey("cikisYapBtn");
            waitBySecond(2);
            existElement("popUpCikisBtn");
            clickByKey("popUpCikisBtn");
            waitBySecond(2);
            existElement("profilSekmesi");
            clickByKey("profilSekmesi");
            existElement("girisYapBtn");
            clickByKey("girisYapBtn");
            existElement("andEpostaGirisInput");
            sendKeysByKeyNotClear(mail,"andEpostaGirisInput");
            sendKeysByKeyNotClear(sifre,"andGirisYapSifreInputArea");
            clickByKey("andLoginBtn");
            logger.info("****** Dogru hesapla login olundu ******");
            waitBySecond(3);
            existElement("andLoginMailText");
        }
        }

    }


    @Step({"logout ise <email> ve <sifre> ile login olunur"})
    public void ifLogoutDoLogin(String mail,String sifre) throws InterruptedException {
        MobileElement element;
        element = findElementByKeyWithoutAssert("loginSiparislerim");
        if (element == null) {
            logger.info("****** Logout durumda ******");
            existElement("girisYapBtn");
            clickByKey("girisYapBtn");
            existElement("girisYapEpostaInputArea");
            sendKeysByKeyNotClear(mail,"girisYapEpostaInputArea");
            sendKeysByKeyNotClear(sifre,"girisYapSifreInputArea");
            clickByKey("loginBtn");
        }
        waitBySecond(2);
        logger.info("****** Basarili sekilde login olundu ******");

        //Doğru hesap kontrolu yapilmasi icin

        if (!Objects.equals(findElementByKey("loginMailText").getText(), mail)){
            logger.info("****** Yanlis hepap ile login olunmus ******");
            waitBySecond(2);
            swipe(1);
            waitBySecond(2);
            findTextXpath("Çıkış");
            clickWithText("Çıkış");
            waitBySecond(2);
            existElement("popUpCikisBtn");
            clickByKey("popUpCikisBtn");
            waitBySecond(2);
            existElement("digerSekmesi");
            clickByKey("digerSekmesi");
            existElement("girisYapBtn");
            clickByKey("girisYapBtn");
            existElement("girisYapEpostaInputArea");
            sendKeysByKeyNotClear(mail,"girisYapEpostaInputArea");
            sendKeysByKeyNotClear(sifre,"girisYapSifreInputArea");
            clickByKey("loginBtn");
            logger.info("****** Dogru hesapla login olundu ******");
            waitBySecond(2);
            existElement("loginSiparislerim");
        }
    }

    @Step("<key> elementli urunler sepetten silinir")
    public void swipeFromLeftToRightOnCenterY(String key) throws InterruptedException {

        logger.info("Sepet urun kontrolleri yapilacak");

//        List denemee =findElemenstByKeyWithoutAssert(key);


            while (findElementByKeyWithoutAssert(key)!=null){

                logger.info("Sepette urun bulundu");
                waitBySecond(1);
                Dimension elementSize = findElementByKey(key).getSize();

                String yElementSize = String.valueOf(elementSize.height);
                String xElementSize = String.valueOf(elementSize.width);
                int elementY = Integer.parseInt(yElementSize);
                int elementX = Integer.parseInt(xElementSize);

                Point elementPoint = findElementByKey(key).getLocation();
                String elementStartPointY = String.valueOf(elementPoint.y);
                String elementStartPointX = String.valueOf(elementPoint.x);
                int elementBottomY = Integer.parseInt(elementStartPointY);
                int elementBottomX = Integer.parseInt(elementStartPointX);

                System.out.println("Başlangıç noktası X : " + elementBottomX);
                System.out.println("Başlangıç noktası Y : " + (elementBottomY + (elementY / 2)));
                System.out.println("Bitiş noktası X : " + elementX);
                System.out.println("Bitiş noktası Y : " + (elementBottomY + (elementY / 2)));
                System.out.println("Y1 : " + elementBottomY);
                System.out.println("Y2 : " + elementY);

                new TouchAction(appiumDriver)
                        .press(PointOption.point(elementX, (elementBottomY + (elementY / 2))))
                        .waitAction(WaitOptions.waitOptions(ofMillis(3000)))
                        .moveTo(PointOption.point(elementBottomX, (elementBottomY + (elementY / 2))))
                        .release()
                        .perform();
            }
        logger.info("Sepette bulunan urun silindi");
        waitBySecond(1);

        }


    @Step({"<key> elementine var oldukca tiklanir"})
    public void ifLogoutDoLogin(String key) throws InterruptedException {
        MobileElement element;
        waitBySecond(1);
        element = findElementByKeyWithoutAssert(key);
        while (element != null) {
            int i=0;
            logger.info(i+". element bulundu");

            clickByKey(key);

            waitBySecond(2);

            element = findElementByKeyWithoutAssert(key);
            waitBySecond(2);
        }
    }

    @Step({"Android klavye kapatılır"})
    public void closeKeyboard() {
        appiumDriver.hideKeyboard();
    }



}
























