package Pages;

public class LoginCredentialScreen extends BasePage {
    /**
     * Region Variables
     */
    private String emailInputXP = "//input[@type='email']";
    private String passwordInputXP = "//input[@type='password']";

    /**
     * Region Constructor
     */
    public LoginCredentialScreen(){
        super(driver);
    }

    /**
     * Region Methods
     */

    public void loginUser(String email,String password){
        Find(emailInputXP).sendKeys(email);
        Find(passwordInputXP).sendKeys(password);
        Find(passwordInputXP).submit();
    }

    public void waitPageLoads(){
        waitVisibility(emailInputXP);
        waitVisibility(passwordInputXP);
    }


}
