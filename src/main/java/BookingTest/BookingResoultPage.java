package BookingTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class BookingResoultPage extends BookingHomePage{
    public String verifyFreeRoom = "//*[contains(text(), 'Recommended for 3')]";


    public BookingResoultPage verifyFreeRoom(){
        Assertions.assertTrue(getDriver().findElement(By.xpath(verifyFreeRoom)).isDisplayed(), "There is no free rooms");
        return this;
    }




}
