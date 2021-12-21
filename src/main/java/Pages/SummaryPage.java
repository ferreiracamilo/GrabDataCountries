package Pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class SummaryPage extends BasePage{
    /**
     * Region Variables
     */
    String editAddressBtnXP = "//label[contains (text(), 'Order Address') ] //following-sibling::button";
    String billCountryBtnXP = "//input[@name='billing-country']";
    String billCountryOptionsXP = "//lightning-base-combobox-item //span //span";

    /**
     * Region Constructor
     */
    public SummaryPage(){
        super(driver);
    }

    /**
     * Region Methods
     */

    public void editBillingAddress (){
        moveNclick(editAddressBtnXP);
    }

    public void clickCountryDrop (){
        Find(billCountryBtnXP).click();
    }

    public List<WebElement> getAllCountries () {
        return getAllElements(billCountryOptionsXP);
    }


}
