package com.example.dialog_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button Button_Active;
    Button Button_Close;

    LinearLayout LinearLayout_mykonten;
    LinearLayout LinearLayout_overbox;

    ImageView ImageView_logo;

    Animation Animation_fromsmall;
    Animation Animation_fromnothing;
    Animation Animation_forloci;
    Animation Animation_togo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_Active = findViewById(R.id.Button_Active);
        Button_Close = findViewById(R.id.Button_Close);

        LinearLayout_mykonten = findViewById(R.id.LinearLayout_mykonten);
        LinearLayout_overbox = findViewById(R.id.LinearLayout_overbox);

        ImageView_logo = findViewById(R.id.ImageView_logo);

        Animation_fromsmall = AnimationUtils.loadAnimation(this,R.anim.fromsmall);
        Animation_fromnothing =AnimationUtils.loadAnimation(this,R.anim.fromnothing);
        Animation_forloci =AnimationUtils.loadAnimation(this,R.anim.forloci);
        Animation_togo=AnimationUtils.loadAnimation(this,R.anim.togo);

        LinearLayout_mykonten.setAlpha(0);
        LinearLayout_overbox.setAlpha(0);
        ImageView_logo.setVisibility(View.GONE);

        Button_Active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout_overbox.setAlpha(1);
                LinearLayout_overbox.startAnimation(Animation_fromnothing);

                LinearLayout_mykonten.setAlpha(1);
                LinearLayout_mykonten.startAnimation(Animation_fromsmall);

                ImageView_logo.setVisibility(View.VISIBLE);
                ImageView_logo.startAnimation(Animation_forloci);
            }
        });

        Button_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout_overbox.startAnimation(Animation_togo);
                LinearLayout_mykonten.startAnimation(Animation_togo);
                ImageView_logo.startAnimation(Animation_togo);
                ImageView_logo.setVisibility(View.GONE);

                ViewCompat.animate(LinearLayout_mykonten).setStartDelay(1000).alpha(0).start();
                ViewCompat.animate(LinearLayout_overbox).setStartDelay(1000).alpha(0).start();
            }
        });
    }
}
