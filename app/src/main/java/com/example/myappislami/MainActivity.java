package com.example.myappislami;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myappislami.databinding.ActivityMain1Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.menuQuran:
                    fragment = new QuranFragment();
                    break;
                case R.id.menuHadeeth:
                    fragment = new HadeethFragment();
                    break;
                case R.id.menuSabha:
                    fragment = new SabhaFragment();
                    break;
                case R.id.menuRadio:
                    fragment = new RadioFragment();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentID,fragment).commit();

            return true;
        }
    };


 private ActivityMain1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        getSupportActionBar().hide();
        binding = ActivityMain1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


binding.BottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
getSupportFragmentManager().beginTransaction().replace(R.id.fragmentID,new QuranFragment()).commit();

    }
}