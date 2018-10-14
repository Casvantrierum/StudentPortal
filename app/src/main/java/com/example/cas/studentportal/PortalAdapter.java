package com.example.cas.studentportal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {

    private List<Portal> mPortals;
    final private PortalClickListener mPortalClickListener;

    public interface PortalClickListener{
        void portalOnClick (int i);
    }


    public PortalAdapter(List<Portal> mPortals, PortalClickListener mPortalClickListener) {
        this.mPortals = mPortals;
        this.mPortalClickListener = mPortalClickListener;
    }

    @NonNull
    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
// Return a new holder instance
        PortalAdapter.ViewHolder viewHolder = new PortalAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PortalAdapter.ViewHolder holder, int position) {
        Portal portal =  mPortals.get(position);
        holder.textView.setText(portal.getmName() + ": \n" + portal.getmUrl());
    }

    @Override
    public int getItemCount() {
        return mPortals.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;

        public ViewHolder(View itemView) {

            super(itemView);
            textView=  itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mPortalClickListener.portalOnClick(clickedPosition);
        }
    }
}
