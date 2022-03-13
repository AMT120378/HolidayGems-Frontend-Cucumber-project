package uk.co.holidaygems.cucumber;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import uk.co.holidaygems.propertyreader.PropertyReader;
import uk.co.holidaygems.utility.Utility;

import java.io.IOException;
/**
 * @author Anand Tripathi
 * @project HolidayGems-Frontend
 * @created 12/03/2022
 */
public class Hooks extends Utility {
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Anand Tripathi");
    }
    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            String screenShotPath = Utility.getScreenshot(driver,scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        closeBrowser();
    }
}


