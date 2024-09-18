package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage<T> {

    protected WebDriver driver;

    public AbsBasePage(WebDriver driver) {
        this.driver = driver;
    }
}
