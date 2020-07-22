package com.ddvader44.trackcovid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<AllCountries> {

    private Context context;
    private List<AllCountries> myCountries;
    private List<AllCountries> myCountriesFiltered;


    public Adapter(Context context, List<AllCountries> myCountries) {
        super(context, R.layout.list_views,myCountries);
        this.context = context;
        this.myCountries = myCountries;
        this.myCountriesFiltered = myCountries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_views,null,true);
        TextView textC = view.findViewById(R.id.countryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        textC.setText(myCountriesFiltered.get(position).getCountry());
        Glide.with(context).load(myCountriesFiltered.get(position).getFlag()).into(imageView);
        return view;
    }

    @Override
    public int getCount() {
        return myCountriesFiltered.size();
    }

    @Nullable
    @Override
    public AllCountries getItem(int position) {
        return myCountriesFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = myCountries.size();
                    filterResults.values = myCountries;

                }else{
                    List<AllCountries> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(AllCountries itemsModel:myCountries){
                        if(itemsModel.getCountry().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                myCountriesFiltered = (List<AllCountries>) results.values;
                Countries.countryModelList = (List<AllCountries>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }

}
