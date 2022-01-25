package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class CaseTest extends BaseTest {

    @Test(description = "Should click and go to repository page")
    public void CaseTest() {
        open("/projects");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.xpath("//a[contains(text(),'Keylex')]")).click();
        $x("//p[@class = 'header']").shouldBe(Condition.visible);

    }

    @Test(description = "Creating a new project")
    public void CreateNewProjectTest() {
        open("/projects");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $("#createButton").click();
        $x("//h1[contains(text(),'New Project')]").shouldBe(Condition.visible);
        $("#inputTitle").sendKeys("Web Application");
        $("#inputCode").sendKeys("WA");
        $("#inputDescription").sendKeys("Description for WA test");
        $x("//input[@id='public-access-type']").click();
        $(".btn.btn-primary").click();
        $x("//p[@class = 'header']").shouldBe(Condition.visible);


    }

}