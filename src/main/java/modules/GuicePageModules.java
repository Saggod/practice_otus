package modules;

import com.google.inject.*;
import components.static_component.HeaderMenuCompoonent;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.LessonCardPage;
import pages.MainPage;

public class GuicePageModules extends AbstractModule {

    private final WebDriver driver = new WebDriverFactory().create();

    @Provides
    private WebDriver getDriver() {
        return driver;
    }

    @Singleton
    @Provides
    public MainPage getMainPage() {
        return new MainPage(driver);
    }

    @Singleton
    @Provides
    public LessonCardPage getLessonCardPage() {
        return new LessonCardPage(driver);
    }

    @Singleton
    @Provides
    public HeaderMenuCompoonent getHeaderMenuCompoonent() {
        return new HeaderMenuCompoonent(driver);
    }

}
