package com.example.phobussng_2.thymely;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LIM JING JIE on 9/7/2017.
 */

public class UserTab extends Fragment {
    private static final String TAG = "UserTab";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.user_tab, container, false);

        return view;
    }
}
