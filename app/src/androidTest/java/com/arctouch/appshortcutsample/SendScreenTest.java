package com.arctouch.appshortcutsample;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.content.SharedPreferences;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by thiagocechetto on 19/01/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SendScreenTest {

  @Rule
  public ActivityTestRule<SendActivity> activityTestRule = new ActivityTestRule<SendActivity>
      (SendActivity.class);

  @Test
  public void checkScreenElements() {
    onView(withText("Enable Dynamic Shortcut")).check(matches(isDisplayed()));
  }

  @Test
  public void shortCutEnable(){
    storeValueInPreferences(true);

    activityTestRule.getActivity().finish();
    activityTestRule.launchActivity(null);

    onView(withText("Enable Dynamic Shortcut")).check(matches(isChecked()));
  }

  @Test
  public void shortCutDisable(){
    storeValueInPreferences(false);

    activityTestRule.getActivity().finish();
    activityTestRule.launchActivity(null);

    onView(withText("Enable Dynamic Shortcut")).check(matches(isNotChecked()));
  }

  private void storeValueInPreferences(boolean enable) {
    SharedPreferences settings = activityTestRule.getActivity().getSharedPreferences("shortcut", 0);
    SharedPreferences.Editor editor = settings.edit();
    editor.putBoolean("checked", enable);
    editor.commit();
  }

}
