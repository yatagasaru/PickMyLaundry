package com.example.lenovo.androidmysql;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register1 extends Fragment {


    public Register1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.register_1, container, false);
        Button btNext = (Button)rootView.findViewById(R.id.btNextRegister1);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new Register2();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmain, frag);
                ft.commit();
            }
        });
        return rootView;
    }

}
