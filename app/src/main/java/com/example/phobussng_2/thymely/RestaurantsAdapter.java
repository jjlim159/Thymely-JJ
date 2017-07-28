package com.example.phobussng_2.thymely;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

/**
 * Created by LIM JING JIE on 21/7/2017.
 */

public class RestaurantsAdapter extends ArrayAdapter<Restaurant> {

    private static final String TAG = "Restaurant List";

    private Activity context;
    private DatabaseReference restaurantDb;
    List<Restaurant> restaurantList;
    ListView listViewRestaurants;

    public RestaurantsAdapter(Activity context, List<Restaurant> restaurantList) {
        super(context, com.example.phobussng_2.thymely.R.layout.restaurant_list, restaurantList);
        this.context = context;
        this.restaurantList = restaurantList;
    }

    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.restaurant_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.resTitle1);
        TextView textViewCat = (TextView) listViewItem.findViewById(R.id.category1);
        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.time1);

        Restaurant restaurant = restaurantList.get(position);
        textViewName.setText(restaurant.getName());
        textViewCat.setText(restaurant.getCategory());
        textViewTime.setText(restaurant.getTime());

        return listViewItem;
    }*/

    /*
    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        restaurantDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                restaurantList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting restaurant
                    Restaurant restaurant = postSnapshot.getValue(Restaurant.class);
                    //adding restaurant to the list
                    restaurantList.add(restaurant);
                }

                //creating adapter
                RestaurantsAdapter restaurantAdapter = new RestaurantsAdapter((Activity) getContext(), restaurantList);
                //attaching adapter to the listview
                listViewRestaurants.setAdapter(restaurantAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/

}
