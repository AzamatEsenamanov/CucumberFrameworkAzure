package stepdefinition;

import Pages.HomePage;
import config.BrowserSettings;
import framework.CommonElementMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.sql.SQLOutput;

public class ProjectStepDefinition {
    WebDriver driver;
    CommonElementMethods commonMethods;
    BrowserSettings browserSettings = new BrowserSettings();

    @Before(order = 1)
    public void setup(Scenario scenario) throws Exception {
        driver = browserSettings.BrowserSettings();
    }
    @When("^(?:|we |I)enter \"([^\"]*)\" in the field$")
    public void we_enter(String text) throws IOException {
        HomePage home = new HomePage(driver);
        WebElement getHome = home.getSearchBox();
        System.out.println(getHome);
        this.commonMethods.enterValueWhenVisible(getHome, text, 5);
    }
    @After
    public void teardown(){
        browserSettings.tearDownAfterScenario();
    }
}
