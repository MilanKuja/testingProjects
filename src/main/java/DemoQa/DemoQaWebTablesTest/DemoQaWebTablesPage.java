package DemoQa.DemoQaWebTablesTest;

import BaseMethods.BaseMethods2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DemoQaWebTablesPage extends BaseMethods2   {

    String addButton = "//button[@id = 'addNewRecordButton']";
    String firstNameInputField = "//input[@id = 'firstName']";
    String lastNameInputField = "//input[@id = 'lastName']";
    String emailInputField = "//input[@id = 'userEmail']";
    String ageInput = "//input[@id = 'age']";
    String salaryInput = "//input[@id = 'salary']";
    String departmentInput = "//input[@id = 'department']";
    String submitButton = "//button[@id = 'submit']";
    String deleteRecord3 = "//span[@id = 'delete-record-3']";
    String editRecord2 = "//span[@id = 'edit-record-2']";
    String searchBox = "//input[@id = 'searchBox']";


    public DemoQaWebTablesPage clickAddButton(){
        click(getDriver().findElement(By.xpath(addButton)));
        return this;
    }

    public DemoQaWebTablesPage verifyFirstNamePlaceHolder(String string){
        Assertions.assertEquals(string, getStringAttribute(firstNameInputField, "placeholder"), "First Name placeholder is not good");
        return this;
    }

    public DemoQaWebTablesPage verifyLasttNamePlaceHolder(String string){
        Assertions.assertEquals(string, getStringAttribute(lastNameInputField, "placeholder"), "Last Name placeholder is not good");
        return this;
    }

    public DemoQaWebTablesPage verifyEmailPlaceHolder(String string){
        Assertions.assertEquals(string, getStringAttribute(emailInputField, "placeholder"), "Email placeholder is not good");
        return this;
    }

    public DemoQaWebTablesPage verifyAgePlaceHolder(String string){
        Assertions.assertEquals(string, getStringAttribute(ageInput, "placeholder"), "Age placeholder is not good");
        return this;
    }

    public DemoQaWebTablesPage verifySalaryPlaceHolder(String string){
        Assertions.assertEquals(string, getStringAttribute(salaryInput, "placeholder"), "Salary placeholder is not good");
        return this;
    }

    public DemoQaWebTablesPage verifyDepartamantPlaceHolder(String string){
        Assertions.assertEquals(string, getStringAttribute(departmentInput, "placeholder"), "Departmant Name placeholder is not good");
        return this;
    }

    public DemoQaWebTablesPage inputTextFirstName(String string){
        sendKeys(getDriver().findElement(By.xpath(firstNameInputField)), string);
        return this;

    }

    public DemoQaWebTablesPage inputTextLastName(String string){
        sendKeys(getDriver().findElement(By.xpath(lastNameInputField)), string);
        return this;
    }

    public DemoQaWebTablesPage inputTextEmail(String string){
        sendKeys(getDriver().findElement(By.xpath(emailInputField)), string);
        return this;
    }


    public DemoQaWebTablesPage inputTextAge(String string){
        sendKeys(getDriver().findElement(By.xpath(ageInput)), string);
        return this;
    }

    public DemoQaWebTablesPage inputTextSalery(String string){
        sendKeys(getDriver().findElement(By.xpath(salaryInput)), string);
        return this;
    }

    public DemoQaWebTablesPage inputTextDepartment(String string){
        sendKeys(getDriver().findElement(By.xpath(departmentInput)), string);
        return this;
    }

    public DemoQaWebTablesPage clickSubmitButton(){
        click(getDriver().findElement(By.xpath(submitButton)));
        return this;
    }

    public DemoQaWebTablesPage deleteRecord3(){
        click(getDriver().findElement(By.xpath(deleteRecord3)));
        return this;
    }

    public DemoQaWebTablesPage editRecord2(){
        click(getDriver().findElement(By.xpath(editRecord2)));
        getDriver().findElement(By.xpath(firstNameInputField)).clear();
        inputTextFirstName("Ljubica");
        getDriver().findElement(By.xpath(lastNameInputField)).clear();
        inputTextLastName("Ilic");
        getDriver().findElement(By.xpath(emailInputField)).clear();
        inputTextEmail("misiclj@gmail.com");
        getDriver().findElement(By.xpath(ageInput)).clear();
        inputTextAge("30");
        getDriver().findElement(By.xpath(salaryInput)).clear();
        inputTextSalery("2500");
        getDriver().findElement(By.xpath(departmentInput)).clear();
        inputTextDepartment("Hr administrator");
        clickSubmitButton();
        return this;
    }

    public DemoQaWebTablesPage searchRecord(String string){
        sendKeys(getDriver().findElement(By.xpath(searchBox)), string);
        return this;
    }






}
