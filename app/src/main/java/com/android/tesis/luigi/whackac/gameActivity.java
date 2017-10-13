package com.android.tesis.luigi.whackac;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import android.util.Log;

public class gameActivity extends AppCompatActivity implements View.OnClickListener {

   static int img []={R.drawable.varimg1,R.drawable.varimg2,R.drawable.varimg3,R.drawable.forimg1,R.drawable.forimg2,R.drawable.forimg3};
    int countdown = 60;
    int score = 0;
    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int imgcorrecta[] = {R.drawable.varimg1};
    int imgincorrecta[] = {R.drawable.varimg2,R.drawable.varimg3,R.drawable.forimg1,R.drawable.forimg2,R.drawable.forimg3};
    ImageButton button;
    ImageButton button2;
    ImageButton button3;
    ImageView syntaxImg1;
    ImageView syntaxImg2;
    ImageView syntaxImg3;
    ImageView moleImg1;
    ImageView moleImg2;
    ImageView moleImg3;
    TextView scoreText;
    TextView timeText;
    Timer timer= new Timer();
    int flag;
    int imgused1;
    int imgused2;
    int imgused3;
    int currvalue;
    boolean touched1 = false;
    boolean touched2 = false;
    boolean touched3 = false;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set window fullscreen and remove title bar, and force landscape orientation
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button=(ImageButton) findViewById(R.id.imageButton);
        button2=(ImageButton) findViewById(R.id.imageButton2);
        button3=(ImageButton) findViewById(R.id.imageButton3);

        syntaxImg1 = (ImageView) findViewById(R.id.syntax1);
        syntaxImg2 = (ImageView) findViewById(R.id.syntax2);
        syntaxImg3 = (ImageView) findViewById(R.id.syntax3);

        moleImg1 = (ImageView) findViewById(R.id.mole1);
        moleImg2 = (ImageView) findViewById(R.id.mole2);
        moleImg3 = (ImageView) findViewById(R.id.mole3);

        scoreText = (TextView) findViewById(R.id.scoretext);
        timeText = (TextView) findViewById(R.id.timetext);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        handler.postDelayed(changeImage,500);

    }




        Runnable changeImage = new Runnable() {

            @Override
            public void run() {
                Random generator = new Random();

                if (counter1 == 0) {

                    currvalue = generator.nextInt(img.length);
                    while (currvalue == imgused1 || currvalue == imgused2 || currvalue == imgused3) {
                        currvalue = generator.nextInt(img.length);
                    }
                    /*if (currvalue != imgused1) {
                        Log.d("1)currvalue != imgused1","["+currvalue+","+"("+imgused1+","+counter1+")"+"]");
                    }*/
                    /*syntaxImg1.setBackgroundResource(img[currvalue]);*/

                    touched1 = false;
                    moleImg1.setImageDrawable(getResources().getDrawable(R.drawable.moleneutral));

                    /*syntaxImg1.setImageDrawable(getResources().getDrawable(img[currvalue],null));*/
                    syntaxImg1.setImageDrawable(getResources().getDrawable(img[currvalue]));
                    imgused1 = currvalue;
                    counter1 = ThreadLocalRandom.current().nextInt(3,6);

                } else {
                    counter1--;
                }

                if (counter2 == 0) {

                    currvalue = generator.nextInt(img.length);
                    while (currvalue == imgused1 || currvalue == imgused2 || currvalue == imgused3) {
                        currvalue = generator.nextInt(img.length);
                    }
                   /* if (currvalue != imgused2) {
                        Log.d("2)currvalue != imgused2","["+currvalue+","+"("+imgused2+","+counter2+")"+"]");
                    }
                    if (currvalue != imgused1) {
                        Log.d("2)currvalue != imgused1","["+currvalue+","+"("+imgused1+","+counter1+")"+"]");
                    }*/

                    touched2 = false;
                    moleImg2.setImageDrawable(getResources().getDrawable(R.drawable.moleneutral));

                    /*syntaxImg2.setBackgroundResource(img[currvalue]);*/
                    syntaxImg2.setImageDrawable(getResources().getDrawable(img[currvalue]));

                    imgused2 = currvalue;

                    counter2 = ThreadLocalRandom.current().nextInt(3,6);

                } else {
                    counter2--;
                }

                if (counter3 == 0) {

                    currvalue = generator.nextInt(img.length);
                    while (currvalue == imgused1 || currvalue == imgused2 || currvalue == imgused3) {
                        currvalue = generator.nextInt(img.length);
                    }

                    /*if (currvalue != imgused3) {
                        Log.d("3)currvalue != imgused3","["+currvalue+","+"("+imgused3+","+counter3+")"+"]");
                    }
                    if (currvalue != imgused1) {
                        Log.d("3)currvalue != imgused1","["+currvalue+","+"("+imgused1+","+counter1+")"+"]");
                    }
                    if (currvalue != imgused2) {
                        Log.d("3)currvalue != imgused2","["+currvalue+","+"("+imgused2+","+counter2+")"+"]");
                    }*/

                    touched3 = false;
                    moleImg3.setImageDrawable(getResources().getDrawable(R.drawable.moleneutral));

                    /*syntaxImg3.setBackgroundResource(img[currvalue]);*/
                    syntaxImg3.setImageDrawable(getResources().getDrawable(img[currvalue]));
                    imgused3 = currvalue;

                    counter3 = ThreadLocalRandom.current().nextInt(3,6);

                } else {
                    counter3--;
                }

                /*Log.d("meh","["+"("+imgused1+","+counter1+")"+","+"("+imgused2+","+counter2+")"+","+"("+imgused3+","+counter3+")"+"]");*/

                if (countdown>0) {
                    countdown -= 1;
                    scoreText.setText("Puntuacion: "+score);
                    timeText.setText("Tiempo: "+countdown/2);
                    handler.postDelayed(changeImage, 500);
                } else {
                    Toast.makeText( getApplicationContext(),"Timeout! Puntuacion:"+score ,Toast.LENGTH_SHORT).show();
                }


               /* if (flag > img.length - 1) {
                    flag = 0;
                    handler.removeCallbacks(changeImage);
                } else {

                    handler.postDelayed(changeImage, 1000);
                }*/

            }


        };

   @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageButton:
                int a;
                if (!touched1) {
                    touched1 = true;
                    counter1 = 2;
                    for (a = 0; a < imgcorrecta.length; a++) {
                        if (img[imgused1] == imgcorrecta[a]) {
                            //Toast.makeText(getApplicationContext(), "Correcto!", Toast.LENGTH_SHORT).show();
                            moleImg1.setImageDrawable(getResources().getDrawable(R.drawable.moleright));
                            score += 5;
                        } else {
                            //Toast.makeText(getApplicationContext(), "NOPE!", Toast.LENGTH_SHORT).show();
                            moleImg1.setImageDrawable(getResources().getDrawable(R.drawable.molewrong));
                            score -= 2;
                        }
                    }
                }
                break;

            case R.id.imageButton2:
                int b;
                if (!touched2) {
                    touched2 = true;
                    counter2 = 2;
                    for (b = 0; b < imgcorrecta.length; b++) {
                        if (img[imgused2] == imgcorrecta[b]) {
                            //Toast.makeText(getApplicationContext(), "Correcto!", Toast.LENGTH_SHORT).show();
                            moleImg2.setImageDrawable(getResources().getDrawable(R.drawable.moleright));
                            score += 5;
                        } else {
                            //Toast.makeText(getApplicationContext(), "NOPE!", Toast.LENGTH_SHORT).show();
                            moleImg2.setImageDrawable(getResources().getDrawable(R.drawable.molewrong));
                            score -= 2;
                        }
                    }
                }
                break;

            case R.id.imageButton3:
                int c;
                if (!touched3) {
                    touched3 = true;
                    counter3 = 2;
                    for (c = 0; c < imgcorrecta.length; c++) {
                        if (img[imgused3] == imgcorrecta[c]) {
                            //Toast.makeText(getApplicationContext(), "Correcto!", Toast.LENGTH_SHORT).show();
                            moleImg3.setImageDrawable(getResources().getDrawable(R.drawable.moleright));
                            score += 5;
                        } else {
                            //Toast.makeText(getApplicationContext(), "NOPE!", Toast.LENGTH_SHORT).show();
                            moleImg3.setImageDrawable(getResources().getDrawable(R.drawable.molewrong));
                            score -= 2;
                        }
                    }
                }
                break;
        }
    }








    public void onBackPressed() {
        Intent startMain = new Intent(this,menu_activity.class);
        startActivity(startMain);
    }




}
