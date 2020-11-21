import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DevBranchV1Test extends BaseTests {


    @BeforeClass
    public static void startVisualTestSuite(){
        eyesManager.setBatchName(System.getProperty("applitools.batchName"));
    }

    @Test(testName = "main page")
    public void test1() {
        driver.get(System.getProperty("site.dev_branch.url"));
        eyesManager.test1();
    }

    @Test(testName = "filter by color")
    public void test2(){
        driver.get(System.getProperty("site.dev_branch.url"));
        page.checkBlackBox();
        page.clickFilterButton();
        eyesManager.test2(page.getProductRegion());
    }

    @Test(testName = "product details")
    public void test3(){
        driver.get(System.getProperty("site.dev_branch.url"));
        page.clickShoe();
        Assert.assertEquals("https://demo.applitools.com/tlcHackathonProductDetailsDev.html?id=1", driver.getCurrentUrl());
        eyesManager.test3();
    }


}
