package com.example.mygradecalculator.ui.classes;

import java.util.ArrayList;

/**
 * This is a simple {java.Class} meant to represent information about
 * an academic class, not to be confused with
 * the {@link com.example.mygradecalculator.ui.classes.ClassesViewModel ClassesViewModel}
 * class, which has an entirely unrelated purpose.
 * @author Edwin
 */
public class ClassModel {//TODO: Add additional stats to track (ex: grades instead of GPA numbers)
    private String className;
    private double gpa;
    private ArrayList<Double> weights;
    private ArrayList<Double> weigavg;
    private Double av;
    private ArrayList<Boolean> added;

    public ClassModel(String className, double gpa) {
        this.className = className;
        this.gpa = gpa;
    }

    public ClassModel(String className, double gpa, ArrayList<Double> weigh,ArrayList<Double> avg, ArrayList<Boolean> addeds) {
        this.className = className;
        this.gpa = gpa;
        this.weights = weigh;
        this.weigavg = avg;
        this.added = addeds;
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

    public void setGPA(Double gpa) {
        this.gpa = gpa;
    }

    public ArrayList getWeights() {
        return this.weights;
    }

    public void setWeights(ArrayList gpa) {
        this.weights = gpa;
    }
     public void addWeights(Double weigh, Double Avg, Boolean Adds){
        this.weights.add(weigh);
        this.weigavg.add(Avg);
        this.added.add(Adds);
     }
     public Double calcGrade(){
        Double sum = 0.0;
        Double sum1 = 0.0;
        Double count = 0.0;
        for(int i = 0; i < this.weights.size(); i++){
            if (added.get(i) == true){

                Double x = this.weights.get(i) * this.weigavg.get(i);
                sum = sum + x;
                sum1 = sum1 + this.weights.get(i);

            }

        }
        this.av =  sum/sum1;
        return sum/sum1;

     }
     public Double gradeNeeded(String gra){
        Double sum = 0.0;
         for(int i = 0; i < this.weights.size(); i++){
             if (added.get(i) == false){
                 sum = sum +this.weights.get(i);


             }

         }
         Double curgra = calcGrade();
         Double over = 1-sum;
         Double curavg = curgra*over;
         if (gra.equals("A")){
             Double rem = .925 - curavg;
             return rem/sum;

         }
         else if (gra.equals("B")){
             Double rem = .825 - curavg;
             return rem/sum;

         }
         else if (gra.equals("C")){
             Double rem = .725 - curavg;
             return rem/sum;

         }
         else if (gra.equals("D")){
             Double rem = .625 - curavg;
             return rem/sum;

         }
         else {
             return 0.0;

         }


     }
     public String getGrade(){
        if (this.av >= .925){
            return "A ";
        }
        else if (this.av <.925 && this.av >=.825){
            return "B ";

        }
        else if (this.av <.825 && this.av >=.725){
            return "C";

        }
        else if (this.av <.725 && this.av >=.625){
            return "D";

        }
        else{
            return "F";

        }
    }





}
