package co.com.inlaze.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageActions {
    private static final Logger LOGGER = Logger.getLogger(BasePageActions.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    protected static WebDriver driver;

    public BasePageActions(WebDriver driver, Integer waitingTime) {
        try {
            if (driver == null)
                LOGGER.error(WEBDRIVER_NULL_MESSAGE);
            this.driver = driver;
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(waitingTime))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public static WebElement waitElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void initElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }


    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public void fillField(WebElement element, String value){
        try {
            element.clear();
            element.sendKeys(value);
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public void clearField(WebElement element){
        try {
            element.clear();
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Scroll On Element
    protected void scrollOn(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Is an Element Displayed
    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            return false;
        }
    }

    //Get text from element
    protected static String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            return "";
        }
    }
}
