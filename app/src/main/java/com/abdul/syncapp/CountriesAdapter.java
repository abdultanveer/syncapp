package com.abdul.syncapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesVHolder> {

    String[] mCountries;
    public CountriesAdapter(String[] countries) {
        mCountries = countries;
    }

    /**
     * when zaid is creating a plank
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public CountriesVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View plank = LayoutInflater.from(parent.getContext()).inflate(R.layout.plank_list_item,parent,false);
        return new CountriesVHolder(plank);
    }

    /**
     * ravi - write the data on the planks
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CountriesVHolder holder, int position) {
        holder.plankTextView.setText(mCountries[position]);
    }

    /**
     * manasvi -- keep the count of the no of items in the data
     * @return
     */
    @Override
    public int getItemCount() {
        return mCountries.length;
    }

    /**
     * box holding the reserve planks
     */
    public  class CountriesVHolder extends RecyclerView.ViewHolder {
        public TextView plankTextView;
        public CountriesVHolder(@NonNull View itemView) {
            super(itemView);
            plankTextView = itemView.findViewById(R.id.tvPlank);
        }
    }
}
