package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver extends LocalDriver{

    WebDriver driver;
    String windowsPath = "C:\\Optionals\\Webdriver\\chromedriver.exe";
    String linuxPath = "home/ciruspunk/optionals/webdriver/chromedriver";
    String url = "https://www.amazon.com/";

    public BaseDriver(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public WebDriver setUp() {
        System.setProperty("webdriver.chrome.driver", windowsPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
