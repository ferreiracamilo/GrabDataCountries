package Pages;

public class ReviewPage extends BasePage{
    /**
     * Region Variables
     */
    String continueBtnXP = "//button[@title='Continue']";

    /**
     * Region Constructor
     */
    public ReviewPage(){
        super(driver);
    }

    /**
     * Region Methods
     */
    public void clickContinue (){
        Find(continueBtnXP).click();
    }

}
