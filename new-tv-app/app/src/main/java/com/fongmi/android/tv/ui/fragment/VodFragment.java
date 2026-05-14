package com.fongmi.android.tv.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fongmi.android.tv.R;
import com.fongmi.android.tv.bean.Vod;
import com.fongmi.android.tv.databinding.FragmentVodBinding;
import com.fongmi.android.tv.ui.adapter.VodAdapter;

import java.util.ArrayList;
import java.util.List;

public class VodFragment extends Fragment {
    private FragmentVodBinding binding;
    private VodAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVodBinding.inflate(inflater, container, false);
        initRecyclerView();
        loadData();
        return binding.getRoot();
    }

    private void initRecyclerView() {
        adapter = new VodAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        List<Vod> vods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Vod vod = new Vod();
            vod.setName("视频标题 " + (i + 1));
            vod.setRemark("这是视频描述 " + (i + 1));
            vods.add(vod);
        }
        adapter.setData(vods);
    }
}