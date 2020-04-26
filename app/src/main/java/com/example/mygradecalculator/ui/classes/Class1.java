package com.example.mygradecalculator.ui.classes;

import java.util.ArrayList;

public class Class1 {
    private ClassModel k;
    private ArrayList john;



    public Class1(ClassModel john){
        this.k = john;
        this.john = new ArrayList();




    }
    public void addClass(ClassModel k){
        this.john.add(k);
    }
    public ArrayList getClasses(){
        ArrayList johnn = this.john;
        return johnn;
    }
    public Double calcGPA(){
        ArrayList<ClassModel> joe = this.getClasses();
        ArrayList<String> lis= new ArrayList<String>();
        for (int i = 0; i < joe.size();i++){
            ClassModel kon = joe.get(i);
            kon.calcGrade();
            lis.add(kon.getGrade());



        }
        Double sum = 0.0;
        for (int i = 0; i < lis.size();i++){
            if (lis.get(i).equals("A")){
                sum = sum + 4.0;

            }
            else if (lis.get(i).equals("B")){
                sum = sum + 3.0;

            }
            else if (lis.get(i).equals("C")){
                sum = sum + 2.0;

            }
            else if (lis.get(i).equals("D")){
                sum = sum + 1.0;

            }
            else {
                sum = sum + 0.0;

            }
        }
        return sum/lis.size();


    }
}
