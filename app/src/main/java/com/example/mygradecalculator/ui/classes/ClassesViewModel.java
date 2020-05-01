package com.example.mygradecalculator.ui.classes;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ClassesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ClassesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Touch the Floating Action Button to Add Classes");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setTextTo(String s) {

        mText.setValue(s);
    }


}
