import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageV1Test extends BaseTests {

    @BeforeClass
    public static void startVisualTestSuite(){
        eyesManager.setBatchName(System.getProperty("applitools.batchName"));
    }

    @Test(testName = "main page")
    public void test1() {
        driver.get(System.getProperty("site.main_page_v1.url"));
        eyesManager.test1();
    }

    @Test(testName = "filter by color")
    public void test2(){
        driver.get(System.getProperty("site.main_page_v1.url"));
        page.checkBlackBox();
        page.clickFilterButton();
        eyesManager.test2(page.getProductRegion());
    }

    @Test(testName = "product details")
    public void test3(){
        driver.get(System.getProperty("site.main_page_v1.url"));
        page.clickShoe();
        Assert.assertEquals("https://demo.applitools.com/tlcHackathonProductDetailsMasterV1.html?id=1", driver.getCurrentUrl());
        eyesManager.test3();
    }


}
