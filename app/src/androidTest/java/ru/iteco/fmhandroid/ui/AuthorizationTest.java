package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.utils.DeviceHelper;
import ru.iteco.fmhandroid.page.AuthorizationPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTest {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {

        DeviceHelper.clearAppData();
    }


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
}