package TestTollsQALogInPage;

import DemoQa.PagesQaDemoLogInBookStore.DemoQaRegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookStoreTestPage extends DemoQaRegisterPage {

    @BeforeEach
    public void startUp(){
        createDriver();
        openUrl("https://demoqa.com/register");
    }



    @Test
    public void testing(){
        DemoQaRegisterPage deomoQaRegisterPage = new DemoQaRegisterPage();
        deomoQaRegisterPage.clickOnLogin().typeUserName("kraljina").typePassword("Bureci123@!").loginBtn().clickOnGoToBookStore().verifyABookOnThePage();

    }





    @AfterEach
    public void tareDown(){
        quitDriver();
    }

}
