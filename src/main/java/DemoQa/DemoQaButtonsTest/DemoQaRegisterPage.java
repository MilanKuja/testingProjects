package DemoQa.DemoQaButtonsTest;

import BaseMethods.BaseMethods2;
import org.openqa.selenium.By;

public class DemoQaRegisterPage extends BaseMethods2 {
    public DemoQaRegisterPage clickOnElementsFallDown(){
        click(getDriver().findElement(By.xpath("//div[normalize-space(text())='Elements']")));
        return this;
    }

    public DemoQaButtonsPage clickOnButtonsDropDown(){
        isElementVisible(getDriver().findElement(By.xpath("//ul//li[@id = 'item-4']//span[normalize-space(text()) = 'Buttons']")));
        click(getDriver().findElement(By.xpath("//ul//li[@id = 'item-4']//span[normalize-space(text()) = 'Buttons']")));
        return new DemoQaButtonsPage();
    }



}
