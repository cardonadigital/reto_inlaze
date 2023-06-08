package co.com.inlaze.pages.interactions;


import co.com.inlaze.models.UserModel;
import co.com.inlaze.pages.mapping.RegisterPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class RegisterInteractions extends RegisterPage {

    private static Logger LOGGER = Logger.getLogger(RegisterInteractions.class);

    public RegisterInteractions(WebDriver driver, int segundos) {
        super(driver,segundos);
        initElement(driver,this);
    }

    public void fillregisterForm(UserModel userModel,String ConfirmPassword) {
        try {
            fillField(txtName, userModel.getName());
            fillField(txtEmail, userModel.getEmail());
            fillField(txtPassword, userModel.getPassword());
            fillField(txtConfirmPassword, ConfirmPassword);
        } catch (Exception e) {
            LOGGER.error("error al diligenciar los campos de Register");
        }
    }

    public void ClickBtnRegister() {
        try {
            clickOnElement(btnRegister);
        } catch (Exception e) {
            LOGGER.error("error al dar click en el boton de Register");
        }
    }

}
