package me.macnolo.liteds.ui.gamepad;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GamepadViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GamepadViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}