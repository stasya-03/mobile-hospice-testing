package ru.iteco.fmhandroid.utils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.view.View;

import androidx.test.espresso.NoMatchingViewException;

import org.hamcrest.Matcher;

public class WaitUtil {

    public static void waitDisplayed(Matcher<View> matcher) {

        long startTime = System.currentTimeMillis();
        long timeout = 20000;

        while (System.currentTimeMillis() - startTime < timeout) {

            try {
                onView(matcher)
                        .check(matches(isDisplayed()));
                return;

            } catch (NoMatchingViewException | AssertionError e) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        }

        throw new AssertionError("Элемент не появился за 20 секунд");
    }
}