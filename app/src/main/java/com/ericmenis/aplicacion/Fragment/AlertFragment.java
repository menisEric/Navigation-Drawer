package com.ericmenis.aplicacion.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.ericmenis.aplicacion.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AlertFragment extends Fragment implements View.OnClickListener , DialogInterface.OnClickListener {

    private FloatingActionButton fab;
    private TextView textView;

    private AlertDialog.Builder builder;
    private Switch switchBtn;

    public AlertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alert, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        textView = (TextView) view.findViewById(R.id.titleAlert);

        return view;
    }

    @Override
    public void onClick(View v) {
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("EMAIL");
        builder.setMessage("Type your email address to be displayed in the middle of the screen");

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_fragment , null);

        switchBtn = (Switch) dialogView.findViewById(R.id.switchDialog);

        builder.setView(dialogView);

        // Set up the buttons
        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("Cancel", this);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            if (switchBtn.isChecked()) {
                textView.setText("Alerts Enabled");
            } else {
                textView.setText("Alerts Disabled");
            }
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            dialogInterface.cancel();
        }
    }
}
