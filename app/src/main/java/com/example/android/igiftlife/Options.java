package com.example.android.igiftlife;

public class Options {
    String[] options_text;
    Integer correct_answer;
    String question;

    public Options(String question, String[] options_text, Integer correct_answer) {
        this.question = question;
        this.options_text = options_text;
        this.correct_answer = correct_answer;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String[] getOptionText() {
        return options_text;
    }

    public Integer getCorrectAnswer() {
        return correct_answer;
    }

    public void setOptionsText(String[] option_text){
        this.options_text = option_text;
    }

    public void setCorrectAnswer(Integer correct_answer){
        this.correct_answer = correct_answer;
    }


}
