package com.example.mygradecalculator.ui.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.mygradecalculator.R;
import java.util.ArrayList;

public class CalculatorFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    private TextView gradeTxt1;
    private EditText grade1;
    private EditText weight1;
    private ArrayList<Integer> grades1 = new ArrayList<Integer>();

    private TextView gradeTxt2;
    private EditText grade2;
    private EditText weight2;
    private ArrayList<Integer> grades2 = new ArrayList<Integer>();

    private TextView gradeTxt3;
    private EditText grade3;
    private EditText weight3;
    private ArrayList<Integer> grades3 = new ArrayList<Integer>();

    private TextView gradeTxt4;
    private EditText grade4;
    private EditText weight4;
    private ArrayList<Integer> grades4 = new ArrayList<Integer>();

    private TextView gradeTxt5;
    private EditText grade5;
    private EditText weight5;
    private ArrayList<Integer> grades5 = new ArrayList<Integer>();

    private TextView overallGrade;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        gradeTxt1 = root.findViewById(R.id.gradeTxt1);
        gradeTxt1.setMovementMethod(new ScrollingMovementMethod());
        grade1 = root.findViewById(R.id.grade1);
        grade1.setOnFocusChangeListener(this);
        weight1 = root.findViewById(R.id.weight1);
        weight1.setOnFocusChangeListener(this);
        Button addGrade1 = root.findViewById(R.id.addGrade1);
        addGrade1.setOnClickListener(this);
        Button clearGrade1 = root.findViewById(R.id.clearGrade1);
        clearGrade1.setOnClickListener(this);

        gradeTxt2 = root.findViewById(R.id.gradeTxt2);
        gradeTxt2.setMovementMethod(new ScrollingMovementMethod());
        grade2 = root.findViewById(R.id.grade2);
        grade2.setOnFocusChangeListener(this);
        weight2 = root.findViewById(R.id.weight2);
        weight2.setOnFocusChangeListener(this);
        Button addGrade2 = root.findViewById(R.id.addGrade2);
        addGrade2.setOnClickListener(this);
        Button clearGrade2 = root.findViewById(R.id.clearGrade2);
        clearGrade2.setOnClickListener(this);

        gradeTxt3 = root.findViewById(R.id.gradeTxt3);
        gradeTxt3.setMovementMethod(new ScrollingMovementMethod());
        grade3 = root.findViewById(R.id.grade3);
        grade3.setOnFocusChangeListener(this);
        weight3 = root.findViewById(R.id.weight3);
        weight3.setOnFocusChangeListener(this);
        Button addGrade3 = root.findViewById(R.id.addGrade3);
        addGrade3.setOnClickListener(this);
        Button clearGrade3 = root.findViewById(R.id.clearGrade3);
        clearGrade3.setOnClickListener(this);

        gradeTxt4 = root.findViewById(R.id.gradeTxt4);
        gradeTxt4.setMovementMethod(new ScrollingMovementMethod());
        grade4 = root.findViewById(R.id.grade4);
        grade4.setOnFocusChangeListener(this);
        weight4 = root.findViewById(R.id.weight4);
        weight4.setOnFocusChangeListener(this);
        Button addGrade4 = root.findViewById(R.id.addGrade4);
        addGrade4.setOnClickListener(this);
        Button clearGrade4 = root.findViewById(R.id.clearGrade4);
        clearGrade4.setOnClickListener(this);

        gradeTxt5 = root.findViewById(R.id.gradeTxt5);
        gradeTxt5.setMovementMethod(new ScrollingMovementMethod());
        grade5 = root.findViewById(R.id.grade5);
        grade5.setOnFocusChangeListener(this);
        weight5 = root.findViewById(R.id.weight5);
        weight5.setOnFocusChangeListener(this);
        Button addGrade5 = root.findViewById(R.id.addGrade5);
        addGrade5.setOnClickListener(this);
        Button clearGrade5 = root.findViewById(R.id.clearGrade5);
        clearGrade5.setOnClickListener(this);

        overallGrade = root.findViewById(R.id.overallGrade);
        Button calculateGrade = root.findViewById(R.id.calculateGrade);
        calculateGrade.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        String text;
        switch(v.getId()) {
            case R.id.addGrade1:
                if (grade1.getText().length() != 0) {
                    text = gradeTxt1.getText() + " " + grade1.getText() + "%";
                    gradeTxt1.setText(text);
                    grades1.add(Integer.parseInt(String.valueOf(grade1.getText())));
                }
                break;
            case R.id.clearGrade1:
                gradeTxt1.setText("");
                grades1.clear();
                break;
            case R.id.addGrade2:
                if (grade2.getText().length() != 0) {
                    text = gradeTxt2.getText() + " " + grade2.getText() + "%";
                    gradeTxt2.setText(text);
                    grades2.add(Integer.parseInt(String.valueOf(grade2.getText())));
                }
                break;
            case R.id.clearGrade2:
                gradeTxt2.setText("");
                grades2.clear();
                break;
            case R.id.addGrade3:
                if (grade3.getText().length() != 0) {
                    text = gradeTxt3.getText() + " " + grade3.getText() + "%";
                    gradeTxt3.setText(text);
                    grades3.add(Integer.parseInt(String.valueOf(grade3.getText())));
                }
                break;
            case R.id.clearGrade3:
                gradeTxt3.setText("");
                grades3.clear();
                break;
            case R.id.addGrade4:
                if (grade4.getText().length() != 0) {
                    text = gradeTxt4.getText() + " " + grade4.getText() + "%";
                    gradeTxt4.setText(text);
                    grades4.add(Integer.parseInt(String.valueOf(grade4.getText())));
                }
                break;
            case R.id.clearGrade4:
                gradeTxt4.setText("");
                grades4.clear();
                break;
            case R.id.addGrade5:
                if (grade5.getText().length() != 0) {
                    text = gradeTxt5.getText() + " " + grade5.getText() + "%";
                    gradeTxt5.setText(text);
                    grades5.add(Integer.parseInt(String.valueOf(grade5.getText())));
                }
                break;
            case R.id.clearGrade5:
                gradeTxt5.setText("");
                grades5.clear();
                break;
            case R.id.calculateGrade:
                text = "Grade:  " + calculate() + "%";
                overallGrade.setText(text);
                break;
        }
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            hideKeyboard();
    }

    private int calculate() {
        /*
        values:
        grades1 holds values for weight1, and so on.
        grades1-5 are ArrayLists
         */
        int grade = 0;
        double average = 0;

        if (weight1.getText().length() != 0) {
            for (int n : grades1)
                average += n;
            average /= grades1.size();
            average /= 100;
            grade += (Integer.parseInt(String.valueOf(weight1.getText())) * average);
            average = 0;
        }
        if (weight2.getText().length() != 0) {
            for (int n : grades2)
                average += n;
            average /= grades2.size();
            average /= 100;
            grade += (Integer.parseInt(String.valueOf(weight2.getText())) * average);
            average = 0;
        }
        if (weight3.getText().length() != 0) {
            for (int n : grades3)
                average += n;
            average /= grades3.size();
            average /= 100;
            grade += (Integer.parseInt(String.valueOf(weight3.getText())) * average);
            average = 0;
        }
        if (weight4.getText().length() != 0) {
            for (int n : grades4)
                average += n;
            average /= grades4.size();
            average /= 100;
            grade += (Integer.parseInt(String.valueOf(weight4.getText())) * average);
            average = 0;
        }
        if (weight5.getText().length() != 0) {
            for (int n : grades5)
                average += n;
            average /= grades5.size();
            average /= 100;
            grade += (Integer.parseInt(String.valueOf(weight5.getText())) * average);
        }

        return grade;
    }

    private void hideKeyboard() {
        View v = getView();
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity()
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }


}