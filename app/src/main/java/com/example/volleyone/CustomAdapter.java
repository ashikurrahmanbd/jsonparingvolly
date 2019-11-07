package com.example.volleyone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<MyItemsGetter> mylist; // it will get all the Elements from MyItemsGetter Class

    public CustomAdapter(Context context, List<MyItemsGetter> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_layout, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final MyItemsGetter myItem = mylist.get(position);
        holder.heading.setText(myItem.getHeading());
        holder.description.setText(myItem.getDescription());

        //image url not getting from server so i hve used the static imgae form Drawable
        //But it should come from server like below

//        Picasso.get().load(myItem.getImageUrl()).into(holder.imageView);
        String im = myItem.getImageUrl();


        Picasso.get().load(im).into(holder.imageView);


        holder.heading.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, " "+myItem.getImageUrl(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
}
