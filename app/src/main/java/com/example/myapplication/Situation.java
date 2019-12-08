package com.example.myapplication;

public class Situation {
    Situation[] direction;
    String subject, text;
    boolean alive;
    public Situation(String subject, String text, int variants) {
        this.subject = subject;
        this.text = text;
        direction = new Situation[variants];
    }
}
