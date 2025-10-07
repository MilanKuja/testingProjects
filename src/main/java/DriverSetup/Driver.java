package DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Driver   {
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "D:\\Kursevi\\HimeraKurs\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";

    private static WebDriver driver;

    protected static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static List<String> createDriver() {
        if (getDriver() == null) {
            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
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
