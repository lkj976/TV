package com.fongmi.android.tv.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.fongmi.android.tv.R;
import com.fongmi.android.tv.databinding.ActivityMainBinding;
import com.fongmi.android.tv.ui.fragment.LiveFragment;
import com.fongmi.android.tv.ui.fragment.SearchFragment;
import com.fongmi.android.tv.ui.fragment.SettingFragment;
import com.fongmi.android.tv.ui.fragment.VodFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initNavigation();
        switchFragment(new VodFragment());
    }

    private void initNavigation() {
        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_vod:
                    switchFragment(new VodFragment());
                    return true;
                case R.id.nav_live:
                    switchFragment(new LiveFragment());
                    return true;
                case R.id.nav_search:
                    switchFragment(new SearchFragment());
                    return true;
                case R.id.nav_setting:
                    switchFragment(new SettingFragment());
                    return true;
                default:
                    return false;
            }
        });
    }

    private void switchFragment(Fragment fragment) {
        if (currentFragment == fragment) return;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        if (!fragment.isAdded()) {
            transaction.add(R.id.container, fragment);
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
        currentFragment = fragment;
    }
}