package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.utils.WaitUtil;

public class AuthorizationPage {

    public void enterLogin(String login) {
        onView(withHint("Login"))
                .perform(replaceText(login), closeSoftKeyboard());
    }

    public void enterPassword(String password) {
        onView(withHint("Password"))
                .perform(replaceText(password), closeSoftKeyboard());
    }

    public void clickSignInButton() {
        onView(withId(R.id.enter_button))
                .perform(closeSoftKeyboard(), click());
    }

    public void checkMainScreenIsDisplayed() {
        WaitUtil.waitDisplayed(
                withId(R.id.container_list_news_include_on_fragment_main)
        );
    }
    public void waitAuthorizationScreen() {
        WaitUtil.waitDisplayed(withHint("Login"));
    }
    public void login(String login, String password) {
        waitAuthorizationScreen();
        enterLogin(login);
        enterPassword(password);
        clickSignInButton();
    }
    public void checkAuthorizationScreenIsDisplayed() {
        WaitUtil.waitDisplayed(withHint("Login"));
    }
    public void checkLoginFieldIsEmpty() {
        onView(withHint("Login"))
                .check(matches(isDisplayed()));
    }
}