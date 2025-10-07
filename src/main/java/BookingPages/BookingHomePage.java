package BookingPages;

import BaseMethods.BaseMethods2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingHomePage extends BaseMethods2 {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public  String valuteButton = "//button[@data-testid = 'header-currency-picker-trigger']";
    public String americanDollar = "//div[@data-testid = 'Sve valute']//button[@data-testid = 'selection-item']//span[text() = 'Američki dolar']";
    public String destinationSelection = "//input[@id = ':rj:']";
    public String destinationPlaceSelect = "//div[text() = 'Beč']";


    public BookingHomePage selectAmericanDollar(){
        click(getDriver().findElement(By.xpath(valuteButton)));
        click(getDriver().findElement(By.xpath(americanDollar)));
        return this;
    }

    public BookingHomePage selectDestination(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(destinationSelection)));
        sendKeys(getDriver().findElement(By.xpath(destinationSelection)), "Beč");
        click(getDriver().findElement(By.xpath(destinationPlaceSelect)));
        return this;
    }

}
