package DemoQaHimera;

import BaseMethods.BaseMethods2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DemoQaCheckBox extends BaseMethods2 {

    public DemoQaCheckBox extendHomeMenu(){
        click(getDriver().findElement(By.xpath("//label[@for = 'tree-node-home']//preceding-sibling::button")));
        return this;
    }

    public DemoQaCheckBox verifyHomeExpendedMenuIconIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-home']//preceding-sibling::button//*[contains(@class, 'rct-icon rct-icon-expand-open')]"))), "Expended home menu icon is not visible");
        return this;
    }

    public DemoQaCheckBox verifyHomeExpendedIconIsNotVisible(){
        Assertions.assertTrue(isElementNotVisible("//label[@for = 'tree-node-home']//preceding-sibling::button//*[contains(@class, 'rct-icon rct-icon-expand-close')]"));
        return this;
    }

    public DemoQaCheckBox verifyHomeExpendedIconColorExpanded(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-home']//span[@class = 'rct-node-icon']//*[contains(@class, 'rct-icon-parent-open')]"))));
        return this;
    }

    public DemoQaCheckBox verifyThatDesktopExpendButtonIsVisible() {
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for='tree-node-desktop']/preceding-sibling::button[contains(@class, 'rct-collapse rct-collapse-btn')]"))), "Expanding Dektop button is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDesktopCheckBoxIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-desktop']//span[@class = 'rct-checkbox']/*/*"))), "Desktop chackbox is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDesktopFolderIconIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-desktop']/span[@class = 'rct-node-icon']/*/*"))), "Desktop folder icon is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDesktopTextIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-desktop']/span[@class = 'rct-title']"))), "Desktop text is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDocumentsExpendButtonIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for='tree-node-documents']/preceding-sibling::button[contains(@class, 'rct-collapse rct-collapse-btn')]"))), "Expending Documents button is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDocumentsCheckBoxIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-documents']//span[@class = 'rct-checkbox']/*/*"))), "Documents check box is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDocumentsFolderIconIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-documents']/span[@class = 'rct-node-icon']/*/*"))), "Documents folder icon is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDocumentsTextIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-documents']/span[@class = 'rct-title']"))));
        return this;
    }

    public DemoQaCheckBox verifyDownloadsExpendButtonIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button[contains(@class, 'rct-collapse rct-collapse-btn')]"))), "Downloads Expend button is not visible");
        return this;
    }
    public DemoQaCheckBox verifyDownloadsCheckBoxIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-downloads']//span[@class = 'rct-checkbox']/*/*"))), "Downloads checkbox is not visible");
        return this;
    }
    public DemoQaCheckBox verifyDownloadsFolderIconIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-downloads']/span[@class = 'rct-node-icon']/*/*"))), "Downloads folder icon is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDownloadsTextIsVisible(){
        Assertions.assertTrue(isElementVisible(getDriver().findElement(By.xpath("//label[@for = 'tree-node-downloads']/span[@class = 'rct-title']"))), "Downloads text is not visible");
        return this;
    }

    public DemoQaCheckBox verifyDesktopText(){
        String expectedText = "Desktop";
        Assertions.assertEquals(expectedText, getDriver().findElement(By.xpath("//label[@for = 'tree-node-desktop']/span[@class = 'rct-title']")).getText().trim(),"Desktop Tekst se ne poklapa");
        return this;
    }

    public DemoQaCheckBox verifyDocumentsText(){
        String expectedText = "Documents";
        Assertions.assertEquals(expectedText, getDriver().findElement(By.xpath("//label[@for = 'tree-node-documents']/span[@class = 'rct-title']")).getText().trim(), "Dcuments tekst se ne poklapa");
        return this;
    }

    public DemoQaCheckBox verifyDownloadsText(){
        String expectedText = "Downloads";
        Assertions.assertEquals(expectedText, getDriver().findElement(By.xpath("//label[@for = 'tree-node-downloads']/span[@class = 'rct-title']")).getText().trim(),"Downloads tekst se ne poklapa");
        return this;
    }

}
