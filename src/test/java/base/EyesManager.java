package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
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

        eyesIsOpen=false;
        if(runner==null) EyesConfig();
        if(eyes==null) {
            eyes = new Eyes();
            eyes.setConfiguration(eyesConfig);
            eyes.setApiKey(System.getProperty("applitools.api.key"));
        }
    }

    public void setBatchName(String batchName){
        eyes.setBatch(new BatchInfo(batchName));
    }

    public void test1(){
        openEyes();
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow();
        closeEyes();
    }

    public void test2(WebElement element){
        openEyes();
        eyes.setForceFullPageScreenshot(true);
        eyes.checkRegion(element);
        closeEyes();
    }

    public void test3(){
        openEyes();
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow();
        closeEyes();
    }

    public void EyesConfig(){
        eyesConfig = new Configuration();
        // Visual Grid configurations
        eyesConfig.addBrowser(1200, 800, BrowserType.CHROME)
                  .addBrowser(1024, 786, BrowserType.FIREFOX)
                  .setTestName("Test 1");
    }

    public void setDriver(WebDriver myDriver){
        driver = myDriver;
        eyesIsOpen=false;
    }

    public void openEyes(){
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
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
