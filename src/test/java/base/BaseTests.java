package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPageV1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTests {

    protected static WebDriver driver;
    protected static EyesManager eyesManager;
    protected MainPageV1 mainPageV1;


    @BeforeClass
    public void setUp() {

        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources\\test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        driver = new ChromeDriver();
        goHome();

        eyesManager = new EyesManager(driver, "AppliFashion");
    }

    public void goHome(){
        //driver.get("https://demo.applitools.com/tlcHackathonMasterV1.html#0");
        driver.manage().window().maximize();
        mainPageV1 = new MainPageV1(driver);

    }

    private static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        return options;
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
        eyesManager.abort();
    }
}
