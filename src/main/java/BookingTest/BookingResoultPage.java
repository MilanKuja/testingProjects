package BookingTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingResoultPage extends BookingHomePage{
    public String verifyFreeRoom = "//*[contains(text(), 'Recommended for 3')]";

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public BookingResoultPage verifyFreeRoom(){
        waitForElementToBeVisible(getDriver().findElement(By.xpath(verifyFreeRoom)));
        Assertions.assertTrue(getDriver().findElement(By.xpath(verifyFreeRoom)).isDisplayed(), "There is no free rooms");
        return this;
    }




}
