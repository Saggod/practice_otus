package pages;

import annotation.Path;
import org.openqa.selenium.WebDriver;

@Path("/catalog/courses")
public class CategoriesPage extends AbsBasePage<CategoriesPage> {

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
}
