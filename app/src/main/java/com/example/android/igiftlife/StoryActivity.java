package com.example.android.igiftlife;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity {

    private int count = 0;
    private int score = 0;
    private ArrayList<Story> girlStoryList;
    private ArrayList<Story> boyStoryList;
    private ArrayList<Story> storyList;
    private Button nextButton;
    private ImageView storyImageView;
    private Button option1;
    private Button option2;
    private Button option3;
    private Vibrator vibe;
    private Handler handler;
    private int isABoyCharacter;
    private String IS_A_BOY_CHAR = "IS_A_BOY_CHAR";
    private String STORY_LIST = "STORY_LIST";
    private String STORY_LIST_COUNT = "STORY_LIST_COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


        girlStoryList = new ArrayList<>();
        boyStoryList = new ArrayList<>();
        storyList = new ArrayList<>();

        nextButton = findViewById(R.id.nextStoryButton);
        option1 = (Button) findViewById(R.id.mcq_option_1);
        option2 = (Button) findViewById(R.id.mcq_option_2);
        option3 = (Button) findViewById(R.id.mcq_option_3);
        storyImageView = findViewById(R.id.comicStripIv);
        handler = new Handler();

        if(savedInstanceState == null) {
            isABoyCharacter = getIntent().getIntExtra("IS_A_BOY_CHAR", 0);

            girlStoryList.add(new Story(R.drawable.homegirl1, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.homegirl2, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.homegirl3, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl1, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl2, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl3, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl4, true, new Options("Can Organs be donated only to family members?", new String[]{"1. No, Organs are donated to patients on the waiting list. And can be donated to family members only if it is living donation.", "2.Yes, organs can be donated only within the family.", "3. Not Sure"}, 1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl5, true, new Options("Should it not be Kabeer’s choice if he wants to donate his organs or not? But now who will decide if Kabeer’s organs can be donated?", new String[]{"1. Doctor", "2. Family", "3. He can not donate organs now."}, 2)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl6, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl7, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl8, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl9, true, new Options("What organs can he successfully donate after being brain dead?", new String[]{"1. Heart, Kidneys, Liver, and Pancreas", "2. Heart, Skin, Liver and Brain", "3. Kidneys, Pancreas, Liver, and Lungs"}, 1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl10, true, new Options("What is the minimum age to register as an organ donor?", new String[]{"1. 18", "2. 25", "3. No age bar!!"}, 3)));
            girlStoryList.add(new Story(R.drawable.girlquiz1, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.girlquiz2, false, new Options("", new String[]{}, -1)));

            girlStoryList.add(new Story(R.drawable.hospitalgirl11, false, new Options("Let's play a quiz on Organ Donation?", new String[]{"1. OKAY!"}, 1)));
            girlStoryList.add(new Story(R.drawable.hospitalgirl12, false, new Options("", new String[]{}, -1)));
            girlStoryList.add(new Story(R.drawable.girlquiz3, true, new Options("Does donating organs cost money?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 1)));
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
            boyStoryList.add(new Story(R.drawable.hospitalboy9, true, new Options("What organs can he successfully donate after being brain dead?", new String[]{"1. Heart, Kidneys, Liver, and Pancreas", "2. Heart, Skin, Liver and Brain", "3. Kidneys, Pancreas, Liver, and Lungs"}, 1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy10, true, new Options("What is the minimum age to register as an organ donor?", new String[]{"1. 18", "2. 25", "3. No age bar!!"}, 3)));
            boyStoryList.add(new Story(R.drawable.boyquiz1, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.boyquiz2, false, new Options("", new String[]{}, -1)));

            boyStoryList.add(new Story(R.drawable.hospitalboy11, false, new Options("Let's play a quiz on Organ Donation?", new String[]{"1. OKAY!"}, 1)));
            boyStoryList.add(new Story(R.drawable.hospitalboy12, false, new Options("", new String[]{}, -1)));
            boyStoryList.add(new Story(R.drawable.boyquiz3, true, new Options("Does donating organs cost money?", new String[]{"1. YES", "2. NO", "3. Not Sure"}, 1)));
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

            if (isABoyCharacter == 0)
                storyList = girlStoryList;
            else
                storyList = boyStoryList;
        }
        else{
            storyList = (ArrayList<Story>) savedInstanceState.getSerializable(STORY_LIST);
            count = savedInstanceState.getInt(STORY_LIST_COUNT);
            isABoyCharacter = savedInstanceState.getInt(IS_A_BOY_CHAR);
        }

        showComicStrip();

    }

    private void showComicStrip() {
        storyImageView.setImageResource(storyList.get(count).getStoryImageIds());
        ObjectAnimator.ofFloat(storyImageView, View.ALPHA, 0.2f, 1.0f).setDuration(1000).start();
        if (storyList.get(count).getIS_QUESTION_STORY() == true) {
            showQuestion(storyList.get(count).getOptions());
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showComicStrip();
                    }
                },200);
            }
        });
    }

    private void showQuestion(Options options) {
        final int correct_answer = options.correct_answer;
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        option1.setBackground(getResources().getDrawable(R.drawable.ripple));
        option2.setBackground(getResources().getDrawable(R.drawable.ripple));
        option3.setBackground(getResources().getDrawable(R.drawable.ripple));

        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);

        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.GONE);

        option1.setText(options.options_text[0]);
        option2.setText(options.options_text[1]);
        option3.setText(options.options_text[2]);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                if (correct_answer != 1) {
                    option1.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                    vibe.vibrate(300);
                    if (correct_answer == 2)
                        option2.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                    else
                        option3.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                }
                else
                    option1.setBackgroundColor(getResources().getColor(R.color.correctAnswer));

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        nextButton.setVisibility(View.VISIBLE);
                        count++;
                        showComicStrip();
                    }
                }, 2000);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                if (correct_answer != 2) {
                    option2.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                    vibe.vibrate(300);
                    if (correct_answer == 1)
                        option1.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                    else
                        option3.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                }
                else
                    option2.setBackgroundColor(getResources().getColor(R.color.correctAnswer));

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        nextButton.setVisibility(View.VISIBLE);
                        count++;
                        showComicStrip();
                    }
                }, 2000);

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                if (correct_answer != 3) {
                    option3.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                    vibe.vibrate(300);
                    if (correct_answer == 1)
                        option1.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                    else
                        option2.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                }
                else
                    option3.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        nextButton.setVisibility(View.VISIBLE);
                        count++;
                        showComicStrip();
                    }
                }, 2000);

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle currentState) {
        super.onSaveInstanceState(currentState);
        currentState.putSerializable(IS_A_BOY_CHAR, isABoyCharacter);
        currentState.putSerializable(STORY_LIST, storyList);
        currentState.putSerializable(STORY_LIST_COUNT, count);
    }

}

