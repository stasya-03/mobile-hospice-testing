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

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainPageTest {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        authorizationPage.loginIfNeeded("login2", "password2");
        mainPage.checkMainPageIsDisplayed();
    }


    @Test
    public void shouldOpenMainMenu() {
        mainPage.openMainMenu();
        mainPage.checkMainMenuIsDisplayed();
    }

    @Test
    public void shouldOpenNewsSectionFromMainMenu() {
        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        mainPage.checkNewsScreenIsDisplayed();
    }

    @Test
    public void shouldOpenAboutSectionFromMainMenu() {
        mainPage.openMainMenu();
        mainPage.clickAboutInMenu();
        mainPage.checkAboutScreenIsDisplayed();
    }

    @Test
    public void shouldOpenQuotesSection() {
        mainPage.openQuotesSection();
        mainPage.checkQuotesScreenIsDisplayed();
    }
}