package com.example.myappislami;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappislami.databinding.HadeethitemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HadeethRecyclerViewAdapter extends RecyclerView.Adapter<HadeethRecyclerViewAdapter.ViewHolder> {
    List<HadeethModel> hadeethModels;
    int ItemView;
    static OnItemClickListener onItemClickListener ;


    public HadeethRecyclerViewAdapter(List<HadeethModel> hadeethModelList) {
        this.hadeethModels = hadeethModelList;
        this.ItemView = ItemView;
    }
    @NonNull
    @NotNull
    @Override
    public HadeethRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent,int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.hadeethitem,parent,false);
        return new ViewHolder((HadeethitemBinding) binding );
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull HadeethRecyclerViewAdapter.ViewHolder holder,int position) {
        HadeethModel hadeethModel = hadeethModels.get(position);

        holder.hadeethitemBinding.nameOfHadth.setText(hadeethModel.TextOfHadth);
        if (onItemClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,hadeethModel);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (hadeethModels == null) {
            return 0;
        } else {
            return hadeethModels.size();
        }
    }



    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = (OnItemClickListener) onItemClickListener;
    }


         class ViewHolder  extends RecyclerView.ViewHolder{
            HadeethitemBinding hadeethitemBinding;
            public ViewHolder(HadeethitemBinding hadeethitemBinding) {
                super(hadeethitemBinding.getRoot());
                this.hadeethitemBinding = hadeethitemBinding;
        }
    }

    public static abstract class OnItemClickListener {
        abstract void onItemClick(int pos,HadeethModel hadeethModel);

    }
}
