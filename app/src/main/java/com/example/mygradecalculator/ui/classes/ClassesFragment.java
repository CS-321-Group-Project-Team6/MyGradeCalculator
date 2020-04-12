package com.example.mygradecalculator.ui.classes;

import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygradecalculator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ClassesFragment extends Fragment {

    private ClassesViewModel classesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        classesViewModel =
                new ViewModelProvider(this).get(ClassesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_classes, container, false);
        final TextView textView = root.findViewById(R.id.text_classes);


        classesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final FloatingActionButton classes_fab = root.findViewById(R.id.classes_fab); //creates the fab specified in the layout
        classes_fab.setOnClickListener(new View.OnClickListener() { //adds an OnClickListener for the fab button
                                                                    //Currently it just toggles the background text on and off
            @Override
            public final void onClick(View view) {
                try {
                    //double number = Double.parseDouble(numberInputField.getText().toString());
                    //textView.setText(Double.toString(number));
                    } catch (NumberFormatException e) {
                    System.out.println(e.toString());
                }
            }
        });

        final RecyclerView classesRecyclerView = root.findViewById(R.id.list);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        classesRecyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter a = m

        return root;
    }
}
