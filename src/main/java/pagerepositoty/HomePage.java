package pagerepositoty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageActions;

public class HomePage implements PageActions {

    WebDriver driver;

    // locators
    By searchInput = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");

    // constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public void click(By locator) {
        driver.findElement(locator);
    }

    @Override
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    @Override
    public void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    @Override
    public void submit(By locator) {
        driver.findElement(locator).submit();
    }


    // custom methods
    public void typeProduct(String productName) throws InterruptedException {
        type(productName, searchInput);
        submit(searchInput);
        Thread.sleep(5000);
    }
}
