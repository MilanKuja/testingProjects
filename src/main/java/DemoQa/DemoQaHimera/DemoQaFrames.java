package DemoQa.DemoQaHimera;

import BaseMethods.BaseMethods2;
import org.junit.jupiter.api.Assertions;

public class DemoQaFrames extends BaseMethods2 {

    String headerText = "//h1[@id = 'sampleHeading']";
    public DemoQaFrames verifyHeadingTest(String textZaVerifikaciju){

        Assertions.assertEquals(textZaVerifikaciju, getText(headerText));
        return this;

    }

    public DemoQaFrames swithcToIframe(){
        getDriver().switchTo().frame("frame1");
        return this;
    }

}
