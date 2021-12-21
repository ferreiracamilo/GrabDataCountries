package ngTest;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginCredentialScreen;
import Pages.LoginSwitcher;
import org.testng.annotations.*;

public class TestGrabCountries {

    HomePage homePage = new HomePage();
    LoginSwitcher loginSwitcher = new LoginSwitcher();
    LoginCredentialScreen loginCredentialScreen = new LoginCredentialScreen();

    @Test (priority = 1)
    public void goToPartnersHome(){
        homePage.launch();
        homePage.waitPageLoadsNotAuthenticated();
        homePage.loginFirstStep();
        loginSwitcher.clickLogin();
        loginCredentialScreen.waitPageLoads();
        loginCredentialScreen.loginUser("test0514@example.com","test@1234");
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickPublishing();
        homePage.clickMarketing();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterClass
    public void closeBrowserAfter(){
        BasePage.closeBrowser();
    }


}
