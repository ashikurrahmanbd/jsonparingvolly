package com.example.volleyone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String dataUrl = "https://api.myjson.com/bins/6tte6";
    CustomAdapter customAdapter;
    List<MyItemsGetter> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        loadData();


    }

    public void loadData(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, dataUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("myData");

                            for(int i = 0; i<array.length(); i++ ){
                                JSONObject recieveJson = array.getJSONObject(i);

                                MyItemsGetter itemss = new MyItemsGetter(

                                        recieveJson.getString("headText"),
                                        recieveJson.getString("descText"),
                                        recieveJson.getString("imageLink")
                                );

                                listItems.add(itemss);
                            }

                            CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), listItems);
                            recyclerView.setAdapter(customAdapter);


                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}
