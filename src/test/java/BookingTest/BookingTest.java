package BookingTest;

import BookingPages.BookingHomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingTest extends BookingHomePage {

    @BeforeEach
    public void startUp(){
        openUrl("https://www.booking.com/index.sr.html?aid=2311236;label=sr-rs-booking-desktop-JI7Eac0gnD5IndgCf2y5PAS652796014488:pl:ta:p1:p2:ac:ap:neg:fi:tikwd-65526620:lp2688:li:dec:dm;ws=&gad_source=1&gad_campaignid=19655507730&gbraid=0AAAAAD_Ls1Lx5mzpeGSb6XFA-6cKX55mV&gclid=Cj0KCQjwovPGBhDxARIsAFhgkwRLIG9kA47U7JJbW-fkjPxg-79vqXvaM-wb7Danokwcb4TSMGTXeCoaArjaEALw_wcB");
    }

    @Test
    public void testing(){
        BookingHomePage bookingHomePage = new BookingHomePage();
        bookingHomePage.selectAmericanDollar().selectDestination();

    }



}
