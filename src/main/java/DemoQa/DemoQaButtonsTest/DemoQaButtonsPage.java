package DemoQa.DemoQaButtonsTest;

import BaseMethods.BaseMethods2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DemoQaButtonsPage extends BaseMethods2 {
    public DemoQaButtonsPage clickMeButton() {
        click(getDriver().findElement(By.xpath("//button[text()='Click Me']")));
        return this;

    }
    public DemoQaButtonsPage verifyClickMeButtonIsClicked(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//p[@id = 'dynamicClickMessage']"))));
        return this;
    }

    public DemoQaButtonsPage rightClickMeButton(){
        rightClick(getDriver().findElement(By.xpath("//button[text() ='Right Click Me']")));
        return this;
    }

    public DemoQaButtonsPage verifyRightClickMeButton(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//p[text() = 'You have done a right click']"))));
        return this;
    }

    public DemoQaButtonsPage doubleClickMeButton(){
        doubleClick(getDriver().findElement(By.xpath("//button[text() = 'Double Click Me']")));
        return this;
    }

    public DemoQaButtonsPage verifyDoubleClickMeButton(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//p[text() = 'You have done a double click']"))));
        return this;
    }

    public DemoQaButtonsPage verifyTextDoubleClickMeButton(){
        String expectedText = "You have done a double click";
        Assertions.assertEquals(expectedText,getText("//p[text() = 'You have done a double click']"),"Dupli klik poruka nije dobra" );
        return this;
    }

    public DemoQaButtonsPage verifyTextRightClickMeButton(){
        String expectedText = "You have done a right click";
        Assertions.assertEquals(expectedText,getText("//p[@id = 'rightClickMessage']"), "Right click poruka nije dobra");
        return this;

    }

    public DemoQaButtonsPage verifyTextClickMeButton(){
        String expectedText = getText("//p[@id = 'dynamicClickMessage']");
        Assertions.assertEquals(expectedText, getText("//p[@id = 'dynamicClickMessage']"), "Klik poruka nije dobra");
        return this;
    }

    }
