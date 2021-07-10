package com.example.myappislami;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myappislami.databinding.FragmentSabhaBinding;

public class SabhaFragment extends Fragment  {
 private FragmentSabhaBinding binding;
    View view;
    int countValue1,countValue2,countValue3 =0 ,T=0 ;
    int countValue ;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sabha,container,false);

        view = binding.getRoot();

        binding.buttontotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                T =countValue1+countValue2 + countValue3;
                binding.textviewSubhan.setText(Integer.toString(countValue2)) ;
                binding.textviewAlaakber.setText(Integer.toString(countValue1));
               binding.textviewAlhamed.setText(Integer.toString(countValue3));
                binding.total.setText(Integer.toString(T));
            }
        });

        binding.alahakper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countValue1 ++;
                binding.textviewAlaakber.setText(Integer.toString(countValue1));
            }
        });


        binding.subhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countValue =0;
                countValue2++;
                binding.textviewSubhan.setText(Integer.toString(countValue2));
            }

        });
        binding.alhmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countValue =0;
                countValue3++;
                binding.textviewAlhamed.setText(Integer.toString(countValue3));
            }
        });


        //refrsh
        binding.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              countValue =0;
              countValue2 =0 ;
              countValue1 =0 ;
              countValue3 =0 ;
                binding.textviewAlaakber.setText(Integer.toString(countValue));
                binding.textviewAlhamed.setText(Integer.toString(countValue));
                binding.textviewSubhan.setText(Integer.toString(countValue));
                binding.total.setText(Integer.toString(countValue));

            }
});


        return view;}}
//        });
//        binding.restart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                countValue=0;
//                binding.textviewAlhamed.setText(Integer.toString(countValue));
//            }
//
//        });
//        binding.restart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                countValue=0;
//                binding.textviewSubhan.setText(Integer.toString(countValue));
//            }
//
//        });
//

  //    return view;
//
   //}}

