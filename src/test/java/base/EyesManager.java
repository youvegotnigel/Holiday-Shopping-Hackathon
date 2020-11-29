package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EyesManager {

    private Eyes eyes;
    private String appName;
    private WebDriver driver;

    private static Configuration eyesConfig;
    private static EyesRunner runner=null;
    private static boolean eyesIsOpen=false;

    public EyesManager(WebDriver driver, String appName) {
        this.driver = driver;
        this.appName = appName;

        //eyesIsOpen=false;
        if(runner==null) EyesConfig();
        if(eyes==null) {
            eyes = new Eyes(runner);
            eyes.setConfiguration(eyesConfig);
        }
    }

    public void setBatchName(String batchName){
        eyes.setBatch(new BatchInfo(batchName));
    }

    public void test1(){
        openEyes("Test 1");
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow("main page");
        closeEyes();
    }

    public void test2(WebElement element){
        openEyes("Test 2");
        eyes.setForceFullPageScreenshot(true);
        eyes.checkRegion(element,"filter by color");
        closeEyes();
    }

    public void test3(){
        openEyes("Test 3");
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow("product details");
        closeEyes();
    }

    public void EyesConfig(){
        eyesConfig = (Configuration) new Configuration();
        eyesConfig.setApiKey(System.getProperty("applitools.api.key"));

        // Create a runner with concurrency of 1
        runner = new VisualGridRunner(1);

        // Visual Grid configurations
        eyesConfig.addBrowser(1200, 800, BrowserType.CHROME);
        eyesConfig.addBrowser(1200, 800, BrowserType.FIREFOX);
        eyesConfig.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
        eyesConfig.addBrowser(1200, 800, BrowserType.SAFARI);
        eyesConfig.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
        //eyesConfig.setTestName("Test 1");

    }

    public void setDriver(WebDriver myDriver){
        driver = myDriver;
        eyesIsOpen=false;
    }

    public void openEyes(String testName){
        eyes.open(driver, appName, testName);
        eyesIsOpen=true;
    }

    public void closeEyes(){
        eyesIsOpen=false;
        eyes.close();
    }

    public void abort() {
        eyes.abortIfNotClosed();
    }

    public Eyes getEyes() {
        return eyes;
    }

}
