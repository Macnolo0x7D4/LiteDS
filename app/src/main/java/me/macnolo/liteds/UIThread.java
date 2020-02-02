package me.macnolo.liteds;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class UIThread extends AsyncTask<View, Fragment, TextView> {
    @Override
    protected TextView doInBackground(View... views) {
        return null;
    }

    @Override
    protected void onPostExecute(TextView t){
    }
}
