package com.example.android.igiftlife.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class Options implements Parcelable {
    public static final Creator<Options> CREATOR = new Creator<Options>() {
        @Override
        public Options createFromParcel(Parcel in) {
            return new Options(in);
        }

        @Override
        public Options[] newArray(int size) {
            return new Options[size];
        }
    };
    private String[] options_text;
    private Integer correct_answer;
    private String question;

    public Options(String question, String[] options_text, Integer correct_answer) {
        this.question = question;
        this.options_text = options_text;
        this.correct_answer = correct_answer;
    }

    private Options(Parcel in) {
        options_text = in.createStringArray();
        if (in.readByte() == 0) {
            correct_answer = null;
        } else {
            correct_answer = in.readInt();
        }
        question = in.readString();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptionText() {
        return options_text;
    }

    public Integer getCorrectAnswer() {
        return correct_answer;
    }

    public void setCorrectAnswer(Integer correct_answer) {
        this.correct_answer = correct_answer;
    }

    public void setOptionsText(String[] option_text) {
        this.options_text = option_text;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(correct_answer);
        parcel.writeString(question);
        parcel.writeStringArray(options_text);
    }
}
