package BaseMethods;

import DriverSetup.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class BaseMethods extends Driver{

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


    public void click(WebElement element){
        waitForElementToBeVisible(element);
        element.click();

    }

    public void waitForElementLocated(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    private void waitForElementNotVisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void openUrl(String url){
        createDriver();
        getDriver().navigate().to(url);
    }

    public void sendKeys(WebElement element, String text){
        waitForElementToBeVisible(element);
        element.sendKeys(text);
    }

    public void switchToNewTab(){
       String originalTab = getDriver().getWindowHandle();
        Set <String> allTabs = getDriver().getWindowHandles();
        for (String tab : allTabs) {
            if(!tab.equals(originalTab)) {
                getDriver().switchTo().window(tab);
                break;
            }

        }

    }
    public boolean isElementVisible(WebElement element){
        boolean isVisible = true;
        try {
            waitForElementToBeVisible(element);
        }
        catch (Exception e){
            isVisible = false;
        }
        return isVisible;
    }

    public boolean isElementNotVisible(WebElement element){
        boolean isNotVisible = true;
        try {
            waitForElementNotVisible(element);
        } catch (Exception e) {
            isNotVisible = false;
        }
        return isNotVisible;
    }




}
