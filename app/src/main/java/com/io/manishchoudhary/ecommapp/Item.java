package com.io.manishchoudhary.ecommapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by manishchoudhary on 31/05/18.
 */

public class Item {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("category")
    @Expose
    private String category;

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    @SerializedName("gender")
    @Expose
    private String gender;

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
