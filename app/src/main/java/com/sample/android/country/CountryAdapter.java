package com.sample.android.country;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Anuja on 9/9/17.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private ArrayList<String> data = new ArrayList<>();
    private ArrayList<JSONObject> obj;
    private Context context;
    ArrayList<String> countries, cities;


    public CountryAdapter(Context context, ArrayList<JSONObject> data) {
        this.obj = data;
        this.context = context;

    }


    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cities, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        parseCountries(obj);

        return new ViewHolder(view);
    }

    private void parseCountries(ArrayList<JSONObject> obj) {
        data.add("Norway");
        data.add("India");
    }


    @Override
    public void onBindViewHolder(CountryAdapter.ViewHolder holder, int position) {

        holder.countryName.setText(data.get(position));
        TextView tw = new TextView(context);
        tw.setText("Klondike");
        holder.mLinearLayout.addView(tw);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        LinearLayout mLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            countryName = (TextView) itemView.findViewById(R.id.countryName);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.linearView);


        }


    }


}
