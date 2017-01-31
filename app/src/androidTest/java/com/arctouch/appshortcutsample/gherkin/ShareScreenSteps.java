package com.arctouch.appshortcutsample.gherkin;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import com.arctouch.appshortcutsample.*;
import com.arctouch.appshortcutsample.helpers.BasePage;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import android.support.test.rule.ActivityTestRule;


/**
 * Created by thiagocechetto on 19/01/17.
 */

@CucumberOptions(features = "features", tags = "@shortSanity")
public class ShareScreenSteps {

  public ActivityTestRule activityTestRule = new ActivityTestRule<ShareActivity>(ShareActivity.class);

  @Before("@share")
  public void setUp() {
    activityTestRule.launchActivity(null);
  }

  @Given("^I am on the Share Screen$")
  public void i_am_on_the_Share_Screen() throws Throwable {
    onView(withId(com.arctouch.appshortcutsample.R.id.activity_share)).check(matches
        (isDisplayed()));
  }
}
