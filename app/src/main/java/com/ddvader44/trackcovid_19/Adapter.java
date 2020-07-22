package com.ddvader44.trackcovid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends ArrayAdapter<AllCountries> {

    private Context context;
    private List<AllCountries> myCountries;
    public Adapter(Context context, List<AllCountries> myCountries) {
        super(context, R.layout.list_views,myCountries);
        this.context = context;
        this.myCountries = myCountries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_views,null,true);
        TextView textC = view.findViewById(R.id.countryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        textC.setText(myCountries.get(position).getCountry());
        Glide.with(context).load(myCountries.get(position).getFlag()).into(imageView);
        return view;
    }
}
