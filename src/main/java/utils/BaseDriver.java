package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver extends LocalDriver{

    WebDriver driver;
    String driverPath = "/home/ciruspunk/optionals/webdrivers/chromedriver";
    String url = "https://www.amazon.com/";

    public BaseDriver(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public WebDriver setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void navigateTo() {
        driver.get(url);
    }
}
