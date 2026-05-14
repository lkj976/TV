package com.fongmi.android.tv.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fongmi.android.tv.bean.Vod;
import com.fongmi.android.tv.databinding.AdapterVodBinding;

import java.util.ArrayList;
import java.util.List;

public class VodAdapter extends RecyclerView.Adapter<VodAdapter.ViewHolder> {
    private List<Vod> items = new ArrayList<>();

    public void setData(List<Vod> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(AdapterVodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterVodBinding binding;

        public ViewHolder(AdapterVodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Vod item) {
            binding.tvName.setText(item.getName());
            binding.tvRemark.setText(item.getRemark());
        }
    }
}