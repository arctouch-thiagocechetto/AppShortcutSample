package com.arctouch.appshortcutsample;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.allOf;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by thiagocechetto on 17/01/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainScreenTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule(MainActivity.class);

  @Test
  public void helloTextAppears() {
    onView(withText("Hello World!")).check(matches(isDisplayed()));
  }

  @Test
  public void emailButtonAppears() {
    onView(withId(R.id.fab)).check(matches(isCompletelyDisplayed()));
    onView(withId(R.id.fab)).check(matches(isClickable()));
  }

  @Test
  public void emailButtonClick() {
    onView(withId(R.id.fab)).perform(click());

    onView(allOf (withId(android.support.design.R.id.snackbar_text), withText(R.string.email_snack_text))).check
        (matches
        (isDisplayed()));
  }

  @Test
  public void matchToolbarTitle() {
    onView(allOf(withParent(isAssignableFrom(Toolbar.class)), isAssignableFrom(TextView.class)))
        .check(matches(withText("AppShortcutSample")));
  }

  @Test
  public void drawerButtonAppers() {
    onView(withContentDescription(R.string.navigation_drawer_open))
        .check(matches(isDisplayed()));
  }

  @Test
  public void drawerButtonClick() {
    onView(withContentDescription(R.string.navigation_drawer_open))
        .perform(click());

    onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()));
  }
}
