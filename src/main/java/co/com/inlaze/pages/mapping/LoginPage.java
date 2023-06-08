package co.com.inlaze.pages.mapping;

import co.com.inlaze.common.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;

public class LoginPage  extends BasePageActions {
    /**
     * localizadores de la pagina login
     */
    @CacheLookup
    @FindBy(xpath = "//*[@class='enlace' and contains(text(),'aquí')]")
    protected static WebElement linkRegister;

    @CacheLookup
    @FindBy(id = "ingresoUsuario")
    protected static WebElement txtUserLogin;

    @CacheLookup
    @FindBy(id = "ingresoContrasena")
    protected static WebElement txtUserPassword;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Ingresar')]")
    protected static WebElement btnLogin;

    public static WebElement emptyEmailField(){
        return waitElement(By.xpath("//div[contains(text(), \"Por Favor Digite Su Contraseña\")]"));
    }

    public LoginPage(WebDriver driver, int waitTime) {
        super(driver, waitTime);
        initElement(driver, this);
    }

}
