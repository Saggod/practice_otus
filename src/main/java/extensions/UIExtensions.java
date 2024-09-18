package extensions;

import com.google.inject.Guice;
import modules.GuicePageModules;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class UIExtensions implements BeforeEachCallback, AfterEachCallback {


    private WebDriver driver;

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Guice.createInjector(new GuicePageModules()).injectMembers(context.getTestInstance().get());
    }
}
