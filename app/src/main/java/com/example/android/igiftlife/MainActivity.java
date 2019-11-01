package com.example.android.igiftlife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        getSupportActionBar().hide();

        playButtonImageView = findViewById(R.id.playButton);
        girlBoyCharLinearLayout = findViewById(R.id.girlBoyCharLinearLayout);
        girlCharacterButton = findViewById(R.id.girlCharacter);
        boyCharacterButton = findViewById(R.id.boyCharacter);
        handler = new Handler();
        areYouAGirlOrBoy = findViewById(R.id.areYouAGirlOrBoy);
        girlBoyCharText = findViewById(R.id.girlBoyCharText);
        characterIntroKiara = new ArrayList<>();
        characterIntroRaj = new ArrayList<>();

        characterIntroKiara.add("Hey there! I am Kiara.");
        characterIntroKiara.add("I am 14 years old.");
        characterIntroKiara.add("Everybody teases me by calling me Tiara but I think I have a nice name.");
        characterIntroKiara.add("I like to dance a lot. I keep dancing always.");
        characterIntroKiara.add("Mumma says I should take rest also but");
        characterIntroKiara.add("I want to become the best dancer when I grow up.");
        characterIntroKiara.add("I also like to run a lot.");
        characterIntroKiara.add("My teacher says I am the fastest in my class.");
        characterIntroKiara.add("Beating boys is fun,");
        characterIntroKiara.add("they get very angry when they loose from a girl.");
        characterIntroKiara.add("I like pink color a lot.");
        characterIntroKiara.add("I have a pink bag and shoes, my favorite.");
        characterIntroKiara.add("Its now 7am in the morning");
        characterIntroKiara.add("and it is time for me to go to school.");
        characterIntroKiara.add("And my mom is calling me.");
        characterIntroKiara.add("So, yeah. See you!");

        characterIntroRaj.add("Hey there! I am Raj.");
        characterIntroRaj.add("I am 14 years old.");
        characterIntroRaj.add("I like to swim and play basketball.");
        characterIntroRaj.add("I am very tall in my class");
        characterIntroRaj.add("and everybody loves to have me in their team. ");
        characterIntroRaj.add("I also like to play Table tennis.");
        characterIntroRaj.add("My mumma makes me eat lots of veggies,");
        characterIntroRaj.add("but I do not like them.");
        characterIntroRaj.add("She says they are important ");
        characterIntroRaj.add("since I like to play so much and I am growing up.");
        characterIntroRaj.add("My favorite color is black");
        characterIntroRaj.add("and I always like to wear it.");
        characterIntroRaj.add("Its now 7am in the morning");
        characterIntroRaj.add("and it is time for me to go to school.");
        characterIntroRaj.add("And my mom is calling me.");
        characterIntroRaj.add("So, yeah. See you!");


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

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(MainActivity.this, CharacterIntroActivity.class);
                        isABoyCharacter = 0; //1 is for boy charater
                        myIntent.putExtra("IS_A_BOY_CHAR", isABoyCharacter);
                        myIntent.putExtra(CHARACTER_INTRO_ARRAY, characterIntroKiara);
                        MainActivity.this.startActivity(myIntent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                }, 1000);

            }
        });

        boyCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlCharacterButton.setVisibility(View.INVISIBLE);
                areYouAGirlOrBoy.setVisibility(View.GONE);
                girlBoyCharText.setVisibility(View.GONE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(MainActivity.this, CharacterIntroActivity.class);
                        isABoyCharacter = 1; //1 is for boy charater
                        myIntent.putExtra("IS_A_BOY_CHAR", isABoyCharacter);
                        myIntent.putExtra(CHARACTER_INTRO_ARRAY, characterIntroRaj);
                        MainActivity.this.startActivity(myIntent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                }, 1000);
            }
        });
    }

}
