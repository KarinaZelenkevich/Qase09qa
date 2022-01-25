package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseTest {
    String email, password;

    @BeforeClass
    public void setUp() {
        Configuration.headless = true;
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }


}
