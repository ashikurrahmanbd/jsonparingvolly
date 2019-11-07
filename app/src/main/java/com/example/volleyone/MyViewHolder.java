package com.example.volleyone;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView heading;
    TextView description;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.imageViewId);
        heading = (TextView) itemView.findViewById(R.id.headingText);
        description = (TextView) itemView.findViewById(R.id.descriptionTextId);



    }

}
