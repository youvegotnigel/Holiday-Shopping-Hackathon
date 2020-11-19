import base.BaseTests;
import org.testng.annotations.Test;

public class MainPageV1Test extends BaseTests {

    //private MainPageV1 mainPageV1 = new MainPageV1(driver);

    @Test
    public void launchApp() {

        eyesManager.setBatchName("Testing Lifecycle");
        driver.get(System.getProperty("site.main_page_v1.url"));
        eyesManager.validateWindow();
        //driver.get("https://demo.applitools.com/tlcHackathonMasterV1.html#0");
    }

    @Test
    public void test1(){
        mainPageV1.checkBlackBox();
        mainPageV1.clickFilterButton();
    }


}
