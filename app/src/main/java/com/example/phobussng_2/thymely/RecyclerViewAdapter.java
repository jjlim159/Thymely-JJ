package com.example.phobussng_2.thymely;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

/**
 * Created by LIM JING JIE on 21/7/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Restaurant> restaurantList;
    private DatabaseReference restaurantDb;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_list, parent, false);

        MyViewHolder itemViewHolder = new MyViewHolder(itemView);

        //itemViewHolder.setOnItemClickListener(onClickListener);

        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder itemViewHolder, int position) {
        final Restaurant restaurant = restaurantList.get(position);
        itemViewHolder.textViewTitle.setText(restaurant.getName());
        itemViewHolder.textViewCategory.setText(restaurant.getCategory());
        itemViewHolder.textViewTime.setText(restaurant.getTime());
        itemViewHolder.imageView.setBackgroundResource(restaurant.getImageUrl());

        itemViewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Here goes your desired onClick behaviour. Like:
                Toast.makeText(view.getContext(), "Restaurant: " + restaurant.getName(), Toast.LENGTH_SHORT).show();
                //Add data to the tag of your cardview in onBind... and retrieve it here with with.getTag().toString()..
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentManager manager = activity.getSupportFragmentManager();
                RestaurantFragment resFragment = new RestaurantFragment();
                manager.beginTransaction().replace(R.id.contentLayout, resFragment, resFragment.getTag()).commit();
            }
        });
    }

    public List<Restaurant> getRestaurantList() {
        return this.restaurantList;
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle, textViewCategory, textViewTime;
        public ImageView imageView;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardview);
            textViewTitle = (TextView) view.findViewById(R.id.resTitle);
            textViewCategory = (TextView) view.findViewById(R.id.category);
            textViewTime = (TextView) view.findViewById(R.id.time);
            imageView = (ImageView) view.findViewById(R.id.image);
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

}
