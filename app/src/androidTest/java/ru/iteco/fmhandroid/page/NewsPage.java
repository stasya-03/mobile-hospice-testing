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

}