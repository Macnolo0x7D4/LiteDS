package me.macnolo.liteds.ui.console;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import me.macnolo.liteds.R;

public class ConsoleFragment extends Fragment {
    private EditText verbose;
    private Button clearButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_console, container, false);
        verbose = root.findViewById(R.id.verboseText);
        clearButton = root.findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verbose.setText("[i] Waiting for log.");
            }
        });
        return root;
    }
}