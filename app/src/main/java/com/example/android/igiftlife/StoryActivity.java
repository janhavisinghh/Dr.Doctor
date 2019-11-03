package com.example.android.igiftlife;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity {

    private int count = 0;
    private int score = 0;
    private int life = 3;
    private ArrayList<Story> girlStoryList;
    private ArrayList<Story> boyStoryList;
    private ArrayList<Story> storyList;
    private Button nextButton;
    private ImageView storyImageView;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private Vibrator vibe;
    private Handler handler;
    private int isABoyCharacter;
    private String IS_A_BOY_CHAR = "IS_A_BOY_CHAR";
    private String STORY_LIST = "STORY_LIST";
    private String STORY_LIST_COUNT = "STORY_LIST_COUNT";
    private String SCORE = "SCORE";
    private String LIFE_POINTS = "LIFE_POINTS";

    private TextView scoreTextView;
    private TextView lifeTextView;
    private FrameLayout scoreCardFrameLayout;
    private TextView scoreCardTextView;
    private RelativeLayout lifeEndedRelativeLayout;
    private Button tryAgainButton;
    private Button visitIgiftLifeButton;
    private LinearLayout menuItemLinearLayout;
    private String igiftLifeUrl = "https://igiftlife.com/";
    private LinearLayout optionsLinearLayout;
    private ArrayList<String> endIntro;
    private String IS_LAST_SCREEN = "IS_LAST_SCREEN";
    private String CHARACTER_INTRO_ARRAY = "CHARACTER_INTRO_ARRAY";
    private int isLastScreen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        getSupportActionBar().hide();

        girlStoryList = new ArrayList<>();
        boyStoryList = new ArrayList<>();
        storyList = new ArrayList<>();
        endIntro = new ArrayList<>();

        nextButton = findViewById(R.id.nextStoryButton);
        option1 = findViewById(R.id.mcq_option_1);
        option2 = findViewById(R.id.mcq_option_2);
        option3 = findViewById(R.id.mcq_option_3);
        option4 = findViewById(R.id.mcq_option_4);
        storyImageView = findViewById(R.id.comicStripIv);
        scoreTextView = findViewById(R.id.scoreTextView);
        lifeTextView = findViewById(R.id.lifeTextView);
        scoreCardFrameLayout = findViewById(R.id.scoreCardFrameLayout);
        scoreCardTextView = findViewById(R.id.scoreCardTextView);
        lifeEndedRelativeLayout = findViewById(R.id.lifeEndedFrameLayout);
        tryAgainButton = findViewById(R.id.tryAgainButton);
        visitIgiftLifeButton = findViewById(R.id.visitIgiftLifeButton);
        menuItemLinearLayout = findViewById(R.id.menuItemLinearLayout);
        optionsLinearLayout = findViewById(R.id.options_layout);

        handler = new Handler();

        if (savedInstanceState == null) {
            isABoyCharacter = getIntent().getIntExtra("IS_A_BOY_CHAR", 0);

            girlStoryList.add(new Story(R.drawable.homegirl1, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.homegirl2, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.homegirl3, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl1, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl2, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl3, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl4, true, new Options("Can Organs be donated only to family members?", new String[]{"1. No, Organs are donated to patients on the waiting list. And can be donated to family members only if it is living donation.", "2.Yes, organs can be donated only within the family.", "3.No, organs can not be donated within the family.", "4. Not Sure"}, 1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl5, true, new Options("Should it not be Kabeer’s choice if he wants to donate his organs or not? But now who will decide if Kabeer’s organs can be donated?", new String[]{"1. Doctor", "2. Family", "3. He can not donate organs now."}, 2)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl6, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl7, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl8, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl9, true, new Options("What organs can he successfully donate after being brain dead?", new String[]{"1. Heart, lungs, liver, kidneys, cornea , pancreases, part of skin and bones", "2. Cornea, part of skin and bones", "3. Kidney, part of liver and part of skin"}, 1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl10, true, new Options("What is the minimum age to register as an organ donor?", new String[]{"1. 18", "2. 25", "3. No age bar!!"}, 1)));
            girlStoryList.add(new Story(R.drawable.girlquiz1, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.girlquiz2, false, new Options("", new String[]{}, -1)));

            girlStoryList.add(new Story(R.drawable.pledge_steps_1, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.pledge_steps_2, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.pledge_steps_3, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.pledge_steps_4, false, new Options("", new String[]{}, -1)));

            girlStoryList.add(new Story(R.drawable.hospitalgirl11, false, new Options("Let's play a quiz on Organ Donation?", new String[]{"1. OKAY!"}, 1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl12, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.girlquiz3, true, new Options("Does donating organs cost money?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 2)));
            girlStoryList.add(new Story(R.drawable.girlquiz4, true, new Options("Is there a priority list for rich and famous people to get organs?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 2)));
            girlStoryList.add(new Story(R.drawable.girlquiz5, true, new Options("After a person’s death, Can that person’s family refuse to donate his/her organs in spite of the person having a donor card?\n", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 1)));

            girlStoryList.add(new Story(R.drawable.hospitalgirl13, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl14, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl15, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl16, true, new Options("What organs can he successfully donate after a heart failure?", new String[]{"1. Kidneys, Lungs and Brain", "2. Cornea, Bones, and Part of Skin", "3. Pancreas, Liver, and Bones"}, 2)));
            girlStoryList.add(new Story(R.drawable.girlquiz6, true, new Options("Do you think Raj’s uncle was right?", new String[]{"1. Yes, body gets disfigured after organ donation\n", "2. No, it is a myth", "3. Not Sure"}, 2)));


            girlStoryList.add(new Story(R.drawable.hospitalgirl17, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl18, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.girlquiz7, true, new Options("If I have a pledge card and I am in the hospital, will the doctor try to save me?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 1)));
            girlStoryList.add(new Story(R.drawable.girlquiz8, true, new Options("Can I donate organs if I’m sick?", new String[]{"1. Yes", "2. No", "3. Depends on Medical Conditions"}, 3)));

            girlStoryList.add(new Story(R.drawable.hospitalgirl19, false, new Options("How long can organs and tissue survive once harvested till transplantation if preserved?", new String[]{"1. Match the following!"}, 1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl20, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl21, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl22, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl23, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl24, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl25, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl26, false, new Options("", new String[]{}, -1)));

            boyStoryList.add(new Story(R.drawable.homeboy1, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.homeboy2, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.homeboy3, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy1, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy2, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy3, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy4, true, new Options("Can Organs be donated only to family members?", new String[]{"1. No, Organs are donated to patients on the waiting list. And can be donated to family members only if it is living donation.", "2.Yes, organs can be donated only within the family.", "3. Not Sure"}, 1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy5, true, new Options("Should it not be Kabeer’s choice if he wants to donate his organs or not? But now who will decide if Kabeer’s organs can be donated?", new String[]{"1. Doctor", "2. Family", "3. He can not donate organs now."}, 2)));
            boyStoryList.add(new Story(R.drawable.hospitalboy6, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy7, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy8, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy9, true, new Options("What organs can he successfully donate after being brain dead?", new String[]{"1. Heart, lungs, liver, kidneys, cornea , pancreases, part of skin and bones", "2. Cornea, part of skin and bones", "3. Kidney, part of liver and part of skin"}, 1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy10, true, new Options("What is the minimum age to register as an organ donor?", new String[]{"1. 18", "2. 25", "3. No age bar!!"}, 1)));
            boyStoryList.add(new Story(R.drawable.boyquiz1, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.boyquiz2, false, new Options("", new String[]{}, -1)));

            boyStoryList.add(new Story(R.drawable.pledge_steps_1, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.pledge_steps_2, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.pledge_steps_3, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.pledge_steps_4, false, new Options("", new String[]{}, -1)));

            boyStoryList.add(new Story(R.drawable.hospitalboy11, false, new Options("Let's play a quiz on Organ Donation?", new String[]{"1. OKAY!"}, 1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy12, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.boyquiz3, true, new Options("Does donating organs cost money?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 2)));
            boyStoryList.add(new Story(R.drawable.boyquiz4, true, new Options("Is there a priority list for rich and famous people to get organs?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 2)));
            boyStoryList.add(new Story(R.drawable.boyquiz5, true, new Options("After a person’s death, Can that person’s family refuse to donate his/her organs in spite of the person having a donor card?\n", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 1)));

            boyStoryList.add(new Story(R.drawable.hospitalboy13, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy14, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy15, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy16, true, new Options("What organs can he successfully donate after a heart failure?", new String[]{"1. Kidneys, Lungs and Brain", "2. Cornea, Bones, and Part of Skin", "3. Pancreas, Liver, and Bones"}, 2)));
            boyStoryList.add(new Story(R.drawable.boyquiz6, true, new Options("Do you think Raj’s uncle was right?", new String[]{"1. Yes, body gets disfigured after organ donation\n", "2. No, it is a myth", "3. Not Sure"}, 2)));


            boyStoryList.add(new Story(R.drawable.hospitalboy17, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy18, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.boyquiz7, true, new Options("If I have a pledge card and I am in the hospital, will the doctor try to save me?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 1)));
            boyStoryList.add(new Story(R.drawable.boyquiz8, true, new Options("Can I donate organs if I’m sick?", new String[]{"1. Yes", "2. No", "3. Depends on Medical Conditions"}, 3)));


            boyStoryList.add(new Story(R.drawable.hospitalboy19, false, new Options("How long can organs and tissue survive once harvested till transplantation if preserved?", new String[]{"1. Match the following!"}, 1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy20, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy21, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy22, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy23, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy24, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy25, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy26, false, new Options("", new String[]{}, -1)));

            endIntro.add("So what do you think, Did I make the right decision by choosing to save lives through organ donation?");

            storyList = null;

            if (isABoyCharacter == 0)
                storyList = girlStoryList;
            else
                storyList = boyStoryList;

            score = 0;
            life = 3;
            count = 0;
        } else {
            storyList = (ArrayList<Story>) savedInstanceState.getSerializable(STORY_LIST);
            count = savedInstanceState.getInt(STORY_LIST_COUNT);
            isABoyCharacter = savedInstanceState.getInt(IS_A_BOY_CHAR);
            score = savedInstanceState.getInt(SCORE);
            life = savedInstanceState.getInt(LIFE_POINTS);
            endIntro = savedInstanceState.getStringArrayList(CHARACTER_INTRO_ARRAY);

        }

        showComicStrip();

    }

    private void showComicStrip() {
        if (life == 0)
            lifeEnds();
        else {
            nextButton.setVisibility(View.VISIBLE);
            storyImageView.setVisibility(View.VISIBLE);
            menuItemLinearLayout.setVisibility(View.VISIBLE);
            if (storyList.size() == count)
                ifGameEnds();
            else {
                storyImageView.setImageResource(storyList.get(count).getStoryImageIds());

                ObjectAnimator.ofFloat(storyImageView, View.ALPHA, 0.2f, 1.0f).setDuration(1000).start();
                if (storyList.get(count).getIS_QUESTION_STORY() == true) {
                    showQuestion(storyList.get(count).getOptions());
                }

                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count++;
                        showComicStrip();
                    }
                });
            }
        }
    }

    private void showQuestion(Options options) {
        final int correct_answer = options.correct_answer;
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        option1.setBackground(getResources().getDrawable(R.drawable.ripple));
        option2.setBackground(getResources().getDrawable(R.drawable.ripple));
        option3.setBackground(getResources().getDrawable(R.drawable.ripple));
        option4.setBackground(getResources().getDrawable(R.drawable.ripple));


        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);

        optionsLinearLayout.setVisibility(View.VISIBLE);

        nextButton.setVisibility(View.GONE);

        option1.setText(options.options_text[0]);
        option2.setText(options.options_text[1]);
        option3.setText(options.options_text[2]);
//        option4.setText(options.options_text[3]);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);

                if (correct_answer != 1) {
                    life = life - 1;
                    option1.setBackground(getResources().getDrawable(R.drawable.wrong_answer_bg));
                    vibe.vibrate(300);
                    if (correct_answer == 2)
                        option2.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else if (correct_answer == 3)
                        option3.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else
                        option4.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                } else {
                    option1.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    score = score + 10;
                    setScore();
                }

                if (life == 0)
                    lifeEnds();
                else {
                    setLife();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            optionsLinearLayout.setVisibility(View.GONE);

                            nextButton.setVisibility(View.VISIBLE);
                            count++;
                            showComicStrip();
                        }
                    }, 4000);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);

                if (correct_answer != 2) {
                    life = life - 1;
                    option2.setBackground(getResources().getDrawable(R.drawable.wrong_answer_bg));
                    vibe.vibrate(300);
                    if (correct_answer == 1)
                        option1.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else if (correct_answer == 3)
                        option3.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else
                        option4.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));

                } else {
                    option2.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    score = score + 10;
                    setScore();
                }

                if (life == 0)
                    lifeEnds();
                else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setLife();
                            optionsLinearLayout.setVisibility(View.GONE);

                            nextButton.setVisibility(View.VISIBLE);
                            count++;
                            showComicStrip();

                        }
                    }, 4000);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                if (correct_answer != 3) {
                    life = life - 1;
                    option3.setBackground(getResources().getDrawable(R.drawable.wrong_answer_bg));
                    vibe.vibrate(300);
                    if (correct_answer == 1)
                        option1.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else if (correct_answer == 2)
                        option2.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else
                        option4.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));


                } else {
                    option3.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    score = score + 10;
                    setScore();
                }

                if (life == 0)
                    lifeEnds();
                else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setLife();
                            optionsLinearLayout.setVisibility(View.GONE);

                            nextButton.setVisibility(View.VISIBLE);
                            count++;
                            showComicStrip();

                        }
                    }, 4000);
                }

            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                if (correct_answer != 4) {
                    life = life - 1;
                    option4.setBackground(getResources().getDrawable(R.drawable.wrong_answer_bg));
                    vibe.vibrate(300);
                    if (correct_answer == 1)
                        option1.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else if (correct_answer == 2)
                        option2.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    else
                        option3.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));


                } else {
                    option4.setBackground(getResources().getDrawable(R.drawable.correct_answer_bg));
                    score = score + 10;
                    setScore();
                }

                if (life == 0)
                    lifeEnds();
                else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setLife();
                            optionsLinearLayout.setVisibility(View.GONE);

                            nextButton.setVisibility(View.VISIBLE);
                            count++;
                            showComicStrip();

                        }
                    }, 4000);
                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle currentState) {
        super.onSaveInstanceState(currentState);
        currentState.putSerializable(IS_A_BOY_CHAR, isABoyCharacter);
        currentState.putSerializable(STORY_LIST, storyList);
        currentState.putSerializable(STORY_LIST_COUNT, count);
        currentState.putSerializable(SCORE, score);
        currentState.putSerializable(LIFE_POINTS, life);
        currentState.putSerializable(CHARACTER_INTRO_ARRAY, endIntro);
    }

    private void setScore() {
        scoreTextView.setText(String.valueOf(score));
    }

    private void setLife() {
        lifeTextView.setText(String.valueOf(life));
    }

    private void ifGameEnds() {
        nextButton.setVisibility(View.GONE);
        storyImageView.setVisibility(View.GONE);
        optionsLinearLayout.setVisibility(View.GONE);

        menuItemLinearLayout.setVisibility(View.GONE);
        scoreCardFrameLayout.setVisibility(View.VISIBLE);
        scoreCardTextView.setText(String.valueOf(score));
        scoreCardFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreCardFrameLayout.setVisibility(View.GONE);
                Intent myIntent = new Intent(StoryActivity.this, CharacterIntroActivity.class);
                myIntent.putExtra(CHARACTER_INTRO_ARRAY, endIntro);
                myIntent.putExtra(IS_LAST_SCREEN, 1);
                myIntent.putExtra(IS_A_BOY_CHAR, isABoyCharacter);
                StoryActivity.this.startActivity(myIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

    }

    private void lifeEnds() {
        vibe.vibrate(1000);
        nextButton.setVisibility(View.GONE);
        storyImageView.setVisibility(View.GONE);
        optionsLinearLayout.setVisibility(View.GONE);

        menuItemLinearLayout.setVisibility(View.GONE);
        lifeEndedRelativeLayout.setVisibility(View.VISIBLE);

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(StoryActivity.this, MainActivity.class);
                StoryActivity.this.startActivity(myIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        visitIgiftLifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(igiftLifeUrl));
                startActivity(i);
            }
        });

    }

}

