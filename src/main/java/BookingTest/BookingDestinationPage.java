package BookingTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingDestinationPage extends BookingHomePage {

    public String freeCancelationFilter = "//input[@name = 'fc=2']/ancestor::div[@data-filters-item = 'fc:fc=2']//label//span[@class = 'c850687b9b']//span[@class = 'fc70cba028 f823b234fe ca6ff50764']";
    public String hotelsFilter = "//input[contains(@name, '204') and contains(@class, 'faadc60545')]/ancestor::div[contains(@data-filters-item, 'ht_id:ht_id') and contains(@class, '')]//label//span//span[contains(@class, 'fc70cba028')]";
    public String freeCancelationButtonFilter = "//button[@aria-label = 'Free cancellation']";
    public String spaFilter = "//input[contains(@aria-label, 'Spa:')]/ancestor::div[contains(@data-filters-item , 'hotelfacility:hotelfacility')]//label//span//span[contains(@class ,'fc70cba028')]";
    public String expandFacilitiesButton = "//button[contains(@aria-controls, 'filter_group_hotelfacility') and .//div[contains(., 'Show all')]]";
    public String airPorstShuttleFilter = "//input[contains(@aria-label, 'Airport shuttle')]/ancestor::div[contains(@data-filters-item, 'hotelfacility:hotelfacility=17')]//label//span//span[contains(@class, 'fc70cba028')]";
    public String sortByDropDown = "//button[@data-testid = 'sorters-dropdown-trigger']";
    public String lowestPriceFilter = "//button[@data-id = 'price']";
    public String getLeftSliderMinMax = "//div[contains(@class, 'e7e')]//input[@aria-label = 'Min.']";
    public String getRightSliderMinMax = "//div[contains(@class, 'e7e')]//input[@aria-label = 'Max.']";
    public String firstResoult = "//div[@data-testid = 'property-card'][1]//div[@data-testid = 'availability-cta']";


    public BookingDestinationPage selectFreeCancelation() {
        try {
            actionClickJavaScript(freeCancelationFilter);
        } catch (Exception e) {
            System.out.println("This filter does not exist");
        }

        return this;
    }

    public BookingDestinationPage selectHotelFilter() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(freeCancelationButtonFilter)));
            actionClickJavaScript(hotelsFilter);
        } catch (Exception e) {
            System.out.println();
        }

        return this;
    }

    public BookingDestinationPage selectSpaFilter() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expandFacilitiesButton)));
            scrollToElementCenter(getDriver().findElement(By.xpath(expandFacilitiesButton)));
            click(getDriver().findElement(By.xpath(expandFacilitiesButton)));
            actionClickJavaScript(spaFilter);
        } catch (Exception e) {
            System.out.println("This filter does not exist");
        }
        return this;
    }

    public BookingDestinationPage selectAirPortShuffleFilter() {
        try {
            scrollToElementCenter(getDriver().findElement(By.xpath(airPorstShuttleFilter)));
            actionClickJavaScript(airPorstShuttleFilter);
        } catch (Exception e) {
            System.out.println("This filter does not exist");
        }

        return this;
    }

    public BookingDestinationPage selectSortByLowestPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sortByDropDown)));
        click(getDriver().findElement(By.xpath(sortByDropDown)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lowestPriceFilter)));
        click(getDriver().findElement(By.xpath(lowestPriceFilter)));
        return this;
    }


    public BookingDestinationPage adjustPriceRange(int minPrice, int maxPrice) {

        moveSliderToValue(getLeftSliderMinMax, minPrice);

        moveSliderToValue(getRightSliderMinMax, maxPrice);

        return this;
    }


    public BookingResoultPage selectFirstResoult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstResoult)));
        click(wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath(firstResoult)))));
        switchToNewTab();
        return new BookingResoultPage();

    }


}





