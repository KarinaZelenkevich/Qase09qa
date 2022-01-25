package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SettingsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {
    @Test(description = "Filling username and password to log into the account")
    public void login() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(Condition.visible);


    }
    @Test(description = "Check that user isn't logged in with invalid username and password")
    public void userShouldNotLogin() {
        open("/login");
        $("#inputEmail").sendKeys(" ");
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldNotBe(Condition.visible);
    }



}

