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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.SetUp;
import org.apache.log4j.Logger;

import static co.com.inlaze.utils.Alert.WaitAlert;
import static co.com.inlaze.utils.CreateUser.generateUser;
import static co.com.inlaze.utils.Dictionary.INVALID_PASSWORD;
import static co.com.inlaze.utils.Dictionary.PASSWORD_NOT_MATCH;


public class RegistrationStepDefinition extends SetUp {
    private static final Logger LOGGER = Logger.getLogger(RegistrationStepDefinition.class);
    private UserModel userModel = generateUser();


    @Given("the user enter in the sing up form")
    public void theUserEnterInTheSingUpForm() {
        setUpLog4j2();
        setUp();
        LoginInteractions loginInteractions = new LoginInteractions(driver,3);
        loginInteractions.ClickLinkRegister();
    }

    @When("the user sing up in the system")
    public void theUserSingUpInTheSystem() {
       RegisterInteractions registerInteractions = new RegisterInteractions(driver,3);
        registerInteractions.fillregisterForm(userModel,userModel.getPassword());
        registerInteractions.ClickBtnRegister();
    }

    @Then("a success message is displayed")
    public void aSuccessMessageIsDisplayed() {
        WaitAlert(driver);

        Alert alert = driver.switchTo().alert();
        Assertions.assertTrue(alert.getText().contains(userModel.getName().toString()));

    }

    @When("the user sing up in the system with password does not match")
    public void theUserSingUpInTheSystemWithPasswordDoesNotMatch() {
        RegisterInteractions registerInteractions = new RegisterInteractions(driver,3);
        registerInteractions.fillregisterForm(userModel,INVALID_PASSWORD);
        registerInteractions.ClickBtnRegister();

    }

    @Then("the system displays a password mismatch message")
    public void theSystemDisplaysAPasswordMismatchMessage() {
        WaitAlert(driver);
        Alert alert = driver.switchTo().alert();
        Assertions.assertTrue(alert.getText().contains(PASSWORD_NOT_MATCH));

    }
    @After
    public void CloseDriver() {
        close();
    }

}
