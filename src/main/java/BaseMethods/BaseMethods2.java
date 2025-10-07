package BaseMethods;

import DriverSetup.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class BaseMethods2 extends Driver{

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


    public void click(WebElement element){
        waitForElementToBeVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public void rightClick(WebElement element){
        waitForElementToBeVisible(element);
        Actions action = new Actions(getDriver());
        action.contextClick(element).perform();

    }

    public void doubleClick(WebElement element){
        waitForElementToBeVisible(element);
        Actions action = new Actions(getDriver());
        action.doubleClick(element).perform();
    }

    private void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    private void waitForElementNotVisible(String xpath){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
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

    public boolean isElementNotVisible(String xpath){
        boolean isNotVisible = true;
        try {
            waitForElementNotVisible(xpath);
        } catch (Exception e) {
            isNotVisible = false;
        }
        return isNotVisible;
    }

    public String getText(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return getDriver().findElement(By.xpath(xpath)).getText().trim();

    }

    public String getStringAttribute(String xpath, String attribute){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return getDriver().findElement(By.xpath(xpath)).getAttribute(attribute);
    }


    public void verifyElementIsDisabled(String xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Assertions.assertFalse(getDriver().findElement(By.xpath(xpath)).isEnabled(), "Element je enabled");
    }

//    @BeforeEach
//    public void startUp(){
//        openUrl("https://demoqa.com/webtables");
//    }

    @AfterEach
    public void tareDown(){

        quitDriver();
    }






}
