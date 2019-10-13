package id.ac.polinema.utsandroid.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.polinema.utsandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PengetahuanFragment extends Fragment {


    public PengetahuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pengetahuan, container, false);
    }

}
