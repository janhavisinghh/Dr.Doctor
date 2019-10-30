package com.example.android.igiftlife;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout girlBoyCharLinearLayout;
    private ImageView playButtonImageView;
    private ImageButton girlCharacterButton;
    private ImageButton boyCharacterButton;
    private Handler handler;
    private int isABoyCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButtonImageView = findViewById(R.id.playButton);
        girlBoyCharLinearLayout = findViewById(R.id.girlBoyCharLinearLayout);
        girlCharacterButton = findViewById(R.id.girlCharacter);
        boyCharacterButton = findViewById(R.id.boyCharacter);
        handler = new Handler();

        girlBoyCharLinearLayout.setVisibility(View.GONE);
        boyCharacterButton.setEnabled(true);
        girlCharacterButton.setEnabled(true);

        playButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        girlBoyCharLinearLayout.setVisibility(View.VISIBLE);
                        playButtonImageView.setVisibility(View.GONE);
                    }
                }, 500);

            }
        });

        girlCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boyCharacterButton.setVisibility(View.INVISIBLE);
                Intent myIntent = new Intent(MainActivity.this, StoryActivity.class);
                isABoyCharacter = 0;  //0 is for girl character
                myIntent.putExtra("IS_A_BOY_CHAR", isABoyCharacter);
                MainActivity.this.startActivity(myIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        boyCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlCharacterButton.setVisibility(View.INVISIBLE);
                Intent myIntent = new Intent(MainActivity.this, StoryActivity.class);
                isABoyCharacter = 1; //1 is for boy charater
                myIntent.putExtra("IS_ A_BOY_CHAR", isABoyCharacter);
                MainActivity.this.startActivity(myIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

}
