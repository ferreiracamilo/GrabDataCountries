package Pages;

public class AMPLandingPage extends BasePage{
    /**
     * Region Variables
     */
    String promotionsQtyXP = "//div [contains (@class,'pc-amp-promotions-list-item') and contains (@class,'slds-grid_vertical') ]";
    String hoverModalPromoXP = "(//p[contains (text(),'Content Newsletter Feature') ] //ancestor::div[2] //div[2]) [1]";
    String applyPromoModalBtnXP = "(//p[contains (text(),'Content Newsletter Feature') ] //ancestor::div[2] //div[2]) [1] //button[contains(text(),'Apply for Promo') ]";
    String chkListingXP = "(//div[@class='slds-modal__container'] //label //span) [1]";
    String continueBtnXP = "//div[@class='slds-modal__container'] //button[contains (text(), 'Continue') ]";
    String dropdownListingBtnXP = "(//div[@class='slds-modal__container'] //input[@role='combobox'] ) [1]";
    String dropdownListingOptionXP = "(//div[@class='slds-modal__container'] //lightning-base-combobox-item) [1]";
    String addPromoCombinationBtnXP = "//div[@class='slds-modal__container'] //button[contains(text(),'Add')]";
    String carticonBtnXP = "//button[@title='Go to review']";

    /**
     * Region Constructor
     */
    public AMPLandingPage(){
        super(driver);
    }

    /**
     * Region Methods
     */
    public void addToCart(){
        Hover(hoverModalPromoXP);
        SubHover(applyPromoModalBtnXP);
        Find(chkListingXP).click();
        Find(continueBtnXP).click();
        Find(chkListingXP).click();
        Find(dropdownListingBtnXP).click();
        Find(dropdownListingOptionXP).click();
        Find(addPromoCombinationBtnXP).click();
        Find(carticonBtnXP).click();
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
