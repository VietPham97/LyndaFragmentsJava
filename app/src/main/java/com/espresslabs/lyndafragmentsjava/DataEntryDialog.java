package com.espresslabs.lyndafragmentsjava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DataEntryDialog extends DialogFragment {

    public static final String PERSON_KEY = "PERSON_KEY";
    EditText etFirstName, etLastName, etAge;

    public static DataEntryDialog newInstance(Person person) {

        Bundle args = new Bundle();
        args.putParcelable(PERSON_KEY, person);

        DataEntryDialog fragment = new DataEntryDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_entry_dialog, container, false);

        etFirstName = rootView.findViewById(R.id.textFirstName);
        etLastName = rootView.findViewById(R.id.textLastName);
        etAge = rootView.findViewById(R.id.textAge);

        Person person = getArguments().getParcelable(PERSON_KEY);
        etFirstName.setText(person.getFirstName());
        etLastName.setText(person.getLastName());
        etAge.setText(String.valueOf(person.getAge()));

        Button btnOk = rootView.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // dismiss a dialog
            }
        });
        Button btnCancel = rootView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // dismiss a dialog
            }
        });

        return rootView;
    }
}
