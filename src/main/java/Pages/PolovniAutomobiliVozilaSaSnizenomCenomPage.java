package Pages;

import BaseMethods.BaseMethods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PolovniAutomobiliVozilaSaSnizenomCenomPage extends BaseMethods {

    public PolovniAutomobiliVozilaSaSnizenomCenomPage verifyAutomobiliSaSnizenomCenomText(String expectedValue){

        WebElement element = getDriver().findElement(By.xpath("//h1[@class = 'searchTitle']"));
        String elementText = element.getText();
        Assertions.assertEquals(expectedValue, elementText, "Text na stranici za snizene cene nije kao sto je ocekivano");
        return this;
    }
}
