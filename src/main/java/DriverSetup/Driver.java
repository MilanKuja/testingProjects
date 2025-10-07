package DriverSetup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class Driver   {
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
//    private static final String CHROME_DRIVER_PATH = "D:\\Kursevi\\HimeraKurs\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";

    private static WebDriver driver;

    protected static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static List<String> createDriver() {
        if (getDriver() == null) {
            try {

                InputStream inputStream = Driver.class.getClassLoader().getResourceAsStream("chromedriver.exe");

                if (inputStream == null) {
                    throw new RuntimeException("chromedriver.exe nije pronađen u resources!");
                }

                // Napravi privremeni fajl na disku
                File tempFile = File.createTempFile("chromedriver", ".exe");
                tempFile.deleteOnExit();

                try (FileOutputStream out = new FileOutputStream(tempFile)) {
                    inputStream.transferTo(out);
                }

                // Postavi putanju do temp fajla
                System.setProperty(CHROME_DRIVER, tempFile.getAbsolutePath());

            } catch (Exception e) {
                throw new RuntimeException("Greška prilikom preuzimanja chromedriver.exe iz resources", e);
            }

            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
            setDriver(driver);
        }
        return null;
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            setDriver(null);
        }
    }
}