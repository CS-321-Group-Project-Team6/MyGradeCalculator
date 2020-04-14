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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        classesViewModel =
                new ViewModelProvider(this).get(ClassesViewModel.class);
        classesInflater = inflater;
        View root = inflater.inflate(R.layout.fragment_classes, container, false);
        final TextView textView = root.findViewById(R.id.text_classes);
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
        /*final FloatingActionButton */classes_fab = view.findViewById(R.id.classes_fab);
        classes_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewClassItem();
            }
        });
        /*final RecyclerView */classesRecyclerView = view.findViewById(R.id.list);
        /*final MyClassAdapter */classesAdapter = new MyClassAdapter(view.getContext(), classList);
        /*final RecyclerView.LayoutManager */classesLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        classesRecyclerView.setLayoutManager(classesLayoutManager);
        classesRecyclerView.setAdapter(classesAdapter);
        //classesAdapter.addItem(classesRecyclerView, 1);
        classesAdapter.notifyDataSetChanged();

    }

    public void createNewClassItem() {
        classList.add(new ClassModel("Class_Name", 0.0));
        classesAdapter.notifyDataSetChanged();
    }

    public void createMultipleClassItems(int numberOfItems) {
        for(int i = numberOfItems; i > 0; i--) {
            createNewClassItem();
        }
    }
}
