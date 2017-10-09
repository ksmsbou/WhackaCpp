package com.android.tesis.luigi.whackac;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

Button botoninicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set window fullscreen and remove title bar, and force landscape orientation
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoninicio = (Button) findViewById(R.id.button_inicio);
        botoninicio.setOnClickListener(this);


    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_inicio:
                Intent intent = new Intent(this,menu_activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void onBackPressed() {
        Intent appout = new Intent(Intent.ACTION_MAIN);
        appout.addCategory(Intent.CATEGORY_HOME);
        appout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(appout);

    }


}
