package com.example.deepamgoel.quiz20.level_two;

public class LevelTwoModel {
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    Boolean attempted;

    LevelTwoModel(String question, String option1, String option2, String option3, String option14, Boolean attempted) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option14;
        this.attempted = attempted;
    }

}
