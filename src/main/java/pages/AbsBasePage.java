package pages;

import annotation.Path;
import annotation.PathTemplate;
import common.AbsCommon;
import exeptions.PathNotValidExeption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.annotation.Annotation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public abstract class AbsBasePage<T> extends AbsCommon<T> {

    private String BASE_URL = !System.getProperty("base.url").endsWith("/") ?
            System.getProperty("base.url")
            : System.getProperty("base.url")
                    .substring(0, System.getProperty("base.url").length() - 1);

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(tagName = "h1")
//    private WebElement header;

    private String getPath() {
        Path path = getClass().getAnnotation(Path.class);
        if (path == null) {
            throw new PathNotValidExeption();
        }
        return path.value().startsWith("/") ? path.value(): "/" + path.value();
    }
    public T open() {
        driver.get(BASE_URL + getPath());
            return (T) this;
    }

    public T open(String... data) { //String... и String[] одно и тоже
        PathTemplate pathTemplate = getClass().getAnnotation(PathTemplate.class);

        if(pathTemplate == null) {
            throw new PathNotValidExeption();
        }

        String path = pathTemplate.value();
        for (int i = 0; i < data.length; i++) {
            path = path.replace("$" + (i + 1), data[i]);
        }

        driver.get(BASE_URL + path);

        return (T) this;
    }

    public T pageHeaderShoulbBeSameAs(String title) {
        assertThat($(By.tagName("h1")).getText())
                .as("Header of page shoulb be {} - {}", title)
                .isEqualTo(title);
        return (T) this;

    }

}
