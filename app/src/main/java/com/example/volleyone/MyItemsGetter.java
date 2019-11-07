package com.example.volleyone;

public class MyItemsGetter {

    private String heading;
    private String description;
    private String imageUrl;

    public MyItemsGetter(String heading, String description, String imageUrl) {
        this.heading = heading;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
