package com.arctouch.appshortcutsample.helpers;


import cucumber.api.android.CucumberInstrumentationCore;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;


public class Instrumentation extends AndroidJUnitRunner {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        instrumentationCore.create(bundle);
        super.onCreate(bundle);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
//        super.onStart();
        instrumentationCore.start();
    }
}
