package TestTollsQALogInPage;

import DriverSetup.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage extends Driver {

    @BeforeEach
    public void startUp(){
    createDriver();
    getDriver().navigate().to("https://demoqa.com/register");


    }



    @Test
    public void TestValidLogIn() {

        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logInPage = getDriver().findElement(By.xpath("//li//span[text()='Login']"));
        logInPage.click();

        WebElement UserNameField = getDriver().findElement(By.xpath("//input[@id = 'userName']"));
        UserNameField.clear();
        UserNameField.sendKeys("kraljina");

        WebElement PasswordField = getDriver().findElement(By.xpath("//input[@id= 'password']"));
        PasswordField.clear();
        PasswordField.sendKeys("Bureci123@!");


        WebElement LoginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'buttonWrap')]//button[@id='login']")));


        try {
            LoginBtn.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", LoginBtn);
        }


        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
        // verifikacija

        String expectedUrl = "https://demoqa.com/profile";
        String acctualUrl = getDriver().getCurrentUrl();

        if (expectedUrl.equals(acctualUrl)) {
            System.out.println("Test je uspesan");
        } else {
            System.out.println("Test nije uspesan");

        }

        WebElement LogOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//button[text() = 'Log out']")));
        LogOut.click();

        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/login"));
        String endUrl = "https://demoqa.com/login";
        acctualUrl = getDriver().getCurrentUrl();
        if (endUrl.equals(acctualUrl)) {
            System.out.println("Test uspesno zavrsen");
            } else {
            System.out.println("Test nije uspesno zavrsen");;
        }

    }

    @Test
    public void TestInvalidLogIn()  {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement logInPage = getDriver().findElement(By.xpath("//li//span[text()='Login']"));
        logInPage.click();

        getDriver().findElement(By.xpath("//input[@id = 'userName']")).sendKeys("aaaaaa");
        getDriver().findElement(By.xpath("//input[@id= 'password']")).sendKeys("asdadas");
        WebElement LoginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'buttonWrap')]//button[@id='login']")));


        try {
            LoginBtn.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", LoginBtn);
        }


        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'name']")));
        String massage1 = message.getText();
        String textMassage = "Invalid username or password!";
        System.out.println(massage1);
        if (message.getText().equals(textMassage)) {
            System.out.println("Test is good");
        } else {
            System.out.println("Test failed");
        }




    }




    @AfterEach
    public void closeDriver() {
        quitDriver();
    }


}
