package BookingTest;

import BaseMethods.BaseMethods2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public String startDate = "//span[@aria-label='Th 27 November 2025']";
public String endDate = "//span[@aria-label='Fr 5 December 2025']";
public String  whoIsTravelingButton = "//button[@data-testid = 'occupancy-config']";
public String whoIsTravelingAddButton = "//label[text()='Adults']/ancestor::div[@class='c5aae0350e']/following-sibling::div//button[@class = 'de576f5064 b46cd7aad7 e26a59bb37 c295306d66 c7a901b0e7 aaf9b6e287 dc8366caa6']";
public String searchButton = "//button[@class = 'de576f5064 b46cd7aad7 ced67027e5 dda427e6b5 e4f9ca4b0c ca8e0b9533 cfd71fb584 a9d40b8d51']";


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

    public BookingHomePage dateSelectClick() {
        actionClick(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DateSelect))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DateSelect)));
    return this;
}
    public BookingHomePage dateSelect() {
        actionClick(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DateSelect))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DateSelect)));
        actionClick(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(startDate))));
        actionClick(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(endDate))));

        return this;
    }

    public BookingHomePage clickOnWhoIsTraveling(){
    actionClick(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(whoIsTravelingButton))));
    return this;
    }

    public BookingHomePage addWhoIsTraveling(){
    click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(whoIsTravelingAddButton))));
    return this;
    }

    public BookingDestinationPage clickOnSearch(){
    click(getDriver().findElement(By.xpath(searchButton)));
        BookingDestinationPage BookingDestinationPage = new BookingDestinationPage();
        return BookingDestinationPage;
    }

}