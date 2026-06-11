package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import android.view.View;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.allOf;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.utils.WaitUtil;

public class NewsPage {

    public void openControlPanel() {
        WaitUtil.waitDisplayed(withId(R.id.edit_news_material_button));
        onView(withId(R.id.edit_news_material_button))
                .perform(click());
    }
    public void clickAddNews() {
        WaitUtil.waitDisplayed(withId(R.id.add_news_image_view));
        onView(withId(R.id.add_news_image_view))
                .perform(click());
    }
    public void selectCategory() {
        WaitUtil.waitDisplayed(withId(R.id.news_item_category_text_auto_complete_text_view));
        onView(withId(R.id.news_item_category_text_auto_complete_text_view))
                .perform(replaceText("Массаж"), closeSoftKeyboard());
    }
    public void enterTitle(String title) {
        WaitUtil.waitDisplayed(withId(R.id.news_item_title_text_input_edit_text));
        onView(withId(R.id.news_item_title_text_input_edit_text))
                .perform(replaceText(title), closeSoftKeyboard());
    }
    public void selectDate() {
        onView(withId(R.id.news_item_publish_date_text_input_edit_text))
                .perform(click());
        onView(withId(android.R.id.button1))
                .perform(scrollTo(), click());
    }
    public void selectTime() {
        onView(withId(R.id.news_item_publish_time_text_input_edit_text))
                .perform(click());
        onView(withId(android.R.id.button1))
                .perform(scrollTo(), click());
    }
    public void enterDescription(String description) {
        onView(withId(R.id.news_item_description_text_input_edit_text))
                .perform(replaceText(description), closeSoftKeyboard());
    }

    public void clickSave() {
        onView(withId(R.id.save_button))
                .perform(scrollTo(), click());
    }

    public void checkNewsIsDisplayed(String title) {
        WaitUtil.waitDisplayed(withText(title));
        onView(withText(title))
                .check(matches(isDisplayed()));
    }
    public void createNews(String title, String description) {
        openControlPanel();
        clickAddNews();
        selectCategory();
        enterTitle(title);
        selectDate();
        selectTime();
        enterDescription(description);
        clickSave();
    }

    public void clickCancel() {
        WaitUtil.waitDisplayed(withId(R.id.cancel_button));
        onView(withId(R.id.cancel_button))
                .perform(scrollTo(), click());
    }

    public void checkControlPanelIsDisplayed() {
        onView(withText("Control panel"))
                .check(matches(isDisplayed()));
    }

    public void confirmCancelNews() {
        onView(withText("OK"))
                .perform(click());
    }

    public void clickDeleteNewsButton() {
        WaitUtil.waitDisplayed(withId(R.id.news_list_recycler_view));
        onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(
                        0,
                        clickChildViewWithId(R.id.delete_news_item_image_view)
                ));
    }

    public void confirmDeleteNews() {
        onView(withText("OK"))
                .perform(click());
    }

    public void deleteNews() {
        clickDeleteNewsButton();
        confirmDeleteNews();
    }

    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View childView = view.findViewById(id);
                childView.performClick();
            }
        };
    }

    public void clickEditNewsButton() {
        WaitUtil.waitDisplayed(withId(R.id.news_list_recycler_view));
        onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(
                        0,
                        clickChildViewWithId(R.id.edit_news_item_image_view)
                ));
    }

    public void editNewsTitle(String newTitle) {
        clickEditNewsButton();
        enterTitle(newTitle);
        clickSave();
    }
}