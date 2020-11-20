import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageV1Test extends BaseTests {

    @BeforeClass
    public static void startVisualTestSuite(){
        eyesManager.setBatchName("Testing Lifecycle");
    }

    @Test(testName = "Test 1")
    public void test1() {
        driver.get(System.getProperty("site.main_page_v1.url"));
        eyesManager.test1();
    }

    @Test(testName = "Test 2")
    public void test2(){
        page.checkBlackBox();
        page.clickFilterButton();
        eyesManager.test2(page.getProductRegion());
    }


}
