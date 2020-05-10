package stepdefinition;


import config.Base;
import config.GetBase;
import framework.CommonElementMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import locatorreaders.ILocatorReader;
import locatorreaders.XmlLocatorReader;
import locatorreaders.YamlLocatorReader;
import config.PageObjectMap;
import utilities.FileFunctions;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ProjectStepDefinition {
    private static final Logger LOGGER = Logger.getLogger(ProjectStepDefinition.class.getName());
    private static final Integer MULTIPLIER = 1000;
    CommonElementMethods commonMethods;
    GetBase getBase = new GetBase();
    Base base = new Base();

    @Before(order = 1)
    public void setup(Scenario scenario) {
        this.getBase.setDriver(base.driverSettings());
        this.commonMethods = new CommonElementMethods(this.getBase.getDriver());
        base.navigateToURL();
    }
    @Given("we are on {string}")
    public void weAreOn(String name) throws Exception {

        String fileSeperator = System.getProperty("file.separator");
        String location = "src/test/resources/page_objects".replace("/", fileSeperator);
        List<String> pages = FileFunctions.listf(location); //getting list of files(full path) in all subdir
        String msg = "Neither " + name + ".xml nor .yml were not found --plz verify that the requizite page file " +
                "exsists in src/tests/resources/page_objects/ and is readable.";
        boolean fileFound = false;
        for (String page : pages) {
            String fileType = page.substring(page.lastIndexOf('.') + 1);
            if (page.substring(page.lastIndexOf(fileSeperator) + 1).equals(name + "." + fileType)) {
                ILocatorReader reader;
                if (fileType.equals("yml")) {
                    reader = new YamlLocatorReader();
                }else if(fileType.equals("xml")){
                    reader = new XmlLocatorReader();
                }else{
                    LOGGER.severe(msg);
                    throw new Exception("Neither " + name + ".xml nor " + name + ".yml were not found -- file type is not supported");
                }
                this.getBase.setPage(new PageObjectMap(
                        (reader).read(page),
                        this.getBase.getDriver(), this.getBase.getTimeout()));
                fileFound = true;
                break;
            }
        }
        if (!fileFound) {
            LOGGER.severe(msg);
            throw new IOException(msg);
        }
    }
    @When("we enter {string} in the {string} field")
    public void we_enter(String text, String box) throws IOException {
        commonMethods.enterValueWhenVisible(this.getBase.getPage().get(box), text, 5);
    }
    @When("we click on {string}")
    public void we_click(String box) throws IOException {
        commonMethods.clickWhenVisible(this.getBase.getPage().get(box), 5);
    }
    @When("we wait for {int} seconds")
    public void we_wait(int seconds) throws IOException, InterruptedException {
        Thread.sleep(seconds * MULTIPLIER);
    }
    @After
    public void teardown(){
        base.tearDownAfterScenario();
    }
}
