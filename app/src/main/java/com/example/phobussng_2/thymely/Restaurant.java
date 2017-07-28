package com.example.phobussng_2.thymely;

/**
 * Created by LIM JING JIE on 21/7/2017.
 */

public class Restaurant {

    private int id;
    private String name;
    private String time;
    private String category;
    private String location;
    private String openingHrs;
    private int fee;
    private int imageUrl;

    public Restaurant() {
        //Empty Constructor
    }

    public Restaurant(int id, String name, String category, String time, String location, String openingHrs, int fee) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.category = category;
        this.location = location;
        this.openingHrs = openingHrs;
        this.fee = fee;

        setImageUrl(this.id);
    }

    public void setImageUrl(int id) {
        switch(id) {
            case 1:
                this.imageUrl = R.drawable.res1;
                break;
            case 2:
                this.imageUrl = R.drawable.res2;
                break;
            case 3:
                this.imageUrl = R.drawable.res3;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public String getOpeningHrs() {
        return openingHrs;
    }

    public int getFee() {
        return fee;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }
}
