package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagerepositoty.CartPage;
import pagerepositoty.HomePage;
import pagerepositoty.ProductPage;
import pagerepositoty.SearchPage;
import utils.BaseDriver;

public class AmazonTest {

    WebDriver driver;
    BaseDriver baseDriver;
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;


    @BeforeMethod
    public void setUp() {
        baseDriver = new BaseDriver(driver);
        driver = baseDriver.setUp();
        baseDriver.navigateTo();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void firstTest() throws InterruptedException {
        homePage.typeProduct("Samsung Galaxy S22 Ultra");
        searchPage.selectFirstResult();
        Thread.sleep(3000);
        productPage.addProductToCart();
        Thread.sleep(3000);
        Assert.assertEquals(productPage.getProductPrice(), searchPage.getProductPrice());
        cartPage.deleteProduct();
        Thread.sleep(3000);
        Assert.assertEquals(productPage.getProductPrice(), cartPage.getProductPrice());
    }

    @AfterMethod
    public void tearDown() {
        baseDriver.quit();
    }
}
