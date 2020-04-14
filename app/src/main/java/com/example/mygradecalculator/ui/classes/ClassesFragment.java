package com.example.mygradecalculator.ui.classes;

import android.icu.text.MessagePattern;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
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
import com.example.mygradecalculator.adapters.MyClassAdapter;


import com.example.mygradecalculator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.zip.Inflater;

public class ClassesFragment extends Fragment {

    private ClassesViewModel classesViewModel;
    private LayoutInflater classesInflater;
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

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final FloatingActionButton classes_fab = view.findViewById(R.id.classes_fab);
        final RecyclerView classesRecycleView = view.findViewById(R.id.recycle_view_layout);
        EditText[] ea = {new EditText(view.getContext()), new EditText(view.getContext()), new EditText(view.getContext()), (EditText) classesInflater.inflate(R.layout.edit_text_layout, null, false)};
        final MyClassAdapter classesAdapter = new MyClassAdapter(ea);
        final RecyclerView.LayoutManager classesLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        classesRecycleView.setLayoutManager(classesLayoutManager);
        classesRecycleView.setAdapter(classesAdapter);
        classesAdapter.addItem(classesRecycleView, 1);
        classesAdapter.notifyDataSetChanged();

    }
}
