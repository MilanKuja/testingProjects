package BookingTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingDestinationPage extends BookingHomePage {

    public String freeCancelationFilter = "//input[@name = 'fc=2']/ancestor::div[@data-filters-item = 'fc:fc=2']//label//span[@class = 'c850687b9b']//span[@class = 'fc70cba028 f823b234fe ca6ff50764']";
    public String hotelsFilter = "//input[contains(@name, '204') and contains(@class, 'faadc60545')]/ancestor::div[contains(@data-filters-item, 'ht_id:ht_id') and contains(@class, '')]//label//span//span[contains(@class, 'fc70cba028')]";
    public String freeCancelationButtonFilter = "//button[@aria-label = 'Free cancellation']";
    public String spaFilter = "//input[contains(@aria-label, 'Spa:')]/ancestor::div[contains(@data-filters-item , 'hotelfacility:hotelfacility')]//label//span//span[contains(@class ,'fc70cba028')]";
    public String expandFacilitiesButton = "//button[contains(@aria-controls, 'filter_group_hotelfacility') and .//div[contains(., 'Show all')]]";
    public String leftSlider = "//div[@data-testid='filters-group-slider']//div[contains(@class,'fc') and contains(@style,'left')]";
    public String rightSlider = "//input[@aria-label='Max.']/following-sibling::div[@class='fc835e65e6']";
    public String sliderBar = "//div[@data-testid='filters-group-slider']";
    public String airPorstShuttleFilter = "//input[contains(@aria-label, 'Airport shuttle')]/ancestor::div[contains(@data-filters-item, 'hotelfacility:hotelfacility=17')]//label//span//span[contains(@class, 'fc70cba028')]";
    public String sortByDropDown = "//button[@data-testid = 'sorters-dropdown-trigger']";
    public String lowestPriceFilter = "//button[@data-id = 'price']";

    public BookingDestinationPage selectFreeCancelation(){
        actionClickJavaScript(freeCancelationFilter);
        return this;
    }

    public BookingDestinationPage selectHotelFilter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(freeCancelationButtonFilter)));
        actionClickJavaScript(hotelsFilter);
        return this;
    }

    public BookingDestinationPage selectSpaFilter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expandFacilitiesButton)));
        scrollToElementCenter(getDriver().findElement(By.xpath(expandFacilitiesButton)));
        click(getDriver().findElement(By.xpath(expandFacilitiesButton)));
        actionClickJavaScript(spaFilter);
        return this;
    }

    public BookingDestinationPage selectAirPortShuffleFilter(){
        scrollToElementCenter(getDriver().findElement(By.xpath(airPorstShuttleFilter)));
        actionClickJavaScript(airPorstShuttleFilter);
        return this;
    }

    public BookingDestinationPage selectSortByLowestPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sortByDropDown)));
        click(getDriver().findElement(By.xpath(sortByDropDown)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lowestPriceFilter)));
        click(getDriver().findElement(By.xpath(lowestPriceFilter)));
        return this;
    }

    public BookingDestinationPage adjustPriceRangeLeft(int minPrice) {
        // Scroll do slidera da bude vidljiv
        scrollToElementCenter(getDriver().findElement(By.xpath(sliderBar)));

        // Sačekaj malo da JS renderuje slider (Booking je spor)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sliderWidth = getDriver().findElement(By.xpath(sliderBar)).getSize().width;
        int minleft = 450;    // Booking price range počinje od 0
        int maxleft = 1950; // realna gornja vrednost koju koristi slider

        // Pomeri levi slider
        int leftOffset = (int) ((double)(minPrice - minleft) / (maxleft - minleft) * sliderWidth);
        setSlider(leftSlider, leftOffset);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public BookingDestinationPage adjustPriceRangeRight(int maxPrice) {
        // Scroll do slidera da bude vidljiv
        scrollToElementCenter(getDriver().findElement(By.xpath(sliderBar)));

        // Sačekaj malo da JS renderuje slider (Booking je spor)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int RightsliderWidth = getDriver().findElement(By.xpath(sliderBar)).getSize().width;
        int minRight = 650;
        int maxRight = 2000;

        // Pomeri desni slider
        int rightOffset = (int) -((double)(maxPrice - minRight) / (maxRight - minRight) * RightsliderWidth);
        setSlider(rightSlider, rightOffset);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }




}





