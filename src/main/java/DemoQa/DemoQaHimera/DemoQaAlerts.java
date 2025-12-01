package DemoQa.DemoQaHimera;

import BaseMethods.BaseMethods2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaAlerts extends BaseMethods2 {

    public String alertButton = "//button[@id = 'alertButton']";
    public String alertButtonWithTimer = "//button[@id = 'timerAlertButton']";
    public String confirmButton = "//button[@id = 'confirmButton']";
    public String promptBoxButton = "//button[@id = 'promtButton']";

    public DemoQaAlerts clickAlertButton(){
        click(getDriver().findElement(By.xpath(alertButton)));
        return this;
    }
    public DemoQaAlerts clickAlertButtonWithTimer(){
        click(getDriver().findElement(By.xpath(alertButtonWithTimer)));
        return this;
    }
    public DemoQaAlerts clickConfirmButton(){
        click(getDriver().findElement(By.xpath(confirmButton)));
        return this;
    }
    public DemoQaAlerts clickPromptBoxButton(){
        click(getDriver().findElement(By.xpath(promptBoxButton)));
        return this;
    }
    public DemoQaAlerts clickOkInAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        return this;

    }
    public DemoQaAlerts clickCancelInAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
        return this;

    }
    public DemoQaAlerts typeTextInAlert(String textZaKucanje){
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(textZaKucanje);
        return this;

    }

    public DemoQaAlerts clickOnAlertWithDelay(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }
}








