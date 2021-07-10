package com.example.myappislami;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappislami.RadioModel.RadiosItem;
import com.example.myappislami.databinding.ItemRadioBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RadioRecyclerAdapter  extends RecyclerView.Adapter<RadioRecyclerAdapter.ViewHolder>{
    List<RadiosItem> radiosItems;
    OnItemClickListener onPlayClickListener ;
    OnItemClickListener onStopClickListener ;


    public void setOnPlayClickListener(OnItemClickListener onPlayClickListener) {
        this.onPlayClickListener = onPlayClickListener;
    }

    public void setOnStopClickListener(OnItemClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    public RadioRecyclerAdapter(List<RadiosItem> radiosItems) {
        this.radiosItems = radiosItems;
    }

    @NonNull
    @NotNull
    @Override
    public RadioRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent,int viewType) {


        ItemRadioBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_radio,parent,false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull RadioRecyclerAdapter.ViewHolder holder,int position) {
        RadiosItem radiosItem =radiosItems.get(position);
        holder.radioBinding.nameOfRadio.setText(radiosItem.getName());
        if (onPlayClickListener!=null ){holder.radioBinding.ivRadioPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayClickListener.onItemClick(position,radiosItem);
            }
        });}

        if (onStopClickListener!=null ){holder.radioBinding.ivRadioStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStopClickListener.onItemClick(position,radiosItem);
            }
        });}
    }


    @Override
    public int getItemCount() {
        if (radiosItems == null){
            return 0;
        }else {
            return radiosItems.size();
        }
    }

    public void changeData(List<RadiosItem> items){
        radiosItems = items;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRadioBinding radioBinding ;
        public ViewHolder(ItemRadioBinding itemRadioBinding) {
            super(itemRadioBinding.getRoot());
            this.radioBinding=itemRadioBinding;
        }
    }

    public  interface OnItemClickListener {
        void onItemClick (int pos , RadiosItem radiosItem);
    }
}
