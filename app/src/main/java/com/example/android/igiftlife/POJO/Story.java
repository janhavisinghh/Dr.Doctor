package com.example.android.igiftlife.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class Story implements Parcelable {


    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };
    private int story_image_id;
    private Boolean IS_QUESTION_STORY;
    private Options options;

    public Story(int story_image_id, Boolean IS_QUESTION_STORY, Options options) {
        this.story_image_id = story_image_id;
        this.IS_QUESTION_STORY = IS_QUESTION_STORY;
        this.options = options;
    }

    private Story(Parcel in) {
        story_image_id = in.readInt();
        byte tmpIS_QUESTION_STORY = in.readByte();
        IS_QUESTION_STORY = tmpIS_QUESTION_STORY == 0 ? null : tmpIS_QUESTION_STORY == 1;
        options = in.readParcelable(Options.class.getClassLoader());
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(story_image_id);
        dest.writeValue(options);
        dest.writeByte((byte) (IS_QUESTION_STORY ? 1 : 0));
    }
}