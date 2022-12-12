package utils;

import org.openqa.selenium.WebDriver;

public abstract class LocalDriver {

    public abstract WebDriver setUp();
    public abstract void quit();

    public abstract void navigateTo();
}
