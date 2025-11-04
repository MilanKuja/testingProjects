package BaseMethods;

import DriverSetup.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class BaseMethods2 extends Driver{

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    public void click(WebElement element){
        waitForElementToBeVisible(element);
        waitForElementToBeClicable(element);
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

    public void actionClick(WebElement element) {
        waitForElementToBeClicable(element);
        Actions actions = new Actions(getDriver());
        actions.click(element).perform();
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    private void waitForElementNotVisible(String xpath){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForElementToBeClicable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
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

    // Scroll element na sredinu ekrana
    public void scrollToElementCenter(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
    }

    // Scroll malo niže ili više (npr. scrollBy(0, 500))
    public void scrollBy(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // Scroll skroz na dno strane
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll na sam vrh strane
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }
}







