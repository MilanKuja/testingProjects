package TestingQaDemo;

import DemoQaWebTablesTest.DemoQaWebTablesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebTablesDemoQaTest extends DemoQaWebTablesPage {
    @BeforeEach
    public void startUp(){
        openUrl("https://demoqa.com/webtables");
    }

    @Test
    public void testing(){
        DemoQaWebTablesPage demoQaWebTablesPage = new DemoQaWebTablesPage();
        demoQaWebTablesPage.clickAddButton()
                .verifyFirstNamePlaceHolder("First Name").verifyLasttNamePlaceHolder("Last Name").verifyEmailPlaceHolder("name@example.com")
                .verifyAgePlaceHolder("Age").verifySalaryPlaceHolder("Salary").verifyDepartamantPlaceHolder("Department")
                .inputTextFirstName("Milan").inputTextLastName("Ilic").inputTextEmail("ilmil@gmail.com").inputTextAge("30").inputTextSalery("1000").inputTextDepartment("DEA")
                .clickSubmitButton()
                .deleteRecord3().editRecord2()
                .searchRecord("Ljubica");

    }

    @AfterEach
    public void tareDown(){

       quitDriver();
    }
}
