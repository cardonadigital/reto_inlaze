package co.com.inlaze.pages.interactions;

import co.com.inlaze.models.UserModel;
import co.com.inlaze.pages.mapping.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;


public class LoginInteractions extends LoginPage {

    private static Logger LOGGER = Logger.getLogger(LoginInteractions.class);


    public LoginInteractions(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        initElement(driver, this);
    }


    public void fillLoginForm(String email,String password) {
        try {
            fillField(txtUserLogin, email);
            fillField(txtUserPassword, password);
        } catch (Exception e) {
            LOGGER.error("error al diligenciar los campos de contact");
        }
    }
    public void ClickBtnLoguin() {
        try {
            clickOnElement(btnLogin);
        } catch (Exception e) {
            LOGGER.error("error al dar click en el boton de Loguin");
        }
    }

    public void ClickLinkRegister() {
        try {
            clickOnElement(linkRegister);
        } catch (Exception e) {
            LOGGER.error("error al dar click en el boton de register");
        }
    }

    public static String getEmptyEmailMessage(){
        return getTextFromElement(emptyEmailField());
    }
}
