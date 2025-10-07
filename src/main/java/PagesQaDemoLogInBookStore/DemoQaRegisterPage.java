package PagesQaDemoLogInBookStore;

import BaseMethods.BaseMethods;
import org.openqa.selenium.By;

public class DemoQaRegisterPage extends BaseMethods {
    public DemoQaLogInPage clickOnLogin(){
        click(getDriver().findElement(By.xpath("//span[text()='Login']")));
        return new DemoQaLogInPage();
    }
}
