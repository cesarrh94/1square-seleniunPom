package pagerepositoty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageActions;

public class CartPage implements PageActions {

    WebDriver driver;
    String productPrice = null;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By subtotal = By.xpath("//*[contains(@class, 'a-size-medium a-color-base sc-price sc-white-space-nowrap')]");
    By deleteLink = By.xpath("//input[@value='Delete']");

    public String getProductPrice() {
        return productPrice;
    }

    @Override
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    @Override
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    @Override
    public void type(String text, By locator) {

    }

    @Override
    public void submit(By locator) {

    }

    // custom methods
    public void deleteProduct() throws InterruptedException {
        productPrice = getText(subtotal);
        System.out.println("price product from cp: " + productPrice);
        click(deleteLink);
    }
}
