package ru.iteco.fmhandroid.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import ru.iteco.fmhandroid.page.AuthorizationPage;
import ru.iteco.fmhandroid.page.MainPage;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();


    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Test
    public void shouldLoginWithValidLoginAndPassword() {
        authorizationPage.login("login2", "password2");
        authorizationPage.checkMainScreenIsDisplayed();
    }

    @Test
    public void shouldNotLoginWithEmptyLogin() {
        authorizationPage.waitAuthorizationScreen();
        authorizationPage.enterPassword("password2");
        authorizationPage.clickSignInButton();
        authorizationPage.checkAuthorizationScreenIsDisplayed();
    }

    @Test
    public void shouldNotLoginWithEmptyPassword() {
        authorizationPage.waitAuthorizationScreen();
        authorizationPage.enterLogin("login2");
        authorizationPage.clickSignInButton();
        authorizationPage.waitAuthorizationScreen();
    }

    @Test
    public void shouldNotLoginWithInvalidLoginAndPassword() {
        authorizationPage.login("wrongLogin", "wrongPassword");
        authorizationPage.waitAuthorizationScreen();
    }

    @Test
    public void shouldLogout() {
        authorizationPage.login("login2", "password2");
        mainPage.checkMainPageIsDisplayed();
        mainPage.logOut();
        authorizationPage.waitAuthorizationScreen();
    }
}