package BookingTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingResoultPage extends BookingHomePage{
//    public String verifyFreeRoom = "//*[contains(text(), 'Recommended for %s')]";
    public String VerifyFreeRoomFor(String verifyFreeRoom) {
        return String.format("//*[contains(text(), 'Recommended for %s')]", verifyFreeRoom);
    }


    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public BookingResoultPage verifyFreeRoom(String numberOfPeople){
        waitForElementToBeVisible(getDriver().findElement(By.xpath(VerifyFreeRoomFor(numberOfPeople))));
        Assertions.assertTrue(getDriver().findElement(By.xpath(VerifyFreeRoomFor(numberOfPeople))).isDisplayed(), "There is no free rooms");
        return this;
    }




}
