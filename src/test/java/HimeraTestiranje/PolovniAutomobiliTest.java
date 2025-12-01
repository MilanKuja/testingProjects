package HimeraTestiranje;

import DemoQa.Pages.PolovniAutomobiliHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PolovniAutomobiliTest  extends PolovniAutomobiliHomePage {

     static String OCEKIVANI_TEKST = "Oglasi automobila sa sniženom cenom u poslednjih 7 dana";

    @BeforeEach
    public void startUp(){
        openUrl("https://www.polovniautomobili.com/");
    }




    @Test
    public void testing(){
        PolovniAutomobiliHomePage pl = new PolovniAutomobiliHomePage();
        pl.openBrandMenu().search().clickVozilaSaSnizenomCenom().verifyAutomobiliSaSnizenomCenomText(OCEKIVANI_TEKST);


    }








    @AfterEach
    public void tareDown(){
        quitDriver();
    }







}
