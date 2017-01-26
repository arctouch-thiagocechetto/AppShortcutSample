package com.arctouch.appshortcutsample.gherkin;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import cucumber.api.java.en.Then;

/**
 * Created by thiagocechetto on 26/01/17.
 */

public class BaseSteps {

  @Then("^I should see \"(.*?)\"$")
  public void i_should_see(String text) throws Throwable {
    onView(withText(text)).check(matches(isDisplayed()));
  }
}