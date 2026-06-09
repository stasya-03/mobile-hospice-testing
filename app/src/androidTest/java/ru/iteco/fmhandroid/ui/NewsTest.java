package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;

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

    @Before
    public void setUp() {
        try {
            mainPage.logOut();
            authorizationPage.waitAuthorizationScreen();
        } catch (Exception ignored) {
        }

        authorizationPage.login("login2", "password2");
        mainPage.checkMainPageIsDisplayed();
    }

    @After
    public void tearDown() {
        try {
            mainPage.logOut();
            authorizationPage.waitAuthorizationScreen();
        } catch (Exception ignored) {
        }
    }

    @Test
    public void shouldCreateNews() {
        String title = "Back massage " + System.currentTimeMillis();
        String description = "Nothing special";
        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        newsPage.createNews(title, description);
        newsPage.checkNewsIsDisplayed(title);
    }

    @Test
    public void shouldCancelNewsCreation() {
        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        newsPage.openControlPanel();
        newsPage.clickAddNews();
        newsPage.clickCancel();
        newsPage.confirmCancelNews();
        newsPage.checkControlPanelIsDisplayed();
    }


}