package BookingTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingTest extends BookingHomePage {

    @BeforeEach
    public void startUp() {
        openUrl("https://www.booking.com/");
        BookingHomePage bookingHomePage = new BookingHomePage();
        bookingHomePage.regulatePopOut();
    }

    @Test
    public void testing() {
        BookingHomePage bookingHomePage = new BookingHomePage();
        bookingHomePage.clickOnValuteSelectButton().selectCurrency("U.S. Dollar").selecectDestination("Vienna").clickDestination("Vienna").
                dateSelectClick().dateSelect(startDate, endDate)
                .clickOnWhoIsTraveling().addWhoIsTraveling(3).roomsNumber(1).clickOnSearch()
                .selectFreeCancelation().selectHotelFilter().selectSpaFilter().selectAirPortShuffleFilter().selectSortByLowestPrice()
                .adjustPriceRange(1000, 1500)
                .selectFirstResoult().verifyFreeRoom("3");


    }

    @AfterEach
    public void tareDown() {
        quitDriver();
    }


}
