package FaceBookTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FaceBookTest extends FaceBookLogInPage {
    @BeforeEach
    public void startUp() {
        openUrl("https://www.facebook.com/");
    }


    @Test
    public void testin() {
        FaceBookLogInPage faceBookLogInPage = new FaceBookLogInPage();

    }


    @AfterEach
    public void tareDown() {
        quitDriver();
    }


}