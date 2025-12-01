package DemoQaTestHimera;

import DemoQa.DemoQaHimera.DemoQaFrames;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoQaFramesTest extends DemoQaFrames {
    @BeforeEach
    public void startUp(){
        openUrl("https://demoqa.com/frames");
    }

    @Test
    public void testing(){
        DemoQaFrames frames = new DemoQaFrames();
        frames.swithcToIframe().verifyHeadingTest("This is a sample page");



    }


    @AfterEach
    public void tareDown(){
        quitDriver();
    }



}
