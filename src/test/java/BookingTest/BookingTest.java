package BookingTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingTest extends BookingHomePage{

    @BeforeEach
    public void startUp(){
        openUrl("https://www.booking.com/");
//        wait.until(ExpectedConditions.urlToBe("https://www.booking.com/"));
    }

    @Test
    public void testing(){
        BookingHomePage bookingHomePage = new BookingHomePage();
        bookingHomePage.clickOnValuteButton().selectUSDValue().selecectDestination("Beč")
                .dateSelect("2025-10-28", "2025-11-05");


    }

    @AfterEach
    public void tareDown(){
        quitDriver();
    }



}
