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
        bookingHomePage.clickOn(valuteSelectButton).selectUSDValue(USDcurrency).selecectDestination("Vienna",DestinationNameSelect).
                clickOn(DateSelect).dateSelect(startDate, endDate, DateSelect)
                .clickOn(whoIsTravelingButton).addWhoIsTraveling(3).clickOnSearch()
                .selectFreeCancelation().selectHotelFilter().selectSpaFilter().selectAirPortShuffleFilter().selectSortByLowestPrice()
                .adjustPriceRange(800, 1500)
                .selectFirstResoult().verifyFreeRoom();



    }

    @AfterEach
    public void tareDown(){
        quitDriver();
    }






}
