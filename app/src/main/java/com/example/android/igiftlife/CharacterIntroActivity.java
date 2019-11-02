package com.example.android.igiftlife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CharacterIntroActivity extends AppCompatActivity {
    private FrameLayout characterIntroFrameLayout;
    private ImageView characterIntroImageView;
    private TextView characterIntroTextView;
    private ArrayList<String> characterIntro;
    private String CHARACTER_INTRO_ARRAY = "CHARACTER_INTRO_ARRAY";
    private int count = 0;
    private int isABoyCharacter;
    private String IS_A_BOY_CHAR = "IS_A_BOY_CHAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_intro);
        getSupportActionBar().hide();
        characterIntroFrameLayout = findViewById(R.id.character_intro_layout);
        characterIntroImageView = findViewById(R.id.character_intro_image_view);
        characterIntroTextView = findViewById(R.id.character_intro_textview);
        characterIntro = new ArrayList<>();

        characterIntro = getIntent().getStringArrayListExtra(CHARACTER_INTRO_ARRAY);
        isABoyCharacter = getIntent().getIntExtra(IS_A_BOY_CHAR, 0);

        if (isABoyCharacter == 0)
            characterIntroImageView.setImageDrawable(getDrawable(R.drawable.girl_avatar_transparent_bg));
        else
            characterIntroImageView.setImageDrawable(getDrawable(R.drawable.boy_avatar_transparent_bg));

        characterIntroFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (characterIntro.size() == count) {
                    Intent myIntent = new Intent(CharacterIntroActivity.this, StoryActivity.class);
                    myIntent.putExtra(IS_A_BOY_CHAR, isABoyCharacter);
                    CharacterIntroActivity.this.startActivity(myIntent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                } else {
                    typingAnimation(characterIntroTextView, characterIntro.get(count), 1);
                    count++;
                }
            }
        });
    }

    private Handler textAnimationHandler = new Handler();
    private Runnable textAnimationRunnable;

    private void typingAnimation(final TextView view, final String text, final int length) {
        int delay = 100;
        if (Character.isWhitespace(text.charAt(length - 1))) {
            delay = 200;
        }
        view.setText(text.substring(0, length));
        if (length == text.length())
            return;
        else {
            if (textAnimationRunnable != null) {
                textAnimationHandler.removeCallbacks(textAnimationRunnable);
            }
            textAnimationRunnable = new Runnable() {
                @Override
                public void run() {
                    typingAnimation(view, text, length + 1);
                }
            };
            textAnimationHandler.postDelayed(textAnimationRunnable, delay);
        }
    }
}
