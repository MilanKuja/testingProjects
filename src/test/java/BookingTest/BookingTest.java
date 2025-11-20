package BookingTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingTest extends BookingHomePage{

    @BeforeEach
    public void startUp(){
        openUrl("https://www.booking.com/");

    }

    @Test
    public void testing(){
        BookingHomePage bookingHomePage = new BookingHomePage();
        bookingHomePage.regulatePopOut().clickOnValuteSelectButton().selectCurrency("U.S. Dollar").selecectDestination("Vienna").
                dateSelectClick().dateSelect(startDate, endDate)
                .clickOnWhoIsTraveling().addWhoIsTraveling(3).clickOnSearch()
                .selectFreeCancelation().selectHotelFilter().selectSpaFilter().selectAirPortShuffleFilter().selectSortByLowestPrice()
                .adjustPriceRange(800, 1500)
                .selectFirstResoult().verifyFreeRoom();



    }

    @AfterEach
    public void tareDown(){
        quitDriver();
    }






}
