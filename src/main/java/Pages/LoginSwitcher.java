package Pages;

public class LoginSwitcher extends BasePage{

    /**
     * Region Variables
     */
    private String loginBtnXP = "//button[@title='Log in with Salesforce']";

    /**
     * Region Constructor
     */
    public LoginSwitcher(){
        super(driver);
    }

    /**
     * Region Methods
     */

    public void clickLogin (){
        Find(loginBtnXP).click();
    }

}
