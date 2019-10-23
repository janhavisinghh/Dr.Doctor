package com.example.android.igiftlife;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StoryActivity extends AppCompatActivity {

    private int count=0;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        final Handler handler = new Handler();

        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        final Integer[] storyImageIds = {
                R.drawable.hospital1,
                R.drawable.hospital2,
                R.drawable.hospital3,
                R.drawable.hospital4,
                R.drawable.hospital5,
                R.drawable.hospital6,
                R.drawable.hospital7,
                R.drawable.hospital8,
                R.drawable.hospital9,
                R.drawable.hosiptal10,
                R.drawable.hospital11,
                R.drawable.hospital12,
                R.drawable.hospital13,
                R.drawable.hospital14,
                R.drawable.hospital15,
                R.drawable.hospital16,
                R.drawable.hospital17,
                R.drawable.hospital18
        };

        final Button nextButton = findViewById(R.id.nextStoryButton);
        final ImageView storyImageView = findViewById(R.id.comicStripIv);
        final Button option1 = findViewById(R.id.mcq_option_1);
        final Button option2 = findViewById(R.id.mcq_option_2);
        final Button option3 = findViewById(R.id.mcq_option_3);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storyImageView.setImageResource(storyImageIds[count]);
                count++;

                if(count==9){
                    option1.setVisibility(View.VISIBLE);
                    option2.setVisibility(View.VISIBLE);
                    option3.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.GONE);
                    option1.setText("1. 18");
                    option2.setText("2. 25");
                    option3.setText("3. No age bar!!");
                    option1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option1.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                                }
                            }, 10000);
                            option1.setVisibility(View.GONE);
                            vibe.vibrate(200);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);
                        }
                    });
                    option2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option2.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                                }
                            }, 10000);
                            vibe.vibrate(200);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);

                        }
                    });
                    option3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option3.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                                }
                            }, 5000);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);
                            score +=10;
                        }
                    });
                }
                else if(count == 14){
                    option1.setVisibility(View.VISIBLE);
                    option2.setVisibility(View.VISIBLE);
                    option1.setBackground(getResources().getDrawable(R.drawable.ripple));
                    option2.setBackground(getResources().getDrawable(R.drawable.ripple));
                    nextButton.setVisibility(View.GONE);
                    option1.setText("1. YES");
                    option2.setText("2. NO");

                    option1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option1.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                                }
                            }, 5000);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);
                            score +=10;
                        }
                    });
                    option2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option2.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                                }
                            }, 5000);
                            vibe.vibrate(200);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);

                        }
                    });
                }

                else if(count == 16){
                    option1.setVisibility(View.VISIBLE);
                    option2.setVisibility(View.VISIBLE);
                    option1.setBackground(getResources().getDrawable(R.drawable.ripple));
                    option2.setBackground(getResources().getDrawable(R.drawable.ripple));
                    nextButton.setVisibility(View.GONE);
                    option1.setText("1. YES");
                    option2.setText("2. NO");

                    option1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option1.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                                }
                            }, 5000);                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);
                            score +=10;
                        }
                    });
                    option2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option2.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                                }
                            }, 5000);
                            vibe.vibrate(200);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);

                        }
                    });
                }

                else if(count == 17) {
                    option1.setVisibility(View.VISIBLE);
                    option2.setVisibility(View.VISIBLE);
                    option1.setBackground(getResources().getDrawable(R.drawable.ripple));
                    option2.setBackground(getResources().getDrawable(R.drawable.ripple));
                    nextButton.setVisibility(View.GONE);
                    option1.setText("1. YES");
                    option2.setText("2. NO");

                    option1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option1.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                                }
                            }, 5000);                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);
                            score +=10;
                        }
                    });
                    option2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option2.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                                }
                            }, 5000);
                            vibe.vibrate(200);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            storyImageView.setImageResource(storyImageIds[count]);
                            nextButton.setVisibility(View.VISIBLE);

                        }
                    });
                }

                else if(count == 18){
                    option1.setVisibility(View.VISIBLE);
                    option2.setVisibility(View.VISIBLE);
                    option1.setBackground(getResources().getDrawable(R.drawable.ripple));
                    option2.setBackground(getResources().getDrawable(R.drawable.ripple));
                    nextButton.setVisibility(View.GONE);
                    option1.setText("1. YES");
                    option2.setText("2. NO");

                    option1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option1.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                                }
                            }, 5000);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            nextButton.setVisibility(View.GONE);
                            score +=10;
                            storyImageView.setImageDrawable(getResources().getDrawable(R.drawable.scorecard));

                        }
                    });
                    option2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something after 5s = 5000ms
                                    option2.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
                                }
                            }, 5000);
                            vibe.vibrate(200);
                            option1.setVisibility(View.GONE);
                            option2.setVisibility(View.GONE);
                            option3.setVisibility(View.GONE);
                            nextButton.setVisibility(View.GONE);
                            storyImageView.setImageDrawable(getResources().getDrawable(R.drawable.scorecard));


                        }
                    });
                    storyImageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                }
            }
        });



    }
}
