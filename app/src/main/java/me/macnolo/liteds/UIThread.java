package me.macnolo.liteds;

import android.view.View;
import android.widget.TextView;
import me.macnolo.liteds.ui.home.HomeFragment;

public class UIThread implements Runnable{
    private HomeFragment home = new HomeFragment();

    private TextView t;
    private View view;

    public UIThread(TextView t, View view) {
        this.t = t;
        this.view = view;
    }

    @Override
    public void run(){
        home.handler.post(new Runnable() {
            @Override
            public void run() {
                int battery = home.getBatteryPercent(view);
                t.setText(battery + "%");
            }
        });
    }
}
