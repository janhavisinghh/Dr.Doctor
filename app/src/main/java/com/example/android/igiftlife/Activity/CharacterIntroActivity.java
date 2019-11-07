package com.example.android.igiftlife.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.igiftlife.R;

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
    private Button yes_tv;
    private Button no_tv;
    private String IS_LAST_SCREEN = "IS_LAST_SCREEN";
    private int isLastScreen;
    private TextView touchAnywhereTv;
    private LinearLayout gameEndedRelativeLayout;
    private TextView gameEndedPlayAgainButton;
    private Button gameEndedVisitIgiftLifeButton;
    private String pledgeFormUrl = "https://igiftlife.com/register-for-organ-donation/";
    private TextView igiftlifeIntro;
    private String IS_SECOND_STORY_LINE = "IS_SECOND_STORY_LINE";
    private Handler textAnimationHandler = new Handler();
    private Runnable textAnimationRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_intro);
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        characterIntroFrameLayout = findViewById(R.id.character_intro_layout);
        characterIntroImageView = findViewById(R.id.character_intro_image_view);
        characterIntroTextView = findViewById(R.id.character_intro_textview);
        characterIntro = new ArrayList<>();
        yes_tv = findViewById(R.id.yes_tv);
        no_tv = findViewById(R.id.no_tv);
        touchAnywhereTv = findViewById(R.id.touchAnywhereTv);

        characterIntro = getIntent().getStringArrayListExtra(CHARACTER_INTRO_ARRAY);
        isABoyCharacter = getIntent().getIntExtra(IS_A_BOY_CHAR, 0);
        isLastScreen = getIntent().getIntExtra(IS_LAST_SCREEN, 0);
        gameEndedRelativeLayout = findViewById(R.id.gameEndedLinearLayout);
        gameEndedPlayAgainButton = findViewById(R.id.playAgainButton);
        gameEndedVisitIgiftLifeButton = findViewById(R.id.visitIgiftLifeBtn);
        igiftlifeIntro = findViewById(R.id.igiftlife_intro);


        if (isABoyCharacter == 0)
            characterIntroImageView.setImageDrawable(getDrawable(R.drawable.girl_avatar_transparent_bg));
        else
            characterIntroImageView.setImageDrawable(getDrawable(R.drawable.boy_avatar_transparent_bg));

        if (isLastScreen == 1) {
            yes_tv.setVisibility(View.VISIBLE);
            no_tv.setVisibility(View.VISIBLE);
            touchAnywhereTv.setVisibility(View.GONE);
            typingAnimation(characterIntroTextView, characterIntro.get(0), 1);
            no_tv.setEnabled(true);
            yes_tv.setEnabled(true);
            yes_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    igiftlifeIntro.setText(getString(R.string.if_user_says_yes));
                    gameEndedRelativeLayout.setVisibility(View.VISIBLE);

                    gameEndedPlayAgainButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent myIntent = new Intent(CharacterIntroActivity.this, MainActivity.class);
                            CharacterIntroActivity.this.startActivity(myIntent);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            finish();
                        }
                    });

                    gameEndedVisitIgiftLifeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(pledgeFormUrl));
                            startActivity(i);
                        }
                    });
                }
            });
            no_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gameEndedVisitIgiftLifeButton.setVisibility(View.GONE);
                    igiftlifeIntro.setText(getString(R.string.if_user_says_no));
                    gameEndedRelativeLayout.setVisibility(View.VISIBLE);

                    gameEndedPlayAgainButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent myIntent = new Intent(CharacterIntroActivity.this, MainActivity.class);
                            CharacterIntroActivity.this.startActivity(myIntent);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            finish();
                        }
                    });

                }
            });
        } else {
            yes_tv.setVisibility(View.GONE);
            no_tv.setVisibility(View.GONE);
            touchAnywhereTv.setVisibility(View.VISIBLE);
            characterIntroFrameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (characterIntro.size() == count) {
                        yes_tv.setVisibility(View.VISIBLE);
                        no_tv.setVisibility(View.VISIBLE);
                        touchAnywhereTv.setVisibility(View.GONE);
                        typingAnimation(characterIntroTextView, "I don't feel like going to school though. Should I go or not?", 1);
                        yes_tv.setEnabled(true);
                        no_tv.setEnabled(true);
                        yes_tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent myIntent = new Intent(CharacterIntroActivity.this, StoryActivity.class);
                                myIntent.putExtra(IS_A_BOY_CHAR, isABoyCharacter);
                                myIntent.putExtra(IS_SECOND_STORY_LINE, 0);
                                CharacterIntroActivity.this.startActivity(myIntent);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                finish();
                            }
                        });

                        no_tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent myIntent = new Intent(CharacterIntroActivity.this, StoryActivity.class);
                                myIntent.putExtra(IS_A_BOY_CHAR, isABoyCharacter);
                                myIntent.putExtra(IS_SECOND_STORY_LINE, 1);
                                CharacterIntroActivity.this.startActivity(myIntent);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                finish();
                            }
                        });

                    } else {
                        typingAnimation(characterIntroTextView, characterIntro.get(count), 1);
                        count++;
                    }
                }
            });
        }
    }

    private void typingAnimation(final TextView view, final String text, final int length) {
        int delay = 100;
        if (Character.isWhitespace(text.charAt(length - 1))) {
            delay = 200;
        }
        view.setText(text.substring(0, length));

        if (length != text.length()) {
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
