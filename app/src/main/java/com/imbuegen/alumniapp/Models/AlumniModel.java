package com.imbuegen.alumniapp.Models;

import com.google.firebase.database.PropertyName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlumniModel   implements Serializable {

    @PropertyName("Name")
    private String alumniName;

    @PropertyName("Position")
    private String position;

    @PropertyName("JoinDate")
    private String joinDate;

    private String company;







    @PropertyName("Questions")
    private ArrayList<QuestionsModel> questionsList;



    

    public AlumniModel() { }



    public String getAlumniName() {
        return alumniName;
    }

    public void setAlumniName(String alumniName) {
        this.alumniName = alumniName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<QuestionsModel> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(ArrayList<QuestionsModel> questionsList) {
        this.questionsList = questionsList;
    }
}
