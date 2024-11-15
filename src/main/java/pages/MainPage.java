package pages;

import annotation.Path;
import jakarta.inject.Inject;
import org.checkerframework.checker.i18nformatter.qual.I18nFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Path("/")
public class MainPage extends AbsBasePage<MainPage> {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Inject
    private LessonCardPage lessonCardPage;

    @FindBy(xpath = "//section[./h2]//a[contains(@href, '/lessons')]")
    private List<WebElement> lessonItems;

    public String getLessonTitleByIndex(int index) {
        return lessonItems.get(--index)
                .findElement(By.xpath(".//h5"))
                .getText();
    }

    public LessonCardPage clickLessonTitleByTitle (String title) {
        String lessonCardLocatorTemplate = String.format("//a[not(@class)][contains(@href, '/lessons')][.//*[text()='%s']]", title);

        $(By.xpath(lessonCardLocatorTemplate)).click();

        return lessonCardPage;
    }

}

