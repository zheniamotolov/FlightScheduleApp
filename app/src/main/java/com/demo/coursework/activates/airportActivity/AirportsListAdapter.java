package com.demo.coursework.activates.airportActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;


import com.demo.coursework.R;

/**
 * Created by eugene on 2/24/18.
 */

public class AirportsListAdapter extends RecyclerView.Adapter<AirportsListAdapter.AirportsListViewHolder> {

    private OnClickHandler clickHandler;
    private String[] airportsListData;

    public AirportsListAdapter(OnClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }


    @Override
    public AirportsListAdapter.AirportsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.airport_list_item, parent, false);
        return new AirportsListAdapter.AirportsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AirportsListAdapter.AirportsListViewHolder holder, int position) {
        String airportsListItemData = airportsListData[position];
        holder.airportListItemView.setText(airportsListItemData);
    }

    @Override
    public int getItemCount() {
        if (null == airportsListData) return 0;
        return airportsListData.length;
    }

    public void setAirpotsListData(String[] airpotsListData) {
        this.airportsListData = airpotsListData;
        notifyDataSetChanged();
    }

    public class AirportsListViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        public TextView airportListItemView;

        public AirportsListViewHolder(View itemView) {
            super(itemView);
            airportListItemView = (TextView) itemView.findViewById(R.id.airportsListItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String airportsListItemData = airportsListData[adapterPosition];
            clickHandler.onClick(airportsListItemData);
        }
    }
}
