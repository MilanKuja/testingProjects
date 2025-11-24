package FaceBookTest;

import BaseMethods.BaseMethods2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BooleanSupplier;

public class FaceBookLogInPage extends BaseMethods2 {

    public String emailInputField = "//input[@id = 'email']";
    public String passwordInputField = "//input[@id = 'password']";
    public String homePage = "//a[contains(@class, 'x1i10hfl xjbqb8w x1ejq31n x18oe1m7 x1sy0etr xstzfhl x972fbf x10w94by x1qhh985 x14e42zd x9f619 x1ypdohk x3ct3a4 xdj266r x14z9mp xat24cr x1lziwak xexx8yu xyri2b x18d9i69 x1c1uobl x16tdsg8 x1hl2dhg xggy1nq x1fmog5m xu25z0z x140muxe xo1y3bh x87ps6o x1lku1pv x1a2a7pz x6s0dn4 x78zum5 xdt5ytf x5yr21d xl56j7k x1n2onr6 xh8yej3')]//span[@class = 'x1n8ud3w x10l6tqk x1v4kod4'][1]";

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public FaceBookLogInPage checkIfLoggedIn(){
        isElementVisible(getDriver().findElement(By.xpath(homePage)));
        return this;
    }

    public FaceBookLogInPage typeEmail(String email) {
        sendKeys(getDriver().findElement(By.xpath(emailInputField)), email);
        return this;
    }

    public FaceBookLogInPage typePassword(String password) {
        sendKeys(getDriver().findElement(By.xpath(emailInputField)), password);
        return this;
    }




}
