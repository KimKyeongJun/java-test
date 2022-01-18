package com.kkj.javatest;

public class Study {

    private StudyStatus status;


    int limit;

    public Study(int limit){
        if ( limit < 0 ) {
            throw new IllegalArgumentException("limit은 0보다 커야한다.");
        }
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }
    public int getLimit() {
        return limit;
    }
}