package com.arctouch.appshortcutsample;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by thiagocechetto on 19/01/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShareScreenTest {

  @Rule
  public ActivityTestRule activityTestRule = new ActivityTestRule<ShareActivity>(ShareActivity.class);

  @Test
  public void checkScreenElements() {
    onView(withText("Share Activity")).check(matches(isDisplayed()));
  }

}
