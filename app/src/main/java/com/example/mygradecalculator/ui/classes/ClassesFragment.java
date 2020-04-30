package com.example.mygradecalculator.ui.classes;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mygradecalculator.adapters.MyClassAdapter;

import com.example.mygradecalculator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ClassesFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener{

    private ClassesViewModel classesViewModel;
    private LayoutInflater classesInflater;

    private ArrayList<ClassModel> classList;
    private FloatingActionButton classes_fab;
    private RecyclerView classesRecyclerView;
    private MyClassAdapter classesAdapter;
    private RecyclerView.LayoutManager classesLayoutManager;
    private TextView textView;
    private ViewGroup classesContainer;
    private View root;

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

    private EditText className;
    private int classGrade;

    private ScrollView parent;
    private Button addClass;

    //TODO: Reimplement saving user information using Android Bundles
    //TODO: Fix TextInput layout to look neater
    //TODO: Look in to using a list view that's less resource intensive
    //TODO: Implement a method to retrieve the information given for processing/calculating
    //TODO: Implement method to remove items
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        classesViewModel =
                new ViewModelProvider(this).get(ClassesViewModel.class);
        classesContainer = container;
        classesInflater = inflater;
        root = inflater.inflate(R.layout.fragment_classes, container, false);
        textView = root.findViewById(R.id.text_classes);
        classesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
            }
        });
        classList = new ArrayList<>();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        classes_fab = view.findViewById(R.id.classes_fab);
        classes_fab.setOnClickListener(this);

        classesRecyclerView = view.findViewById(R.id.recycler_view_classes);
        classesAdapter = new MyClassAdapter(view.getContext(), classList);
        classesLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        classesRecyclerView.setLayoutManager(classesLayoutManager);
        classesRecyclerView.setAdapter(classesAdapter);
        //createMultipleClassItems(25);
    }

    //TODO: Set a limit to the number of classes the user can make
    //Creates a single ClassModel to add as an item in to the list
    private void createNewClassItem() {
        //Removes the fragment text once the list becomes populated, via pressing the FAB
        if(textView.getVisibility() == TextView.VISIBLE)
            textView.setVisibility(TextView.GONE);

        if(classList.size() < 18) {//I arbitrarily chose 18 classes as the max
                                   //since these are supposed to be ongoing academic classes
            classesInflater.inflate(R.layout.add_class_menu, (ViewGroup) root);
            classes_fab.setVisibility(FloatingActionButton.GONE);
            initAddClass();
            //classList.add(new ClassModel("", 0.0));
            //classesAdapter.notifyDataSetChanged(); //This function is necessary to call after any changes to the list
        }                                          //are made. Otherwise changes wont show up in the emulator view window
        else{
            //textView.setVisibility(TextView.VISIBLE);
            Snackbar.make(root, "No more classes may be added! The max is 18!", 3000).show();
        }
    }
    //Creates a specified number of items to the list. This is mainly for testing purposes
    private void createMultipleClassItems(int numberOfItems) {
        for(int i = numberOfItems; i > 0; i--) {
            createNewClassItem();
        }
    }

    public MyClassAdapter.ViewHolder removeClassItem() {
        return null;
    }

    @Override
    public void onClick(View v) {
        String text;
        switch(v.getId()) {
            case R.id.classes_fab:
                createNewClassItem();
                break;
            case R.id.addClassAdd1:
                if (grade1.getText().length() != 0) {
                    text = gradeTxt1.getText() + " " + grade1.getText() + "%";
                    gradeTxt1.setText(text);
                    grades1.add(Integer.parseInt(String.valueOf(grade1.getText())));
                }
                break;
            case R.id.addClassClear1:
                gradeTxt1.setText("");
                grades1.clear();
                break;
            case R.id.addClassAdd2:
                if (grade2.getText().length() != 0) {
                    text = gradeTxt2.getText() + " " + grade2.getText() + "%";
                    gradeTxt2.setText(text);
                    grades2.add(Integer.parseInt(String.valueOf(grade2.getText())));
                }
                break;
            case R.id.addClassClear2:
                gradeTxt2.setText("");
                grades2.clear();
                break;
            case R.id.addClassAdd3:
                if (grade3.getText().length() != 0) {
                    text = gradeTxt3.getText() + " " + grade3.getText() + "%";
                    gradeTxt3.setText(text);
                    grades3.add(Integer.parseInt(String.valueOf(grade3.getText())));
                }
                break;
            case R.id.addClassClear3:
                gradeTxt3.setText("");
                grades3.clear();
                break;
            case R.id.addClassAdd4:
                if (grade4.getText().length() != 0) {
                    text = gradeTxt4.getText() + " " + grade4.getText() + "%";
                    gradeTxt4.setText(text);
                    grades4.add(Integer.parseInt(String.valueOf(grade4.getText())));
                }
                break;
            case R.id.addClassClear4:
                gradeTxt4.setText("");
                grades4.clear();
                break;
            case R.id.addClassAdd5:
                if (grade5.getText().length() != 0) {
                    text = gradeTxt5.getText() + " " + grade5.getText() + "%";
                    gradeTxt5.setText(text);
                    grades5.add(Integer.parseInt(String.valueOf(grade5.getText())));
                }
                break;
            case R.id.addClassClear5:
                gradeTxt5.setText("");
                grades5.clear();
                break;

            case R.id.addClass:
                classGrade = calculate();
                parent.setVisibility(ScrollView.GONE);
                classesInflater.inflate(R.layout.fragment_classes, (ViewGroup) root);
                classes_fab.setVisibility(FloatingActionButton.GONE);
                classList.add(new ClassModel("", 0.0));
                classesAdapter.notifyDataSetChanged();
                break;
        }
    }

    public void initAddClass() {
        className = root.findViewById(R.id.addClassName);
        gradeTxt1 = root.findViewById(R.id.addClassGradesTxt1);
        gradeTxt1.setMovementMethod(new ScrollingMovementMethod());
        grade1 = root.findViewById(R.id.addClassGrade1);
        grade1.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        weight1 = root.findViewById(R.id.addClassWeight1);
        weight1.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        Button addGrade1 = root.findViewById(R.id.addClassAdd1);
        addGrade1.setOnClickListener(this);
        Button clearGrade1 = root.findViewById(R.id.addClassClear1);
        clearGrade1.setOnClickListener(this);

        gradeTxt2 = root.findViewById(R.id.addClassGradesTxt2);
        gradeTxt2.setMovementMethod(new ScrollingMovementMethod());
        grade2 = root.findViewById(R.id.addClassGrade2);
        grade2.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        weight2 = root.findViewById(R.id.addClassWeight2);
        weight2.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        Button addGrade2 = root.findViewById(R.id.addClassAdd2);
        addGrade2.setOnClickListener(this);
        Button clearGrade2 = root.findViewById(R.id.addClassClear2);
        clearGrade2.setOnClickListener(this);

        gradeTxt3 = root.findViewById(R.id.addClassGradesTxt3);
        gradeTxt3.setMovementMethod(new ScrollingMovementMethod());
        grade3 = root.findViewById(R.id.addClassGrade3);
        grade3.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        weight3 = root.findViewById(R.id.addClassWeight3);
        weight3.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        Button addGrade3 = root.findViewById(R.id.addClassAdd3);
        addGrade3.setOnClickListener(this);
        Button clearGrade3 = root.findViewById(R.id.addClassClear3);
        clearGrade3.setOnClickListener(this);

        gradeTxt4 = root.findViewById(R.id.addClassGradesTxt4);
        gradeTxt4.setMovementMethod(new ScrollingMovementMethod());
        grade4 = root.findViewById(R.id.addClassGrade4);
        grade4.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        weight4 = root.findViewById(R.id.addClassWeight4);
        weight4.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        Button addGrade4 = root.findViewById(R.id.addClassAdd4);
        addGrade4.setOnClickListener(this);
        Button clearGrade4 = root.findViewById(R.id.addClassClear4);
        clearGrade4.setOnClickListener(this);

        gradeTxt5 = root.findViewById(R.id.addClassGradesTxt5);
        gradeTxt5.setMovementMethod(new ScrollingMovementMethod());
        grade5 = root.findViewById(R.id.addClassGrade5);
        grade5.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        weight5 = root.findViewById(R.id.addClassWeight5);
        weight5.setOnFocusChangeListener((View.OnFocusChangeListener) this);
        Button addGrade5 = root.findViewById(R.id.addClassAdd5);
        addGrade5.setOnClickListener(this);
        Button clearGrade5 = root.findViewById(R.id.addClassClear5);
        clearGrade5.setOnClickListener(this);

        addClass = root.findViewById(R.id.addClass);
        addClass.setOnClickListener(this);
        parent = root.findViewById(R.id.add_class_parent);
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

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            hideKeyboard();
    }

    private void hideKeyboard() {
        View v = getView();
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity()
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
