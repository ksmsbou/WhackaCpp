package com.android.tesis.luigi.whackac;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class teoriaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set window fullscreen and remove title bar, and force landscape orientation
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria);

    }

    public void onBackPressed() {
        Intent startMain = new Intent(this,MainActivity.class);
        startActivity(startMain);
    }
}
