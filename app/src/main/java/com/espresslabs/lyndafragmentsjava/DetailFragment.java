package com.espresslabs.lyndafragmentsjava;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private EditText textFirstName, textLastName, textAge;
    private FragmentListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // if the context is not an instance of FragmentListener, throw an assertion
        // kind of error handling
        // This line `assert context instanceof FragmentListener;` does NOT always work
        // switch to this if statement to make sure error always be handled
        if (!(context instanceof FragmentListener)) throw new AssertionError();
        mListener = (FragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        textFirstName = rootView.findViewById(R.id.textFirstName);
        textLastName = rootView.findViewById(R.id.textLastName);
        textAge = rootView.findViewById(R.id.textAge);

        Button doneButton = rootView.findViewById(R.id.button_done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done();
            }
        });

        return rootView;
    }

    private void done() {
        if (mListener == null) {
            throw new AssertionError();
        }

        String firstName = textFirstName.getText().toString();
        String lastName = textLastName.getText().toString();
        int age = Integer.valueOf(textAge.getText().toString());
        
        mListener.onFragmentFinish(firstName, lastName, age);
    }

    public interface FragmentListener {
        void onFragmentFinish(String firstName, String lastName, int age);
    }
}
