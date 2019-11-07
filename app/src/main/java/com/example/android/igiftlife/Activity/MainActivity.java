package com.example.android.igiftlife.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.igiftlife.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout girlBoyCharLinearLayout;
    private ImageView playButtonImageView;
    private ImageButton girlCharacterButton;
    private ImageButton boyCharacterButton;
    private Handler handler;
    private int isABoyCharacter;
    private TextView areYouAGirlOrBoy;
    private LinearLayout girlBoyCharText;
    private ArrayList<String> characterIntroKiara;
    private ArrayList<String> characterIntroRaj;
    private String CHARACTER_INTRO_ARRAY = "CHARACTER_INTRO_ARRAY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        playButtonImageView = findViewById(R.id.playButton);
        girlBoyCharLinearLayout = findViewById(R.id.girlBoyCharLinearLayout);
        girlCharacterButton = findViewById(R.id.girlCharacter);
        boyCharacterButton = findViewById(R.id.boyCharacter);
        handler = new Handler();
        areYouAGirlOrBoy = findViewById(R.id.areYouAGirlOrBoy);
        girlBoyCharText = findViewById(R.id.girlBoyCharText);
        characterIntroKiara = new ArrayList<>();
        characterIntroRaj = new ArrayList<>();

        characterIntroKiara.add("Hey there! I am Kiara. I am 14 years old.");
        characterIntroKiara.add("Everybody teases me by calling me Tiara but I think I have a nice name.");
        characterIntroKiara.add("I like to dance a lot. I keep dancing always. I also like running.");
        characterIntroKiara.add("Its now 7am in the morning and it is time for me to go to school.");
        characterIntroKiara.add("And my mom is calling me. So, yeah. See you!");

        characterIntroRaj.add("Hey there! I am Raj. I am 14 years old.");
        characterIntroRaj.add("I like to swim and play basketball.");
        characterIntroRaj.add("My mumma makes me eat lots of veggies, but I do not like them.");
        characterIntroRaj.add("Its now 7am in the morning and it is time for me to go to school.");
        characterIntroRaj.add("And my mom is calling me. So, yeah. See you!");


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
                        areYouAGirlOrBoy.setVisibility(View.VISIBLE);
                        girlBoyCharText.setVisibility(View.VISIBLE);
                        playButtonImageView.setVisibility(View.GONE);
                    }
                }, 500);

            }
        });

        girlCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boyCharacterButton.setVisibility(View.INVISIBLE);
                areYouAGirlOrBoy.setVisibility(View.GONE);
                girlBoyCharText.setVisibility(View.GONE);

                Intent myIntent = new Intent(MainActivity.this, CharacterIntroActivity.class);
                isABoyCharacter = 0; //1 is for boy charater
                myIntent.putExtra("IS_A_BOY_CHAR", isABoyCharacter);
                myIntent.putExtra(CHARACTER_INTRO_ARRAY, characterIntroKiara);
                MainActivity.this.startActivity(myIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        boyCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlCharacterButton.setVisibility(View.INVISIBLE);
                areYouAGirlOrBoy.setVisibility(View.GONE);
                girlBoyCharText.setVisibility(View.GONE);

                Intent myIntent = new Intent(MainActivity.this, CharacterIntroActivity.class);
                isABoyCharacter = 1; //1 is for boy charater
                myIntent.putExtra("IS_A_BOY_CHAR", isABoyCharacter);
                myIntent.putExtra(CHARACTER_INTRO_ARRAY, characterIntroRaj);
                MainActivity.this.startActivity(myIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
    }

}
