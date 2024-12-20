package pages;

import annotation.PathTemplate;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@PathTemplate("/lessons/$1")
public class LessonCardPage extends AbsBasePage<LessonCardPage> {
    public LessonCardPage(WebDriver driver) {
        super(driver);
    }

    @Inject
    private CategoriesPage categoriesPage;



}
