package com.youth4work.CGPSC_2023.network.model;

import com.google.gson.annotations.SerializedName;

public class SubjectStats {

    @SerializedName("score")
    private double Score;
    @SerializedName("subject")
    private String Subject;
    @SerializedName("subjectID")
    private int SubjectID;

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }
}
