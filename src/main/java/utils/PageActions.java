package utils;

import org.openqa.selenium.By;

public interface PageActions {

    public void click(By locator);
    public String getText(By locator);
    public void type(String text, By locator);
    public void submit(By locator);

}
