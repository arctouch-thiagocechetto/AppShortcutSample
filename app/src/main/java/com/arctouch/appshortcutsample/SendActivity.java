package com.arctouch.appshortcutsample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.Arrays;

/**
 * Created by thiagocechetto on 16/01/17.
 */

public class SendActivity extends Activity {

  private CheckBox enableShortcutCheckBox;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_send);

    
    enableShortcutCheckBox = (CheckBox) findViewById(R.id.enable_shortcut);
  }
}
