package com.example.myappislami;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myappislami.databinding.ActivityHadeethBinding;

import java.util.ArrayList;
import java.util.List;

public class hadeethActivity extends AppCompatActivity {
    public ActivityHadeethBinding binding;

    static ArrayList<String> ahadeth;

List<HadeethModel> hadeethModels;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadeeth);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hadeeth);

        getSupportActionBar().hide();
        Bundle extra = getIntent().getExtras();
        String NameOfhadeth = " " + extra.getString("hadthName" );
        binding.nameOfHadth.setText(NameOfhadeth);
          binding.contentOfHadth.setMovementMethod(new ScrollingMovementMethod());
        int indexhadeth = extra.getInt("indexhadeth");

        for (int i = 0; i < HadeethFragment.ListHadth.length; i++) {
            if (i == indexhadeth) {
                String fileN = "احاديث ";
                String data;
              //  data = ();
                binding.contentOfHadth.setText(fileN);
                binding.contentOfHadth.setText(extra.getString("contentOfHadth"));
            }
        }


    }



}