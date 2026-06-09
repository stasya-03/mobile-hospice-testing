package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.page.AuthorizationPage;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.NewsPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsTest {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void shouldCreateNews() {
        String title = "Back massage";
        String description = "Nothing special";

        authorizationPage.login("login2", "password2");
        mainPage.checkMainPageIsDisplayed();
        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        newsPage.createNews(title, description);
        newsPage.checkNewsIsDisplayed(title);
    }


}