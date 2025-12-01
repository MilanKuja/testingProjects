package DemoQa.Pages;

import BaseMethods.BaseMethods;
import org.openqa.selenium.By;

public class PolovniAutomobiliSearchPage extends BaseMethods {

    public PolovniAutomobiliVozilaSaSnizenomCenomPage clickVozilaSaSnizenomCenom(){
        click(getDriver().findElement(By.xpath("//a[@class = 'paGrayButtonTertiary uk-width-1-1']/parent::div")));
        switchToNewTab();
        return new PolovniAutomobiliVozilaSaSnizenomCenomPage();
    }
}
