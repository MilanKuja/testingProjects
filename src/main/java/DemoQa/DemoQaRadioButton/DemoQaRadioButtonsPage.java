package DemoQa.DemoQaRadioButton;

import BaseMethods.BaseMethods2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DemoQaRadioButtonsPage extends BaseMethods2 {
    public String yesRadioButton = "//label[@for = 'yesRadio']";
    public String impressiveRadioButton = "//label[@for = 'impressiveRadio']";
    public String yesRadioButtonConfirmationText = "//p[@class = 'mt-3']";
    public String impressiveRadioButtonConfirmationText = "//p[@class = 'mt-3']";
    public String noRadioButton = "//input[@id = 'noRadio']";


    public DemoQaRadioButtonsPage clickOnRadioButtonYES(){
        click(getDriver().findElement(By.xpath(yesRadioButton)));
        return this;

    }

    public DemoQaRadioButtonsPage veirfyTextDispleyedRadioButtonYes(){
        String expectedText = "You have selected Yes";
        Assertions.assertEquals(expectedText, getText(yesRadioButtonConfirmationText).trim(),"Text ispod Yes Radio Dugmeta nije dobar");
        return this;
    }

    public DemoQaRadioButtonsPage clickOnRadioButtonIMPRESSIVE(){
        click(getDriver().findElement(By.xpath(impressiveRadioButton)));
        return this;
    }

    public DemoQaRadioButtonsPage verifyTestDisplayedImpressiveButton(){
        String expectedText = "You have selected Impressive";
        Assertions.assertEquals(expectedText, getText(impressiveRadioButtonConfirmationText).trim(), "Text ispod Impressive Radio Dugmeta nije dobar");
        return this;
    }


}

