package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.awt.print.PageFormat;

public abstract class AbsCommon<T> {

    protected WebDriver driver;
    protected Actions actions;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        this.actions= new Actions(driver);

        PageFactory.initElements(driver, this);
    }

}
