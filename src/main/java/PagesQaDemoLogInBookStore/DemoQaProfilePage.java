package PagesQaDemoLogInBookStore;

import BaseMethods.BaseMethods;
import org.openqa.selenium.By;

public class DemoQaProfilePage extends BaseMethods {
    public DemoQaBookStore clickOnGoToBookStore(){
        waitForElementLocated("//button[@id = 'gotoStore']");
        click(getDriver().findElement(By.xpath("//button[@id = 'gotoStore']")));
        return new DemoQaBookStore();

    }
}
