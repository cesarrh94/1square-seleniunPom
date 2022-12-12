package pagerepositoty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageActions;

public class SearchPage implements PageActions {

    WebDriver driver;
    String productPrice = null;

    // locators
    By firstResultContainer = By.xpath("//div[@data-cel-widget='search_result_1']");
    By firstResultLink = By.xpath("//img[@src='https://m.media-amazon.com/images/I/61nhOdlKpDL._AC_UY218_.jpg']");
    By symbol = By.xpath("//span[@class='a-price-symbol']");
    By priceWhole = By.xpath("//span[@class='a-price-whole']");
    By priceFraction = By.xpath("//span[@class='a-price-fraction']");

    public String getProductPrice() {
        return productPrice;
    }

    public SearchPage(WebDriver driver) {
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

    //custom methods
    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            System.out.println("Element not found or displayed!");
        }
        return false;
    }

    public void selectFirstResult() throws InterruptedException {
        isDisplayed(firstResultContainer);
        productPrice = getText(symbol) + getText(priceWhole) + "." + getText(priceFraction);
        System.out.println("product price from sp: " + productPrice);
        click(firstResultLink);
        Thread.sleep(6000);
    }
}
