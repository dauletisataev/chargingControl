package com.example.admin.chargingcontrol.fragments;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.chargingcontrol.BatteryReceiver;
import com.example.admin.chargingcontrol.R;

public class ModeFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btn;
    public ModeFragment() {
        // Required empty public constructor
    }
    public static ModeFragment newInstance(String param1, String param2) {
        ModeFragment fragment = new ModeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mode, container, false);
        btn = v.findViewById(R.id.btnStart);
        btn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnStart){
            BatteryReceiver mReceiver = new BatteryReceiver();
            getActivity().registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        }
    }
}
