package com.example.phobussng_2.thymely;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIM JING JIE on 9/7/2017.
 */

public class ExploreTab extends Fragment {

    private static final String TAG = "ExploreTab";
    private DatabaseReference restaurantDb;
    private FirebaseDatabase firebaseDatabase;
    private List<Restaurant> restaurantList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private View view;

    public ExploreTab() {
        //Required empty public constructor
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewCategory, textViewTime;
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            textViewTitle = (TextView) view.findViewById(R.id.resTitle);
            textViewCategory = (TextView) view.findViewById(R.id.category);
            textViewTime = (TextView) view.findViewById(R.id.time);
            imageView = (ImageView) view.findViewById(R.id.image );
        }

        public void setTitle(String title) {
            textViewTitle.setText(title);
        }
        public void setCategory(String category) {
            textViewCategory.setText(category);
        }
        public void setTime(String time) {
            textViewTime.setText(time);
        }
        public void setImage(int imageUrl) {
            imageView.setBackgroundResource(imageUrl);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //Inflate layout for the fragment
        View view = inflater.inflate(R.layout.explore_tab, container, false);

        setOnClickListener(view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        init();
        loadData();
    }

    private void init() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new RecyclerViewAdapter(getContext(), restaurantList);
        Log.e("Size: ", String.valueOf(restaurantList.size()));
        recyclerView.setAdapter(adapter);
        //recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        restaurantDb = firebaseDatabase.getReference("RestaurantList");

        // Read from the database
        restaurantDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    getData(postSnapshot);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", databaseError.toException());
                throw databaseError.toException();
            }
        });

    }

    /*
    @Override
    public void setOnClickListener(RecyclerView recyclerView) {
        recyclerView.setOnClickListener(new AdapterView.OnClickListener() {
            public void onClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), RestaurantMenu.class);
                startActivity(i);
            }
        });
    }*/

    private void getData(DataSnapshot postSnapshot) {
        Restaurant restaurant = postSnapshot.getValue(Restaurant.class);
        restaurant.setImageUrl(restaurant.getId());
        restaurantList.add(restaurant);

        Log.e("Restaurant", restaurant.getId() + " " + restaurant.getName() + "Size: " + restaurantList.size());
    }

    private void setOnClickListener(View view) {
        Button btn = (Button) view.findViewById(R.id.sort);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SortRestaurants.class);
                startActivity(i);
            }
        });
    }



    /*
    private void getRestaurantData2() {
        Restaurant restaurant;
        restaurant = new Restaurant(1, "ABC", "5-10min", "BBT", "TAMP", "9-10", 3);
        restaurantList.add(restaurant);

        restaurant = new Restaurant(2, "DEF", "10-15min", "BBT", "PSR", "9-10", 3);
        restaurantList.add(restaurant);

        restaurant = new Restaurant(3, "GHI", "15-20min", "BBT", "SIM", "9-10", 3);
        restaurantList.add(restaurant);
    }*/

}
