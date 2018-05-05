package com.demo.schedularapp.delete_it;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.schedularapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

    private List<Item> productlist;
    private Context context;

    public MainActivityAdapter(List<Item> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView v_image;
        TextView v_name;

        ViewHolder(View itemview) {
            super(itemview);
            v_image = (ImageView) itemview.findViewById(R.id.product_image);
            v_name = (TextView) itemView.findViewById(R.id.product_title);
        }
    }


    @NonNull
    @Override
    public MainActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.customitem, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityAdapter.ViewHolder holder, final int position) {
        holder.v_name.setText(productlist.get(position).getName());
        holder.v_image.setImageResource(productlist.get(position).getPhoto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "click on " + productlist.get(position).getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setfilter(List<Item> listitem) {
        productlist = new ArrayList<>();
        productlist.addAll(listitem);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }
}
