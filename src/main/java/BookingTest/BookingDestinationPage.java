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
    public String rightSlider = "(//div[@data-testid='filters-group-slider']//div[contains(@class,'fc') and contains(@style,'left')])[last()]";
    public String sliderBar = "//div[@data-testid='filters-group-slider']";


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

    public BookingDestinationPage adjustPriceRange(int minPrice, int maxPrice) {
        // Scroll do slidera da bude vidljiv
        scrollToElementCenter(getDriver().findElement(By.xpath(sliderBar)));

        // Sačekaj malo da JS renderuje slider (Booking je spor)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sliderWidth = getDriver().findElement(By.xpath(sliderBar)).getSize().width;
        int min = 300;    // Booking price range počinje od 0
        int max = 3000; // realna gornja vrednost koju koristi slider

        int leftOffset = (int) ((double)(minPrice - min) / (max - min) * sliderWidth);
        int rightOffset = (int) -((double)(maxPrice - min) / (max - min) * sliderWidth - sliderWidth);

        // Pomeri levi slider
        setSlider(leftSlider, leftOffset);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rightSlider)));

        // Pomeri desni slider
        setSlider(rightSlider, rightOffset);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }





}





