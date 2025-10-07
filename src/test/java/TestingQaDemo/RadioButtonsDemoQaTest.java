package TestingQaDemo;

import DemoQaRadioButton.DemoQaRadioButtonsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RadioButtonsDemoQaTest extends DemoQaRadioButtonsPage {

    @BeforeEach
    public void startUp(){
        openUrl("https://demoqa.com/radio-button");
    }

    @Test
    public void testing(){
        DemoQaRadioButtonsPage demoQaRadioButtonsPage = new DemoQaRadioButtonsPage();
        demoQaRadioButtonsPage.clickOnRadioButtonYES().veirfyTextDispleyedRadioButtonYes().clickOnRadioButtonIMPRESSIVE().verifyTestDisplayedImpressiveButton()
                .verifyElementIsDisabled(noRadioButton);

    }
    @AfterEach
    public void tareDown(){
        quitDriver();
    }


}