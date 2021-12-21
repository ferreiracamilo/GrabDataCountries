package Pages;

public class HomePage extends BasePage{
    /**
     * Region Variables
     */
    private String loginBtnXP = "//div[@class='slds-p-top_medium pcng-login-buttons desktop-only'] //a[2]";
    private String publishingBtnXP = "//a[@title='Publishing']";
    private String marketingBtnXP = "//span[contains(text(),'Marketing')] //ancestor::a";

    /**
     * Region Constructor
     */
    public HomePage(){
        super(driver);
    }

    /**
     * Region Methods
     */

    public void loginFirstStep (){
        Find(loginBtnXP).click();
    }

    public void clickPublishing (){
        Find(publishingBtnXP).click();
    }

    public void clickMarketing (){
        Find(marketingBtnXP).click();
    }

    public void launch (){
        HomePage.navigateTo("http://partners.salesforce.com/");
    }

    public void waitPageLoadsNotAuthenticated (){
        waitURL("pdx/s/?language=en_US");
        waitVisibility("//div[@class='pcng-hero_unauthed__content-grid slds-grid slds-wrap']");
        waitVisibility(loginBtnXP);
    }

    public void waitPageLoadsAuthenticated (){
        waitURL("pdx/s/");
        waitVisibility("//a[@title='Home']");
        waitVisibility("//a[@title='Collaboration']");
        waitVisibility("//a[@title='Learn']");
        waitVisibility("//a[@title='News & Events']");
        waitVisibility("//a[@title='Business']");
        waitVisibility("//a[@title='Publishing']");
        waitVisibility("//span[contains (text(),'Welcome back,')]");
    }


}
