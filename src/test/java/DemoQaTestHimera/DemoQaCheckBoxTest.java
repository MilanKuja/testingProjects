package DemoQaTestHimera;

import DemoQa.DemoQaHimera.DemoQaCheckBox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoQaCheckBoxTest extends DemoQaCheckBox {

    @BeforeEach
    public void startUp(){
        openUrl("https://demoqa.com/checkbox");

    }



    @Test
    public void testing(){
        DemoQaCheckBox demoQaCheckBox = new DemoQaCheckBox();
        demoQaCheckBox.extendHomeMenu().verifyHomeExpendedMenuIconIsVisible().verifyHomeExpendedIconIsNotVisible().verifyHomeExpendedIconColorExpanded()
                .verifyThatDesktopExpendButtonIsVisible().verifyDesktopCheckBoxIsVisible().verifyDesktopFolderIconIsVisible().verifyDesktopTextIsVisible().
                verifyDocumentsExpendButtonIsVisible().verifyDocumentsCheckBoxIsVisible().verifyDocumentsFolderIconIsVisible().verifyDocumentsTextIsVisible().
                verifyDocumentsExpendButtonIsVisible().verifyDownloadsCheckBoxIsVisible().verifyDownloadsFolderIconIsVisible().verifyDownloadsTextIsVisible().
                verifyDesktopText().verifyDocumentsText().verifyDownloadsText();



        //verifikovati da su videljive sve stavke sa svih 12 elemenata

        //verifikovati da je ikonica foldera promenila boju u plavu

        //verifikovati da je prikazano dugme da je meni rasiren -- DOMACI
    }



    @AfterEach
    public void tareDown(){
        quitDriver();
    }
}
