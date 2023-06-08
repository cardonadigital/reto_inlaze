package setup;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.inlaze.utils.Dictionary.*;
import static co.com.inlaze.utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class SetUp {
    protected static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(SetUp.class);



    public static void setUp(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void close(){
        driver.quit();
    }


    protected static void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


    public void errorManagement(Exception exception){
        Assertions.fail(exception.getMessage(), exception);
        LOGGER.error(exception.getMessage(), exception);
        close();
    }
}
