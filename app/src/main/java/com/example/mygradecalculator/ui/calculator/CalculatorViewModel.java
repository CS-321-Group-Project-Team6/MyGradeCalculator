package com.example.mygradecalculator.ui.calculator;

import android.view.View;
import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public CalculatorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the calculator");
    }


    public LiveData<String> getText() {
        return mText;
    }
}