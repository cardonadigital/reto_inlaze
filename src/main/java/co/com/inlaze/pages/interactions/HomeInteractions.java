package co.com.inlaze.pages.interactions;

import co.com.inlaze.models.UserModel;
import co.com.inlaze.pages.mapping.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeInteractions extends HomePage {

    private String HeaderText;


    public HomeInteractions(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
    }

    public static String getHeaderText(){
        return getTextFromElement(ValidationName());
    }

}
