package com.sample.android.country;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private ArrayList<String> countryNames = new ArrayList<>();
    private ArrayList<JSONObject> mJSONObjects = new ArrayList<>();
    private ArrayList<String> citiNames = new ArrayList<>();

    private CountryAdapter mCountryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));


        parseAndroid();
        mCountryAdapter = new CountryAdapter(getApplicationContext(), mJSONObjects);
        list.setAdapter(mCountryAdapter);

    }

    private void parseAndroid() {
        String jsonResponse = getResources().getString(R.string.response);
        JSONArray jsonarray;
        Log.d("String is", jsonResponse);

        try {
            jsonarray = new JSONArray(jsonResponse);
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String country = jsonobject.getString("country");
                countryNames.add(country);
                mJSONObjects.add(jsonobject);
                Log.d("Country is:", country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
