package PagesQaDemoLogInBookStore;

import BaseMethods.BaseMethods;

public class DemoQaBookStore extends BaseMethods {
    public DemoQaBookStore verifyABookOnThePage(){
        waitForElementLocated("//span[@id = 'see-book-Git Pocket Guide']");
        return this;
    }

}
