package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static androidx.test.espresso.Espresso.pressBack;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;

import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;

import ru.iteco.fmhandroid.page.AuthorizationPage;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.NewsPage;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
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
        } catch (Exception ignored) {
        }

        authorizationPage.login("login2", "password2");
        mainPage.checkMainPageIsDisplayed();
    }

    @After
    public void tearDown() {
        try {
            mainPage.logOut();
        } catch (Exception ignored) {
        }
    }

    @Test
    @DisplayName("Создание новости")
    @Description("Проверка создания новости с валидными данными")
    public void shouldCreateNews() {
        String title = "Back massage " + System.currentTimeMillis();
        String description = "Nothing special";
        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        newsPage.createNews(title, description);
        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        newsPage.checkNewsIsDisplayed(title);
    }

    @Test
    @DisplayName("Отмена создания новости")
    @Description("Проверка отмены создания новости")
    public void shouldCancelNewsCreation() {
        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        newsPage.openControlPanel();
        newsPage.clickAddNews();
        newsPage.clickCancel();
        newsPage.confirmCancelNews();
        newsPage.checkControlPanelIsDisplayed();
    }

    @Test
    @DisplayName("Удаление новости")
    @Description("Проверка удаления новости")
    public void shouldDeleteNews() {
        String title = "Delete News " + System.currentTimeMillis();
        String description = "Nothing special";

        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();

        newsPage.createNews(title, description);
        newsPage.checkNewsIsDisplayed(title);

        newsPage.deleteNews();
        pressBack();
    }

    @Test
    @DisplayName("Редактирование новости")
    @Description("Проверка редактирования существующей новости")
    public void shouldEditNews() {
        String title = "News to change " + System.currentTimeMillis();
        String editedTitle = "Smth new " + System.currentTimeMillis();
        String description = "Nothing special";

        mainPage.openMainMenu();
        mainPage.clickNewsInMenu();
        newsPage.createNews(title, description);
        newsPage.editNewsTitle(editedTitle);
        newsPage.checkNewsIsDisplayed(editedTitle);
    }
}