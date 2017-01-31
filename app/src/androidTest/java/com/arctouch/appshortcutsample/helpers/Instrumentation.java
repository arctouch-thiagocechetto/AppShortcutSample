package com.arctouch.appshortcutsample.helpers;


import cucumber.api.android.CucumberInstrumentationCore;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;


public class Instrumentation extends AndroidJUnitRunner {

  private final CucumberInstrumentationCore instrumentationCore;
  private boolean finishedCucumberInstrumentation = false;

  public Instrumentation() {
    instrumentationCore = new CucumberInstrumentationCore(this);
  }

  @Override
  public void onCreate(final Bundle bundle) {
    instrumentationCore.create(bundle);
    super.onCreate(bundle);
  }

  @Override
  public void onStart() {
    finishedCucumberInstrumentation = false;
    waitForIdleSync();
    instrumentationCore.start();
  }

  @Override
  public void finish(int resultCode, Bundle results) {
    if (!finishedCucumberInstrumentation) {
      finishedCucumberInstrumentation = true;
      super.onStart();
    } else {
      super.finish(resultCode, results);
    }

  }
}
