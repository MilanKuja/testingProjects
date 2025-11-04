package BookingTest;

import BaseMethods.BaseMethods2;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingDestinationPage extends BookingHomePage {

    public String freeCancelationFilter = "//input[@name = 'fc=2']/ancestor::div[@data-filters-item = 'fc:fc=2']//label//span[@class = 'c850687b9b']//span[@class = 'fc70cba028 f823b234fe ca6ff50764']";

    public BookingDestinationPage selectFilters(){

        scrollToElementCenter(getDriver().findElement(By.xpath(freeCancelationFilter)));
        actionClick(getDriver().findElement(By.xpath(freeCancelationFilter)));
        return this;
    }



}
