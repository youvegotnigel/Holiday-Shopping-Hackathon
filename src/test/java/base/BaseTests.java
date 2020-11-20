package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPageV1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTests {

    protected static WebDriver driver;
    protected static EyesManager eyesManager;
    protected MainPageV1 page;
    protected static String testName;


    @BeforeClass
    public void setUp() {

        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources\\test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        //System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        driver = new ChromeDriver();
        goHome();

        eyesManager = new EyesManager(driver, System.getProperty("applitools.appName"));
    }

    public void goHome(){

        driver.manage().window().maximize();
        page = new MainPageV1(driver);

    }

//    private static ChromeOptions getChromeOptions(){
//        ChromeOptions options = new ChromeOptions();
//        //options.setHeadless(true);
//        return options;
//    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
        eyesManager.abort();
    }

    public static String getTestName() {
        return testName;
    }
}
