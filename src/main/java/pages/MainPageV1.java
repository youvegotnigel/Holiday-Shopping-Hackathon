package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageV1 {

    private WebDriver driver;

    private By blackCheckBox = By.id("SPAN__checkmark__107");
    private By filterButton = By.id("filterBtn");
    private By productRegion = By.id("product_grid");
    private By selectShoe = By.id("IMG__imgfluid__215");

    public MainPageV1(WebDriver driver) {
        this.driver = driver;
    }

    public void checkBlackBox() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(blackCheckBox));
        driver.findElement(blackCheckBox).click();
    }

    public void clickFilterButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterButton));
        driver.findElement(filterButton).click();
    }

    public void clickShoe(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterButton));
        driver.findElement(selectShoe).click();
    }

    public WebElement getProductRegion(){
        return driver.findElement(productRegion);
    }

}

