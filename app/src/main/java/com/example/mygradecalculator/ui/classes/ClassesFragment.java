package com.example.mygradecalculator.ui.classes;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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

public class ClassesFragment extends Fragment {

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
        classes_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewClassItem();
            }
        });

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
            classesInflater.inflate(R.layout.add_class_menu, (ViewGroup)root);
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
}
