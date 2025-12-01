package DemoQaTestHimera;

import DemoQa.DemoQaHimera.DemoQaAlerts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoQaAlerstTest extends DemoQaAlerts {


    @BeforeEach
    public void startUp(){
        openUrl("https://demoqa.com/alerts");
    }


    @Test
    public void testing() {
        DemoQaAlerts demoQaAlerts = new DemoQaAlerts();
        demoQaAlerts
                .clickAlertButton().clickOkInAlert()
                .clickAlertButtonWithTimer().clickOnAlertWithDelay()
                .clickConfirmButton().clickCancelInAlert()
                .clickPromptBoxButton().typeTextInAlert("LUKA NEDOSTAJES!!! <3").clickOkInAlert();


    }



    @AfterEach
    public void tareDown(){
        quitDriver();
    }
}
