package TestingQaDemo;

import DriverSetup.Driver;
import PagesQaDemoLogInBookStore.DemoQaLogInPage;
import PagesQaDemoLogInBookStore.DemoQaRegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestingLogInPageWithBookStore extends Driver {



    @BeforeEach
    public void startUp(){
        createDriver();
        getDriver().navigate().to("https://demoqa.com/register");
    }


    @Test
    public void testing(){
        DemoQaRegisterPage rp = new DemoQaRegisterPage();
        DemoQaLogInPage lp = rp.clickOnLogin();
        rp.clickOnLogin().typeUserName("kraljina").typePassword("Bureci123@!").loginBtn();

    }





    @AfterEach
    public void tareDown(){
        quitDriver();
    }



}
