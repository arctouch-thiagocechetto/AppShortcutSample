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
    enableShortcutCheckBox.setChecked(restoreCheckedFromPreferences());

    enableShortcutCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        updateShortcutState(checked);
      }
    });
  }

  private boolean restoreCheckedFromPreferences() {
    SharedPreferences settings = getSharedPreferences("shortcut", 0);
    return settings.getBoolean("checked", false);
  }


  private void updateShortcutState(boolean enable) {


    ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);


    if (enable) {

      Intent intent = new Intent(this, SendActivity.class);
      intent.setAction(Intent.ACTION_VIEW);

      ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "send")
          .setShortLabel("Send")
          .setLongLabel("Go to Send Screen")
          .setIcon(Icon.createWithResource(this, R.drawable.ic_menu_send))
          .setIntent(intent)
          .build();

      shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
    } else {
      shortcutManager.removeAllDynamicShortcuts();
    }
    
    storeValueInPreferences(enable);

  }

  private void storeValueInPreferences(boolean enable) {
    SharedPreferences settings = getSharedPreferences("shortcut", 0);
    SharedPreferences.Editor editor = settings.edit();
    editor.putBoolean("checked", enable);
    editor.commit();
  }
}
