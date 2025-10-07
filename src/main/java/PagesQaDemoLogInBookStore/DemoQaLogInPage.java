package PagesQaDemoLogInBookStore;

import BaseMethods.BaseMethods;
import org.openqa.selenium.By;

public class DemoQaLogInPage extends BaseMethods {
    public DemoQaLogInPage typeUserName(String username) {
       sendKeys(getDriver().findElement(By.xpath("//input[@id = 'userName']")), username);
       return this;
    }

    public DemoQaLogInPage typePassword(String password){
        sendKeys(getDriver().findElement(By.xpath("//input[@id= 'password']")), password);
        return this;
    }

    public DemoQaProfilePage loginBtn(){
        click(getDriver().findElement(By.xpath("//div[contains(@class, 'buttonWrap')]//button[@id='login']")));
        return new DemoQaProfilePage();
    }



}
