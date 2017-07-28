package com.example.phobussng_2.thymely;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LIM JING JIE on 20/7/2017.
 */

public class RestaurantFragment extends Fragment {

    private static final String TAG = "Restaurant Menu";

    private TextView textViewTitle, textViewCategory, textViewTime;
    private ImageView imageView;

    public RestaurantFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.restaurant_menu, container, false);

        textViewTitle = (TextView) view.findViewById(R.id.resTitle);
        textViewCategory = (TextView) view.findViewById(R.id.category);
        textViewTime = (TextView) view.findViewById(R.id.time);
        imageView = (ImageView) view.findViewById(R.id.image);

        return view;
    }

}