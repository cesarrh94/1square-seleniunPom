package pagerepositoty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageActions;

public class ProductPage implements PageActions {

    WebDriver driver;

    String productPrice = null;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By symbol = By.xpath("//span[@class='a-price-symbol']");
    By priceWhole = By.xpath("//span[@class='a-price-whole']");
    By priceFraction = By.xpath("//span[@class='a-price-fraction']");
    By addToCartButton = By.id("add-to-cart-button");
    By goToCartLink = By.id("nav-cart");

    public String getProductPrice() {
        return productPrice;
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

    }
    @Override
    public void submit(By locator) {

    }


    // custom methods
    public void addProductToCart() throws InterruptedException {
        productPrice = getText(symbol) + getText(priceWhole) + "." + getText(priceFraction);
        System.out.println("product price from pp: " + getProductPrice());
        Thread.sleep(3000);
        click(addToCartButton);
        click(goToCartLink);
        Thread.sleep(3000);
    }

}
