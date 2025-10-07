package BookingTest;

import BaseMethods.BaseMethods2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingHomePage extends BaseMethods2 {


public WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
public String valuteSelectButton = "//button[@data-testid = 'header-currency-picker-trigger']";
public String USDvaluteButton = "//span[text() = 'U.S. Dollar']";
public String DestinationNameInput = "//input[@id = ':rh:']";
public String DestinationNameSelect = "//div[text() = 'Beč']";
public String DateSelect = "//button[@data-testid = 'searchbox-dates-container']";
public String StartDate = "//span[@date-display-field-start]";
public String EndDate = "//span[@date-display-field-end]";




public BookingHomePage clickOnValuteButton(){
    click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(valuteSelectButton))));
    return this;
}

public BookingHomePage selectUSDValue(){
    click(getDriver().findElement(By.xpath(USDvaluteButton)));
    return this;
}

public BookingHomePage selecectDestination(String destinationNameInput){

    sendKeys(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DestinationNameInput))), destinationNameInput);
    click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DestinationNameSelect))));
    return this;
}

    public BookingHomePage dateSelect(String startDate, String endDate) {
        // 1. Otvori picker
        click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DateSelect))));

        // 2. Generiši XPath-ove
        String startXpath = String.format("//span[@data-date='%s']", startDate);
        String endXpath = String.format("//span[@data-date='%s']", endDate);

        // 3. Klikni start datum, skrol kroz mesece ako nije vidljiv
        while (getDriver().findElements(By.xpath(startXpath)).isEmpty()) {
            click(getDriver().findElement(By.xpath("//button[@data-testid='calendar-next']")));
            // optional mali delay da DOM završi render
            try { Thread.sleep(100); } catch (InterruptedException e) { }
        }
        click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(startXpath))));

        // 4. Klikni end datum (picker i dalje otvoren)
        while (getDriver().findElements(By.xpath(endXpath)).isEmpty()) {
            click(getDriver().findElement(By.xpath("//button[@data-testid='calendar-next']")));
            try { Thread.sleep(100); } catch (InterruptedException e) { }
        }
        click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(endXpath))));

        return this;
}

}