package serialChecker;

import DriverSetup.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class deviceChecker {



    public static void main(String[] args) throws Exception {


        List<Account> accounts = Arrays.asList(
                new Account("lioneightops", "hR3%Syd9","LionEight"),
//                 Možete zakomentarisati ostale naloge
                new Account("darexsiteop","darexnewp!@#","Darex"),
                new Account("optimaeldops","aW1@YeNA","Optima")
        );

        List<String> devices = DeviceListReader.readDevices("lionEightDevices.txt");
        List<String> notFoundDevices = new ArrayList<>();

        Driver.createDriver();
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for(Account acc : accounts) {
            try {
                driver.get("https://www.skyonics.net/#/");

                WebElement userNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-username']")));
                userNameInput.clear();
                userNameInput.sendKeys(acc.getUsername());

                WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputPassword']")));
                passwordInput.clear();
                passwordInput.sendKeys(acc.getPassword());

                WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
                submitBtn.click();


                WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search by Serial Number, VIN, ICCID ']")));

                for (int i = 0; i < devices.size(); i += 50) {
                    int end = Math.min(i + 50, devices.size());
                    List<String> batch = devices.subList(i, end);

                    String batchInput = String.join(" ", batch);
                    searchBox.clear();
                    searchBox.sendKeys(batchInput);

                    Thread.sleep(3000); // čekanje da se učita pretraživanje

                    WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Search']")));
                    searchBtn.click();

                    Thread.sleep(2000); // čekanje da se rezultati učitaju

                    List<WebElement> resultElements = driver.findElements(By.xpath("//p[@class='ng-binding']"));

                    for (String device : batch) {
                        boolean found = false;
                        for (WebElement res : resultElements) {
                            if (res.getText().equals(device)) {
                                found = true;
                                System.out.println("✅ Uređaj pronađen: " + device);
                                break;
                            }
                        }
                        if (!found) {
                            notFoundDevices.add(device);
                            System.out.println("❌ Uređaj nije pronađen: " + device);
                        }
                    }
                }

//                WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath()));

            } catch (Exception e) {
                System.out.println("❌ Greška na nalogu " + acc.getName());
                e.printStackTrace();
            }
        }

        driver.quit();

        // Snimi uređaje koji nisu pronađeni
        try (FileWriter writer = new FileWriter("noDevices.csv")) {
            for (String d : notFoundDevices) {
                writer.write(d + "\n");
            }
            System.out.println("Uređaji koji nisu pronađeni su sačuvani u noDevices.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}