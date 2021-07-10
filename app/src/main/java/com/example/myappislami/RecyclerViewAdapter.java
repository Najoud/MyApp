package com.example.myappislami;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappislami.databinding.QuranitemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class  RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<QuranModel> quranModels;
    int itemView;
    OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(List<QuranModel> quranModelList) {
        this.quranModels = quranModelList;
        this.itemView = itemView;
    }


    @NonNull
    @NotNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent,int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.quranitem,parent,false);
        return new ViewHolder((QuranitemBinding) binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapter.ViewHolder holder,int position) {
        QuranModel quranModel = quranModels.get(position);

     holder.quranitemBinding.nameOfSora.setText(quranModel.TextOfQuran);
     if (onItemClickListener !=null){
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 onItemClickListener.onItemClick(position,quranModel);
             }
         });
     }

    }

    @Override
    public int getItemCount() {
        if (quranModels == null) {
            return 0;
        } else {
            return quranModels.size();
        }
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = (OnItemClickListener) onItemClickListener;
    }




    class ViewHolder extends RecyclerView.ViewHolder{
     QuranitemBinding quranitemBinding;
     public ViewHolder(QuranitemBinding quarantineBinding) {
        super(quarantineBinding.getRoot());
        this.quranitemBinding = quarantineBinding;
    }}


    public interface OnItemClickListener {
        void onItemClick(int pos,QuranModel quranModel);
        }

    }


