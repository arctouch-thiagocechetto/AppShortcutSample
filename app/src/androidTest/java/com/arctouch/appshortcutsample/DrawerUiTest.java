package com.arctouch.appshortcutsample;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by thiagocechetto on 17/01/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DrawerUiTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule(MainActivity.class);

  @Test
  public void checkDrawerElements() {
    onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
    checkDrawerHeader();

    onView(withText("Import")).check(matches(isDisplayed()));

    onView(withText("Gallery")).check(matches(isDisplayed()));
    onView(withText("Gallery")).check(isBelow(withText("Import")));

    onView(withText("Slideshow")).check(matches(isDisplayed()));
    onView(withText("Slideshow")).check(isBelow(withText("Gallery")));

    onView(withText("Tools")).check(matches(isDisplayed()));
    onView(withText("Tools")).check(isBelow(withText("Slideshow")));

    onView(withText("Communicate")).check(matches(isDisplayed()));
    onView(withText("Communicate")).check(isBelow(withText("Tools")));

    onView(withText("Share")).check(matches(isDisplayed()));
    onView(withText("Share")).check(isBelow(withText("Communicate")));

    onView(withText("Send")).check(matches(isDisplayed()));
    onView(withText("Send")).check(isBelow(withText("Share")));
  }

  private void checkDrawerHeader() {
    onView(withId(R.id.imageView)).check(matches(isCompletelyDisplayed()));
    onView(withText("Android Studio")).check(matches(isCompletelyDisplayed()));
    onView(withText("Android Studio")).check(isBelow(withId(R.id.imageView)));
    onView(withText("android.studio@android.com")).check(matches(isCompletelyDisplayed()));
    onView(withText("android.studio@android.com")).check(isBelow(withText("Android Studio")));

    // TODO try to compare header background
  }

  @Test
  public void shareAction() {
    onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
    onView(withText("Share")).perform(click());
    // TODO use espresso-intents finishing this test.
  }

}
