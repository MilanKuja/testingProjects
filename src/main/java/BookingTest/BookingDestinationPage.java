package BookingTest;

import BaseMethods.BaseMethods2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingDestinationPage extends BookingHomePage {

    public String freeCancelationFilter = "//input[@id = ':r41:']/ancestor::div[@data-filters-item = 'fc:fc=2']//label//span[@class = 'c850687b9b']//span[@class = 'fc70cba028 f823b234fe ca6ff50764']";

    public BookingDestinationPage selectFilters(){
        click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(freeCancelationFilter))));
        return this;
    }


}
