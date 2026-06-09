package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.utils.WaitUtil;

public class MainPage {

    public void checkMainPageIsDisplayed() {
        WaitUtil.waitDisplayed(withId(R.id.main_menu_image_button));
    }

    public void openMainMenu() {
        WaitUtil.waitDisplayed(withId(R.id.main_menu_image_button));
        onView(withId(R.id.main_menu_image_button))
                .perform(click());
    }

    public void checkMainMenuIsDisplayed() {
        onView(withText("Main"))
                .check(matches(isDisplayed()));
        onView(withText("News"))
                .check(matches(isDisplayed()));
        onView(withText("About"))
                .check(matches(isDisplayed()));
    }
    public void clickNewsInMenu() {
        onView(withText("News"))
                .perform(click());
    }

    public void clickAboutInMenu() {
        onView(withText("About"))
                .perform(click());
    }
    public void checkNewsScreenIsDisplayed() {
        WaitUtil.waitDisplayed(withId(R.id.edit_news_material_button));
    }

    public void checkAboutScreenIsDisplayed() {
        WaitUtil.waitDisplayed(withText("Version:"));
    }

    public  void openQuotesSection() {
        onView(withId(R.id.our_mission_image_button))
                .perform(click());
    }

    public  void checkQuotesScreenIsDisplayed() {

        WaitUtil.waitDisplayed(withText("Love is all"));
    }

    public void openAuthorizationMenu() {
        onView(withId(R.id.authorization_image_button))
                .perform(click());
    }

    public void clickLogOut() {
        onView(withText("Log out"))
                .perform(click());
    }

    public void logOut() {
        openAuthorizationMenu();
        clickLogOut();
    }
}