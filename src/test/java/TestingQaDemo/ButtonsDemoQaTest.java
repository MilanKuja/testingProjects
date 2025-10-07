package TestingQaDemo;

import DemoQaButtonsTest.DemoQaRegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonsDemoQaTest extends DemoQaRegisterPage {

    @BeforeEach
    public void startUp(){
        createDriver();
        openUrl("https://demoqa.com/register");

    }

    @Test
    public void testing() {
        DemoQaRegisterPage demoQaRegisterPage = new DemoQaRegisterPage();
        demoQaRegisterPage.clickOnElementsFallDown().clickOnButtonsDropDown().clickMeButton().verifyClickMeButtonIsClicked()
                .rightClickMeButton().verifyRightClickMeButton().doubleClickMeButton().verifyDoubleClickMeButton()
                .verifyTextDoubleClickMeButton().verifyTextRightClickMeButton().verifyTextClickMeButton();
    }

    @AfterEach
    public void tareDown(){
        quitDriver();
    }

}
