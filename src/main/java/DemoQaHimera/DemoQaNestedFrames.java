package DemoQaHimera;

import BaseMethods.BaseMethods2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DemoQaNestedFrames extends BaseMethods2 {
    public String childIframeText = "//p";
    public String parentIframeText = "//body";

    public DemoQaNestedFrames switchToPerentFrame(){
        getDriver().switchTo().frame("frame1");
        return this;
    }

    public DemoQaNestedFrames switchToChildFrame(){
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@srcdoc]")));
        return this;
    }

    public DemoQaNestedFrames switchBackToPerentFrame(){
        getDriver().switchTo().parentFrame();
        return this;
    }

    public DemoQaNestedFrames verifyChildIframeText(String textZaVerifikaciju){
        Assertions.assertEquals(textZaVerifikaciju, getText(childIframeText));
        return this;
    }

    public DemoQaNestedFrames verifyParentIframeText(String textZaVerifikaciju){
        Assertions.assertEquals(textZaVerifikaciju, getText(parentIframeText));
        return this;
    }

    public DemoQaNestedFrames swithToDefault(){
        getDriver().switchTo().defaultContent();
        return this;
    }

}
