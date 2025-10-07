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
public String DestinationNameSelect = "//div[@class = 'a0018a653c']";
public String DateSelect = "//button[@data-testid = 'searchbox-dates-container']";



public BookingHomePage clickOnValuteButton(){
    waitForElementToBeClicable(getDriver().findElement(By.xpath(valuteSelectButton)));
    click(getDriver().findElement(By.xpath(valuteSelectButton)));
    return this;
}

public BookingHomePage selectUSDValue(){
    click(getDriver().findElement(By.xpath(USDvaluteButton)));
    return this;
}

public BookingHomePage selecectDestination(String destinationNameInput){

    waitForElementToBeClicable(getDriver().findElement(By.xpath(DestinationNameInput)));
    sendKeys(getDriver().findElement(By.xpath(DestinationNameInput)), destinationNameInput);
    waitForElementToBeClicable(getDriver().findElement(By.xpath(DestinationNameSelect)));
    click(getDriver().findElement(By.xpath(DestinationNameSelect)));
    return this;
}

public BookingHomePage dateSelect(String startDate, String endDate){
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DateSelect)));
    click(getDriver().findElement(By.xpath(DateSelect)));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(startDate)));
    click(getDriver().findElement(By.xpath(startDate)));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(endDate)));
    click(getDriver().findElement(By.xpath(endDate)));
    return this;
}

}