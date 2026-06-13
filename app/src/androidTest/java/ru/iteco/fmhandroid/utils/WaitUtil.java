package ru.iteco.fmhandroid.utils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

public class WaitUtil {

    private static final long TIMEOUT = 30000;
    private static final long INTERVAL = 500;

    public static void waitDisplayed(Matcher<View> matcher) {

        long startTime = System.currentTimeMillis();
        Throwable lastException = null;

        while (System.currentTimeMillis() - startTime < TIMEOUT) {
            try {
                onView(matcher)
                        .check(matches(isDisplayed()));
                return;
            } catch (NoMatchingViewException | AssertionError e) {
                lastException = e;

                onView(androidx.test.espresso.matcher.ViewMatchers.isRoot())
                        .perform(waitFor(INTERVAL));
            }
        }

        throw new AssertionError("Элемент не появился за 30 секунд", lastException);
    }

    private static ViewAction waitFor(long millis) {
        return actionWithAssertions(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return androidx.test.espresso.matcher.ViewMatchers.isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        });
    }
}