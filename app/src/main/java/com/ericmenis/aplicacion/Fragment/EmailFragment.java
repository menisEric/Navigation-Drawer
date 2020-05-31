package com.ericmenis.aplicacion.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ericmenis.aplicacion.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class EmailFragment extends Fragment implements View.OnClickListener , DialogInterface.OnClickListener{

    private FloatingActionButton fab;
    private TextView textView;

    private EditText editText;
    private AlertDialog.Builder builder;

    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        textView = (TextView) view.findViewById(R.id.titleEmail);
        return view;
    }

    @Override
    public void onClick(View v) {
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("EMAIL");
        builder.setMessage("Type your email address to be displayed in the middle of the screen");

        editText = new EditText(getContext());
        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        builder.setView(editText);

        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("Cancel", this);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {

            String email = editText.getText().toString();
            if (!email.isEmpty()) {
                textView.setText(email);
            }

        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            dialogInterface.cancel();
        }
    }
}
