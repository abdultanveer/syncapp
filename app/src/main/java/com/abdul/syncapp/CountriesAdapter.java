package com.abdul.syncapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesVHolder> {


    /**
     * when zaid is creating a plank
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public CountriesVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    /**
     * ravi - write the data on the planks
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CountriesVHolder holder, int position) {

    }

    /**
     * manasvi -- keep the count of the no of items in the data
     * @return
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * box holding the reserve planks
     */
    public  class CountriesVHolder extends RecyclerView.ViewHolder {
        public CountriesVHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
