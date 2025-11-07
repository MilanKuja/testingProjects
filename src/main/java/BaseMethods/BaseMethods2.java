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


public class BaseMethods2 extends Driver {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    //Click metode
    public void click(WebElement element) {
        waitForElementToBeClicable(element);
        element.click();

    }

    public void rightClick(WebElement element) {
        waitForElementToBeVisible(element);
        Actions action = new Actions(getDriver());
        action.contextClick(element).perform();

    }

    public void doubleClick(WebElement element) {
        waitForElementToBeVisible(element);
        Actions action = new Actions(getDriver());
        action.doubleClick(element).perform();
    }

    public void actionClick(WebElement element) {
        waitForElementToBeClicable(element);
        Actions actions = new Actions(getDriver());
        actions.click(element).perform();
    }

    public void actionClickJavaScript(String xpath) {
        try {
            // 1. Sačekaj da element postoji u DOM-u
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            // 2. Skroluj element u centar ekrana
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // 3. Sačekaj da bude vidljiv i klikabilan
            waitForElementToBeClicable(element);

            // 4. Pokušaj normalan klik
            actionClick(element);
        } catch (Exception e) {
            // 5. Fallback ako overlay sprečava klik
            WebElement element = getDriver().findElement(By.xpath(xpath));
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void setSlider(String sliderHandle, int offSet){
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getDriver().findElement(By.xpath(sliderHandle)))
                .moveByOffset(offSet, 0)
                .release()
                .perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    //Wait metode
    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    private void waitForElementNotVisible(String xpath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForElementToBeClicable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    //GET METODE
    public String getText(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return getDriver().findElement(By.xpath(xpath)).getText().trim();

    }

    public String getStringAttribute(String xpath, String attribute) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return getDriver().findElement(By.xpath(xpath)).getAttribute(attribute);
    }


    //SCROLL METODE
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

    public void openUrl(String url) {
        createDriver();
        getDriver().navigate().to(url);
    }

    //Verify metode
    public void verifyElementIsDisabled(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Assertions.assertFalse(getDriver().findElement(By.xpath(xpath)).isEnabled(), "Element je enabled");

    }

    public boolean isElementVisible(WebElement element) {
        boolean isVisible = true;
        try {
            waitForElementToBeVisible(element);
        } catch (Exception e) {
            isVisible = false;
        }
        return isVisible;
    }

    public boolean isElementNotVisible(String xpath) {
        boolean isNotVisible = true;
        try {
            waitForElementNotVisible(xpath);
        } catch (Exception e) {
            isNotVisible = false;
        }
        return isNotVisible;
    }

    //Ostale metode
    public void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.sendKeys(text);
    }

    public void switchToNewTab() {
        String originalTab = getDriver().getWindowHandle();
        Set<String> allTabs = getDriver().getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                getDriver().switchTo().window(tab);
                break;
            }

        }


    }

    public void setPriceRange(String minValue, String maxValue, int min, int max) {

        // postavimo minimalnu vrednost
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                getDriver().findElement(By.xpath(minValue)), min
        );

        // postavimo maksimalnu vrednost
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                getDriver().findElement(By.xpath(maxValue)), max
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}







