package com.arctouch.appshortcutsample.gherkin;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.*;

import com.arctouch.appshortcutsample.*;
import com.arctouch.appshortcutsample.R;
import com.arctouch.appshortcutsample.helpers.BasePage;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import android.content.SharedPreferences;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;

/**
 * Created by thiagocechetto on 19/01/17.
 */

@CucumberOptions(features = "features", tags = "@shortSanity")
public class SendScreenSteps {

  @Rule
  public ActivityTestRule activityTestRule = new ActivityTestRule<>(SendActivity.class);

  @cucumber.api.java.Before("@send")
  public void setUp() {
    activityTestRule.launchActivity(null);
  }

  @Given("^I am on the Send Screen$")
  public void i_am_on_the_Send_Screen() throws Throwable {
    onView(withId(R.id.activity_send)).check(matches(isDisplayed()));
  }

  @When("^Enable shortcut is (true|false)$")
  public void enable_shortcut_is_false(boolean checked) throws Throwable {
    storeValueInPreferences(checked);
  }

  @Then("^I should see checkmark (true|false)")
  public void i_should_see_checkmark(boolean enabled) throws Throwable {
    assertThat(enabled, is(restoreCheckedFromPreferences()));
  }

  private boolean restoreCheckedFromPreferences() {
    SharedPreferences settings = activityTestRule.getActivity().getSharedPreferences("shortcut", 0);
    return settings.getBoolean("checked", false);
  }

  private void storeValueInPreferences(boolean enable) {
    SharedPreferences settings = activityTestRule.getActivity().getSharedPreferences("shortcut", 0);
    SharedPreferences.Editor editor = settings.edit();
    editor.putBoolean("checked", enable);
    editor.commit();
  }
}
