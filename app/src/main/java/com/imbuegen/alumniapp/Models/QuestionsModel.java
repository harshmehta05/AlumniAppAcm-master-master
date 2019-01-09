package com.imbuegen.alumniapp.Models;

import com.google.firebase.database.PropertyName;

public class QuestionsModel {


    @PropertyName("question")
    private String question;
    @PropertyName("answer")
    private String answer;

    QuestionsModel() { }


    public QuestionsModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
