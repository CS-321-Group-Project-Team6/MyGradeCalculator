package com.example.mygradecalculator.adapters;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.text.InputType;
import android.text.Layout;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatViewInflater;
import androidx.core.view.ViewGroupCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;

import com.example.mygradecalculator.MainActivity;
import com.example.mygradecalculator.R;
import com.example.mygradecalculator.ui.classes.ClassesFragment;

import android.view.LayoutInflater;

import java.util.Arrays;
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
import com.example.mygradecalculator.adapters.MyClassAdapter;

import org.w3c.dom.Text;

public class MyClassAdapter extends RecyclerView.Adapter<MyClassAdapter.MyViewHolder> {

    private String[] adapterDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public EditText editText;
        public MyViewHolder(EditText e) {
            super(e);
            editText = e;
            editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        }
    }

    public MyClassAdapter(String[] dataset) {
        adapterDataset = dataset;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //newEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        EditText e =  new EditText(parent.getContext());
        MyViewHolder newMyViewHolder = new MyViewHolder(e);
        return newMyViewHolder;
    }

    /*public void bindViewHolder (ViewHolder , int i) {

    }*/

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.editText.setText(adapterDataset[position]);
        holder.editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    @Override
    public int getItemCount() {
        return adapterDataset.length;
    }
}
