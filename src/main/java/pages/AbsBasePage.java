package pages;

import annotation.Path;
import common.AbsCommon;
import exeptions.PathNotValidExeption;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage<T> extends AbsCommon<T> {

    private String BASE_URL = !System.getProperty("base.url").endsWith("/") ?
            System.getProperty("base.url")
            : System.getProperty("base.url")
                    .substring(0, System.getProperty("base.url").length() - 1);

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

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

}
