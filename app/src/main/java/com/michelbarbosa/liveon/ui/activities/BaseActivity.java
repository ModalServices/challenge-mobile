package com.michelbarbosa.liveon.ui.activities;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static com.michelbarbosa.liveon.ui.ConstantesUi.SHARED_PREF;

public class BaseActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    protected SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        startSharedPref();
    }

    private void startSharedPref() {
        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    protected void clearData() {
        if(editor != null){
            editor.clear();
            editor.commit();
        }
    }

}
