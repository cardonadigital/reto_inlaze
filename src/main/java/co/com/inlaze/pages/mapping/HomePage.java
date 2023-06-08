package co.com.inlaze.pages.mapping;

import co.com.inlaze.common.BasePageActions;
import co.com.inlaze.models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;




public class HomePage extends BasePageActions {

    public HomePage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
    }


    public static WebElement ValidationName(){
    return waitElement(By.xpath("//span[contains(text(),'Hola')]"));
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Salir')]")
    protected static WebElement btnExit;

}
