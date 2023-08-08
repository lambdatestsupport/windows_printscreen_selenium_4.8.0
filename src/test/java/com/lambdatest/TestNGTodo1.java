package com.lambdatest;

//import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.Duration;
import java.util.Comparator;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestNGTodo1 {
    public static RemoteWebDriver driver;
    public static String uname = "ritamg";
    public static String akey = "lHWNSA0QECwjeN8DoDb9U6KyXMBgAFXqlIIArkxeOTDSeEdLyG";
    public static final String URL = "http://" + uname + ":" + akey + "@hub.lambdatest.com/wd/hub";

    public static void main(String[] args) throws Exception, InterruptedException, IOException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--kiosk-printing");
//        String customDownloadDir = "C:\\Users\\ltuser\\Downloads";
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", customDownloadDir);
//        chromeOptions.setExperimentalOption("prefs", prefs);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability("browserVersion", "113");
//        capabilities.setCapability("platformName", "Windows 10");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk-printing");
        String customDownloadDir = "C:\\Users\\ltuser\\Downloads";
        //chromeOptions.setCapability("download.default_directory","C:\\Users\\ltuser\\Downloads");
        //chromeOptions.setCapability("download.prompt_for_download","false");
        //chromeOptions.setCapability("directory_upgrade","true");
        //chromeOptions.setCapability("plugins.plugins_disabled","Chrome PDF Viewer");
        chromeOptions.addArguments("---printing");
        chromeOptions.setHeadless(true);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", customDownloadDir);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "113");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.9.0");
        ltOptions.put("w3c",true);
        capabilities.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL(URL), capabilities);
        Thread.sleep(4000);
        driver.get("C:\\Users\\ltuser\\Downloads");
        Thread.sleep(4000);

        driver.get("https://chat.openai.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.print();");
        js.executeScript("window.addEventListener('keydown', function(e) { if (e.key === 'Enter') e.preventDefault(); });");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Thread.sleep(100);
//        wait.until(ExpectedConditions.alertIsPresent());
//        // Accept the print dialog
//        driver.switchTo().alert().accept();
//
//        driver.switchTo().alert().accept();
//        driver.switchTo().alert().accept();
//        Robot r = new Robot();
//        r.keyPress(KeyEvent.VK_ENTER);
//        //r.keyRelease(KeyEvent.VK_ESCAPE);
//        driver.switchTo().alert().accept();
//        Set<String> windowHandles = driver.getWindowHandles();
//        if (!windowHandles.isEmpty()) {
//            driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 1]);
//        }
////Now work with the dialog as with an ordinary page:
//        driver.findElement(By.className("cancel")).click();
        driver.get("C:\\Users\\ltuser\\Downloads");

        Thread.sleep(2000);
        driver.get("C:\\Users\\ltuser\\Downloads\\ChatGPT.pdf");
        boolean ritam = (boolean) ((JavascriptExecutor) driver).executeScript("lambda-file-exists=ChatGPT.pdf");;
        System.out.println(ritam);
        String base64EncodedFile = ((JavascriptExecutor) driver).executeScript("lambda-file-content=ChatGPT.pdf").toString();
        System.out.println(base64EncodedFile);
        byte[] byteArray = java.util.Base64.getDecoder().decode(base64EncodedFile);
        FileOutputStream fos;
        File file=new File("D:\\ChatGPT.pdf");
        fos = new FileOutputStream(file);
        System.out.println("Before fos.write");
        //fos.write(byteArray);
        System.out.println("After fos.write");
        fos.close();
        System.out.println("FOS"+fos);
        //driver.get("C:\\Users\\ltuser\\Downloads\\ChatGPT.pdf");
        Thread.sleep(9000);






//        driver.findElement(By.xpath("/html/body/div[2]/div/div/a[22]")).click();


        driver.quit();
    }
}
