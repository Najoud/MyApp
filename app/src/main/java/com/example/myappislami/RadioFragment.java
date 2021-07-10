package com.example.myappislami;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.myappislami.RadioModel.RadioResponse;
import com.example.myappislami.RadioModel.RadiosItem;
import com.example.myappislami.databinding.FragmentRadioBinding;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RadioFragment extends Fragment {
    private FragmentRadioBinding binding;
    View view;
    RecyclerView.LayoutManager layoutManager;
    MediaPlayer mediaPlayer;
    RadioRecyclerAdapter adapter;


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_radio,container,false);
         view = binding.getRoot();
        //onCreateDataList();
        callRadios();
        adapter = new RadioRecyclerAdapter(null);
        layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.recyclerView);
        //  return view ;

        adapter.setOnPlayClickListener(new RadioRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos,RadiosItem radiosItem) {
                ///play sound
                playSound(radiosItem.getURL());
            }
        });
        adapter.setOnStopClickListener(new RadioRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos,RadiosItem radiosItem) {
                stopsound();
            }
        });

        return view;
    }

    public void callRadios() {
        APIManager.getAPIS().getAllSources().enqueue(new Callback<RadioResponse>() {
            @Override
            public void onResponse(Call<RadioResponse> call,Response<RadioResponse> response) {
             // adapter = new RadioRecyclerAdapter(response.body().getRadios());
              //adapter.changeData(response.body().getRadios());
            //  binding.recyclerView.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<RadioResponse> call,Throwable t) {
                Log.e("TAG","onFailure: " + t.getLocalizedMessage());


            }
        });

    }



   // MediaPlayer mediaPlayer;
    public  void stopsound() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

    }
    public void playSound(String URL){
        mediaPlayer = new MediaPlayer();
     stopsound();
        try {
             mediaPlayer.setDataSource(URL);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

