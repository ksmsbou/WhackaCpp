package com.android.tesis.luigi.whackac;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Random;

public class menu_activity extends AppCompatActivity implements View.OnClickListener  {
    Button botonjuego;
    Button botonteoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity);

        botonteoria = (Button) findViewById(R.id.button_teoria);
        botonteoria.setOnClickListener(this);
        botonjuego = (Button) findViewById(R.id.button_juego);
        botonjuego.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_teoria:
                Intent intentt = new Intent(this, teoriaActivity.class);
                startActivity(intentt);
                break;
            case R.id.button_juego:
               /* Random generator = new Random();
                int number = generator.nextInt(3) + 1;
                // The '3' is the number of activities

                Class activity = null;

                // Here, we are checking to see what the output of the random was
                switch (number) {
                    case 1:
                        // E.g., if the output is 1, the activity we will open is ActivityOne.class
                        activity = gameActivity.class;
                        break;
                    case 2:
                        activity = gameActivity2.class;
                        break;
                    case 3:
                        activity = gameActivity3.class;
                        break;

                }
                // We use intents to start activities
                Intent intentj = new Intent(this, activity);
                startActivity(intentj);*/
                Intent intentj = new Intent(this, gameActivity.class);
                startActivity(intentj);
                break;


        }

    }

    public void onBackPressed() {
        Intent startMain = new Intent(this,MainActivity.class);
        startActivity(startMain);
    }
}
