package main;

import com.google.inject.Inject;
import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LessonCardPage;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class MainPage_Test {

    @Inject
    private MainPage mainPage;

    @Inject
    private LessonCardPage lessonCardPage;

    @Test
    public void mainPageTest() {
         String lessonTitle = mainPage
                .open()
                .getLessonTitleByIndex(1);
         mainPage.clickLessonTitleByTitle(lessonTitle)
                 .pageHeaderShoulbBeSameAs(lessonTitle);

    }

    @Test
    public void categoriesPageTest() {



    }
}
