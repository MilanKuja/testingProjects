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
        bookingHomePage.clickOnValuteButton().selectUSDValue(USDcurrency).selecectDestination("Beč").
                dateSelectClick().dateSelect(startDate, endDate).
                clickOnWhoIsTraveling().addWhoIsTraveling().clickOnSearch()
                .selectFreeCancelation().selectHotelFilter().selectSpaFilter().selectAirPortShuffleFilter().selectSortByLowestPrice()
                .adjustPriceRangeLeft(800).adjustPriceRangeRight(1500)
                .selectFirstResoult().verifyFreeRoom();



    }

    @AfterEach
    public void tareDown(){
        quitDriver();
    }






}
