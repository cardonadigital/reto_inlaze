package co.com.inlaze.pages.mapping;

import co.com.inlaze.common.BasePageActions;
import co.com.inlaze.pages.interactions.RegisterInteractions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePageActions {

    private static final Logger LOGGER = Logger.getLogger(RegisterInteractions.class);

    @CacheLookup
    @FindBy(id = "name")
    protected static WebElement txtName;

    @CacheLookup
    @FindBy(id = "email")
    protected static WebElement txtEmail;

    @CacheLookup
    @FindBy(id = "pwd")
    protected static WebElement txtPassword;

    @CacheLookup
    @FindBy(id = "pwdRepeat")
    protected static WebElement txtConfirmPassword;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Registrar')]")
    protected static WebElement btnRegister;


    public RegisterPage(WebDriver driver, int seconds) {
        super(driver,seconds);
        initElement(driver,this);
    }



}
