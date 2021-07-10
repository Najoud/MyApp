package com.example.myappislami;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myappislami.databinding.ActivityAlSoerBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class AlSoerActivity extends AppCompatActivity {
   // private final Object QuranModel;
    private ActivityAlSoerBinding binding;
    //private FragmentQuranBinding binding;
   // View view;
    RecyclerViewAdapter viewAdapter;
   // RecyclerView.LayoutManager layoutManager;
    List<QuranModel> quranModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_soer);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_al_soer);
        getSupportActionBar().hide();
        Bundle extra = getIntent().getExtras();
        String NameOfSora = " " + extra.getString("soerName");
        binding.nameOfSora.setText(NameOfSora);
        binding.contentOfSora.setMovementMethod(new ScrollingMovementMethod());
        int indexSora = extra.getInt("indexSora");
        for (int i = 0; i < QuranFragment.LiQuranSuer.length; i++) {
            if (i == indexSora) {
                String fileN = i+1 + ".txt";
                String data;
                data = LocaleData(fileN);
                binding.contentOfSora.setText(data);
            }
        }


    }


    public String LocaleData(String infile) {

        String text = "";
        try {
            InputStream stream = getAssets().open(infile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            int num = 0;
            while (reader.ready()) {
                String line = reader.readLine();
                text += line + "\n---------(" + ++num + ") -----------\n";
            }
         stream.close();}

         catch (IOException e) {
            e.printStackTrace();
        }return  text ;
    }


}





