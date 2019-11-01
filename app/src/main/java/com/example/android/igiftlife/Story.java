package com.example.android.igiftlife;

import java.io.Serializable;

public class Story implements Serializable {


    private int story_image_id;
    private Boolean IS_QUESTION_STORY = false;
    private Options options;


    public Story(int story_image_id, Boolean IS_QUESTION_STORY, Options options) {
        this.story_image_id = story_image_id;
        this.IS_QUESTION_STORY = IS_QUESTION_STORY;
        this.options = options;
    }

    public int getStoryImageIds() {

        return story_image_id;
    }


    public Boolean getIS_QUESTION_STORY() {

        return IS_QUESTION_STORY;
    }

    public void setIS_QUESTION_STORY(Boolean IS_QUESTION_STORY) {
        this.IS_QUESTION_STORY = IS_QUESTION_STORY;
    }

    public void setStory_image_ids(int story_image_id) {

        this.story_image_id = story_image_id;
    }

    public Options getOptions() {

        return options;
    }

    public void setOptions(Options options) {

        this.options = options;
    }


}