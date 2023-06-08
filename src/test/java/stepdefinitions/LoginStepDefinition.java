package stepdefinitions;

import co.com.inlaze.models.UserModel;
import co.com.inlaze.pages.interactions.LoginInteractions;
import co.com.inlaze.pages.interactions.RegisterInteractions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import setup.SetUp;

import static co.com.inlaze.pages.interactions.HomeInteractions.getHeaderText;
import static co.com.inlaze.pages.interactions.LoginInteractions.getEmptyEmailMessage;
import static co.com.inlaze.utils.Alert.WaitAlert;
import static co.com.inlaze.utils.CreateUser.generateUser;
import static co.com.inlaze.utils.Dictionary.EMPTY;
import static co.com.inlaze.utils.Dictionary.INVALID_PASSWORD;


public class LoginStepDefinition extends SetUp {
    private UserModel userModel = generateUser();
    private static LoginInteractions loginInteractions;
    private static RegisterInteractions registerInteractions;



    @Given("the user enter in the login page as a registered user")
    public void theUserEnterInTheLoginPageAsARegisteredUser() {
        setUpLog4j2();
        setUp();
        loginInteractions = new LoginInteractions(driver,3);
        loginInteractions.ClickLinkRegister();

        registerInteractions = new RegisterInteractions(driver,3);
        registerInteractions.fillregisterForm(userModel,userModel.getPassword());
        registerInteractions.ClickBtnRegister();
        WaitAlert(driver);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @When("the user login in the system successfully")
    public void theUserLoginSectitonInTheSystemSuccesfully() {
        loginInteractions.fillLoginForm(userModel.getEmail(),userModel.getPassword());
        loginInteractions.ClickBtnLoguin();
    }

    @Then("the user name will be displayed")
    public void theUserNameWillBeDisplayed() {
        System.out.println(userModel.getName());
        System.out.println(getHeaderText());
        Assertions.assertTrue(getHeaderText().contains(userModel.getName().toString()));
    }

    @When("login section with empty name and password fields")
    public void loginSectionWithEmptyNameAndPasswordFields() {
        LoginInteractions loginInteractions = new LoginInteractions(driver,3);
        loginInteractions.ClickBtnLoguin();
    }

    @Then("the user receives a message indicating that the fields are required")
    public void theUserReceivesAMessageIndicatingThatTheFieldsAreRequired() {
        Assertions.assertTrue(getEmptyEmailMessage().toString().contains("Por Favor Digite Su Contraseña"));
    }


    @After
    public void CloseDriver() {
        close();
    }
}
