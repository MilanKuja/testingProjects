package FaceBookTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FaceBookTest extends FaceBookLogInPage {
    @BeforeEach
    public void startUp() {
        openUrl("https://www.facebook.com/");
        getDriver().manage().window().maximize();

    }


    @Test
    public void testing() {
        FaceBookLogInPage faceBookLogInPage = new FaceBookLogInPage();
        faceBookLogInPage.typeEmail("ilmilan95@gmail.com").typePassword("");

    }


    @AfterEach
    public void tareDown() {
        quitDriver();
    }


}