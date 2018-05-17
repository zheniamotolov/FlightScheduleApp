package com.example.android.scheduler_app.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.scheduler_app.R;

import com.example.android.scheduler_app.databinding.AirportItemBinding;
import com.example.android.scheduler_app.db.entity.Airport;
import java.util.List;
import java.util.Objects;

public class AirportAdapter extends RecyclerView.Adapter<AirportAdapter.AirportViewHolder> {

    List<Airport> mAirportList;

    @Nullable
    private final AirportClickCallback mAirportClickCallback;

    public AirportAdapter(@Nullable AirportClickCallback clickCallback) {
        mAirportClickCallback = clickCallback;
    }

    public void setAirportList(final List<Airport> airportList) {
        if (mAirportList == null) {
            mAirportList = airportList;
            notifyItemRangeInserted(0, airportList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mAirportList.size();
                }

                @Override
                public int getNewListSize() {
                    return airportList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mAirportList.get(oldItemPosition).getFs().equals(airportList.get(newItemPosition).getFs());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Airport newAirport = airportList.get(newItemPosition);
                    Airport oldAirport = mAirportList.get(oldItemPosition);
                    return newAirport.getFs().equals(oldAirport.getFs())
                            && Objects.equals(newAirport.getCountryName(), oldAirport.getCountryName())
                            && Objects.equals(newAirport.getName(), oldAirport.getName())
                            && newAirport.getCountryCode().equals(oldAirport.getCountryCode());
                }
            });
            mAirportList = airportList;
            result.dispatchUpdatesTo(this);
        }
    }
    static class AirportViewHolder extends RecyclerView.ViewHolder {

        final AirportItemBinding binding;

        public AirportViewHolder(AirportItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    @Override
    public AirportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AirportItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.airport_item,
                        parent, false);
        binding.setCallback(mAirportClickCallback);
        return new AirportViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(AirportAdapter.AirportViewHolder holder, int position) {
        holder.binding.setAirport(mAirportList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mAirportList == null ? 0 : mAirportList.size();
    }



}
