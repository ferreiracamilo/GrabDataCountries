package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasePage {

    /**
     * Region Variables
     */
    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resource-file/chromedriver_v2.exe");

        Map<String, Object> prefs = new HashMap<String, Object>();
        //prefs.put("profile.managed_default_content_settings.images", 2);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,80000);
    }

    /**
     * Region Constructor
     */
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        // wait = new WebDriverWait(driver,80000);
    }

    /**
     * Region Methods
     */

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    /**
     * Get a webelement along applying <mark>wait</mark> to ensure element is available
     * @param locator xpath locator
     * @return WebElement will be <b>null</b> if <b>locator doesn't match to an actual element</b>
     */
    protected WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitVisibility (String locator){
        ExpectedConditions.visibilityOfElementLocated(By.xpath(locator));
    }

    protected void waitElementsQty (String locator){
        ExpectedConditions.visibilityOfElementLocated(By.xpath(locator));

    }

    protected void waitURL (String url){
        ExpectedConditions.urlContains(url);
    }

    public void moveNclick(String locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ele = Find(locator);
        js.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
    }

    public void write (String locator,String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public List<WebElement> getAllElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public void Hover (String locator){
        Actions actions = new Actions(driver);
        //actions.moveToElement(Find(locator));
        actions.moveToElement(Find(locator)).perform();
        // actions.moveToElement(Find(locator)).build().perform();
    }

    public void SubHover (String locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(Find(locator));
        actions.click().build().perform();
    }

}
