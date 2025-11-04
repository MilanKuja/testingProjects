package BookingTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingTest extends BookingHomePage{

    @BeforeEach
    public void startUp(){
        openUrl("https://www.booking.com/");
//        wait.until(ExpectedConditions.urlToBe("https://www.booking.com/"));
    }

    @Test
    public void testing(){
        BookingHomePage bookingHomePage = new BookingHomePage();
        bookingHomePage.clickOnValuteButton().selectUSDValue().selecectDestination("Beč").
                dateSelectClick().dateSelect().
                clickOnWhoIsTraveling().addWhoIsTraveling().clickOnSearch().
                selectFilters();


    }

    @AfterEach
    public void tareDown(){
        quitDriver();
    }






}
