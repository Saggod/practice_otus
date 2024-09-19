package main;

import com.google.inject.Inject;
import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class MainPage_Test {
    @Inject
    private MainPage mainPage;

    @Test
    public void mainPageTest() {
         String lessonTitle = mainPage
                .open()
                .getLessonTitleByIndex(1);

    }
}
