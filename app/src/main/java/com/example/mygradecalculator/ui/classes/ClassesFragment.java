package com.example.mygradecalculator.ui.classes;

import android.os.Bundle;
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
import com.example.mygradecalculator.ui.classes.ClassModel;

import com.example.mygradecalculator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

    //TODO: Reimplement saving user information using Android Bundles
    //TODO: Fix TextInput layout to look neater
    //TODO: Look in to using a list view that's less resource intensive
    //TODO: Implement a method to retrieve the information given for processing/calculating
    //TODO: Implement method to remove items
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        classesViewModel =
                new ViewModelProvider(this).get(ClassesViewModel.class);

        classesInflater = inflater;
        View root = inflater.inflate(R.layout.fragment_classes, container, false);
        /*final TextView */textView = root.findViewById(R.id.text_classes);
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*TODO: Not sure if I need these "final" keywords so im leaving them commented out for now*/
        /*final FloatingActionButton */classes_fab = view.findViewById(R.id.classes_fab);
        classes_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Removes the fragment text once the list becomes populated, via pressing the FAB
                if(textView.getVisibility() == TextView.VISIBLE)
                    textView.setVisibility(TextView.GONE);

                createNewClassItem();
            }
        });
        /*TODO: Not sure if I need these "final" keywords so im leaving them commented out for now*/
        /*final RecyclerView */classesRecyclerView = view.findViewById(R.id.list);
        /*final MyClassAdapter */classesAdapter = new MyClassAdapter(view.getContext(), classList);
        /*final RecyclerView.LayoutManager */classesLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        classesRecyclerView.setLayoutManager(classesLayoutManager);
        classesRecyclerView.setAdapter(classesAdapter);
        createMultipleClassItems(10);

    }

    //TODO: Set a limit to the number of classes the user can make
    //Creates a single ClassModel to add as an item in to the list
    private void createNewClassItem() {
        classList.add(new ClassModel("Class Name", 0.0));
        classesAdapter.notifyDataSetChanged(); //This function is necessary to call after any changes to the list
                                               //are made. Otherwise changes wont show up.
    }
    //Creates a specified number of items to the list. This is mainly for testing purposes
    private void createMultipleClassItems(int numberOfItems) {
        for(int i = numberOfItems; i > 0; i--) {
            createNewClassItem();
        }
    }
}
