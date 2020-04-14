package com.example.mygradecalculator.ui.classes;

public class ClassModel {
    private String className;
    private double gpa;

    public ClassModel(String className, double gpa) {
        this.className = className;
        this.gpa = gpa;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getGPA() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

}
