package com.rupalisinha.banktask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends Activity {

    TextView designed, name, app_name,textView,textView1;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        logo = findViewById(R.id.logo);
        designed = findViewById(R.id.designed);
        name = findViewById(R.id.name);
        app_name = findViewById(R.id.app_name);
        textView= findViewById(R.id.i_view);
        textView1=findViewById(R.id.text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startEnterAnimation();
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }, 5500);
    }

    private void startEnterAnimation() {
        app_name.startAnimation(AnimationUtils.loadAnimation(splash_screen.this, R.anim.bottom));
        logo.startAnimation(AnimationUtils.loadAnimation(splash_screen.this, R.anim.bottom));
        logo.setVisibility(View.VISIBLE);
        designed.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        app_name.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        textView1.setVisibility(View.VISIBLE);
    }
}


