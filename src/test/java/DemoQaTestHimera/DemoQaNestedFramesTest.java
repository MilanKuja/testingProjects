package DemoQaTestHimera;

import DemoQaHimera.DemoQaNestedFrames;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoQaNestedFramesTest extends DemoQaNestedFrames {
    @BeforeEach
    public void startUp(){
        openUrl("https://demoqa.com/nestedframes");
    }

    @Test
    public void testing(){
        DemoQaNestedFrames demoQaNestedFrames = new DemoQaNestedFramesTest();
        demoQaNestedFrames.switchBackToPerentFrame().switchToChildFrame().
                verifyChildIframeText("Child Iframe").
                switchBackToPerentFrame().verifyParentIframeText("Parent frame").
        swithToDefault();


    }


    @AfterEach
    public void tareDown(){
        quitDriver();
    }



}
