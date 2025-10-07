package Pages;

import BaseMethods.BaseMethods;
import org.openqa.selenium.By;

public class PolovniAutomobiliHomePage extends BaseMethods {

    public PolovniAutomobiliHomePage openBrandMenu(){
        click(getDriver().findElement(By.xpath("//div[contains(@class, 'sumo_brand')]//p[contains(@class, 'SelectBox search')]//label")));
        return this;
    }

    public PolovniAutomobiliSearchPage search(){
        click(getDriver().findElement(By.xpath("//button[@name = 'submit_1']")));
        return new PolovniAutomobiliSearchPage();
    }

}
