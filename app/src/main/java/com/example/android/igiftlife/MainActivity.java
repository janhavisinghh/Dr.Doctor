package com.example.android.igiftlife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout girlBoyCharLinearLayout;
    private ImageView playButtonImageView;
    private ImageButton girlCharacterButton;
    private ImageButton boyCharacterButton;
    private Handler handler;
    private int isABoyCharacter;
    private TextView areYouAGirlOrBoy;
    private LinearLayout girlBoyCharText;
    private FrameLayout girlIntroFrameLayout;
    private FrameLayout boyIntroFrameLayout;
    private TextView girlIntroTextView;
    private TextView boyIntroTextView;
    private Button girlIntroButton;
    private Button boyIntroButton;

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
        girlIntroFrameLayout = findViewById(R.id.girl_intro);
        boyIntroFrameLayout = findViewById(R.id.boy_intro);
        girlIntroTextView = findViewById(R.id.girl_intro_text_view);
        boyIntroTextView = findViewById(R.id.boy_intro_text_view);
        girlIntroButton = findViewById(R.id.girl_intro_button);
        boyIntroButton = findViewById(R.id.boy_intro_button);

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
                boyCharacterButton.setVisibility(View.GONE);
                areYouAGirlOrBoy.setVisibility(View.GONE);
                girlBoyCharText.setVisibility(View.GONE);
                girlIntroFrameLayout.setVisibility(View.VISIBLE);
                girlIntroTextView.setText(getResources().getText(R.string.girl_intro));
                girlIntroTextView.setMovementMethod(new ScrollingMovementMethod());
                girlIntroButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MainActivity.this, StoryActivity.class);
                        isABoyCharacter = 0;  //0 is for girl character
                        myIntent.putExtra("IS_A_BOY_CHAR", isABoyCharacter);
                        MainActivity.this.startActivity(myIntent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                });
            }
        });

        boyCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlCharacterButton.setVisibility(View.GONE);
                areYouAGirlOrBoy.setVisibility(View.GONE);
                girlBoyCharText.setVisibility(View.GONE);
                boyIntroFrameLayout.setVisibility(View.VISIBLE);
                boyIntroTextView.setText(getResources().getText(R.string.boy_intro));
                boyIntroTextView.setMovementMethod(new ScrollingMovementMethod());
                boyIntroButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MainActivity.this, StoryActivity.class);
                        isABoyCharacter = 1; //1 is for boy charater
                        myIntent.putExtra("IS_A_BOY_CHAR", isABoyCharacter);
                        MainActivity.this.startActivity(myIntent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                });
            }
        });
    }

}
