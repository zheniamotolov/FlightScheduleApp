package com.example.android.scheduler_app.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.android.scheduler_app.databinding.FlightStatusItemBinding;
import com.example.android.scheduler_app.R;
import com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatus;

import java.util.List;

public class FlightStatusAdapter extends RecyclerView.Adapter<FlightStatusAdapter.FlightStatusViewHolder> {

    private List<FlightStatus> mflightStatusesList;

    @Nullable
    private final FlightStatusClickCallback mFlightStatusClickCallback;

    public FlightStatusAdapter(@Nullable FlightStatusClickCallback flightStatusClickCallback) {
        mFlightStatusClickCallback = flightStatusClickCallback;
    }

    public void setFlightStatusList(final List<FlightStatus> flightStatuses) {
        if (mflightStatusesList == null) {
            mflightStatusesList = flightStatuses;
            notifyItemRangeInserted(0, flightStatuses.size());
        } else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mflightStatusesList.size();
                }

                @Override
                public int getNewListSize() {
                    return flightStatuses.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    FlightStatus old = mflightStatusesList.get(oldItemPosition);
                    FlightStatus comment = flightStatuses.get(newItemPosition);
                    return old.getFlightId() == comment.getFlightId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    FlightStatus old = mflightStatusesList.get(oldItemPosition);
                    FlightStatus newer = flightStatuses.get(newItemPosition);
                    return old.getFlightId().equals(newer.getFlightId())
                            && old.getFlightNumber().equals(newer.getFlightNumber());
                }
            });
            mflightStatusesList = flightStatuses;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @Override
    public FlightStatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        FlightStatusItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.flight_status_item,
                        parent, false);
        binding.setCallback(mFlightStatusClickCallback);
        return new FlightStatusViewHolder(binding);
    }



    @Override
    public void onBindViewHolder(FlightStatusViewHolder holder, int position) {
        holder.binding.setFlightStatus(mflightStatusesList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mflightStatusesList == null ? 0 : mflightStatusesList.size();
    }

    static class FlightStatusViewHolder extends RecyclerView.ViewHolder {

        final FlightStatusItemBinding binding;

        FlightStatusViewHolder(FlightStatusItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public void updateAnswers(List<FlightStatus> items) {
        mflightStatusesList = items;
        notifyDataSetChanged();
    }

}
