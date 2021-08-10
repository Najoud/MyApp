package com.example.myappislami;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappislami.databinding.FragmentHadeethBinding;

import java.util.ArrayList;
import java.util.List;


public class HadeethFragment extends Fragment {
private FragmentHadeethBinding binding ;
    static ArrayList<String> hadethData;
         View view ;
         HadeethRecyclerViewAdapter hadeethRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<HadeethModel> hadeethModelsList1;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_hadeeth,container,false);
      creatHadeethList();
        hadeethRecyclerView = new HadeethRecyclerViewAdapter(hadeethModelsList1);
        layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerViewOfHadth.setAdapter(hadeethRecyclerView);
        binding.recyclerViewOfHadth.setLayoutManager(layoutManager);
        hadeethRecyclerView.setOnItemClickListener(new HadeethRecyclerViewAdapter.OnItemClickListener() {


                @Override
                void onItemClick(int pos,HadeethModel hadeethModel) {
                    Intent intent = new Intent(getActivity(),hadeethActivity.class);
                    String hdthaname = hadeethModel.TextOfHadth;
                    int indexHadth = pos;
                    intent.putExtra("hadthName",hdthaname);
                    intent.putExtra("indexHadth",indexHadth);
                    startActivity(intent);


                }});

//        hadeethRecyclerView.setOnItemClickListener(new HadeethRecyclerViewAdapter.OnItemClickListener() {
//
//            @Override
//            void onItemClick(int pos,HadeethModel hadeethModel) {
//              //  Intent intent = new Intent(getActivity(),)
//            }
//        });
        view = binding.getRoot();
        return view; }



        public static String[] ListHadth = {"الحديث الأول","الحديث الثاني","الحديث الـثـالـث","الحديث الـرابع","الحديث الخامس","الحديث السادس","الحديث السابع","الحديث الثامن","الحديث التاسع","الحديث العاشر",
                "الحديث الحادي عشر","الحديث الثانى عشر","الحديث الثالث عشر","الحد يث الرابع عشر","الحديث الخامس عشر","الحديث السادس عشر","الحديث السابع عشر","الحد يث الثامن عشر","الحد يث التاسع عشر","الحديث العشرون",
                "الحديث الحادي والعشرون","الحديث الثانى والعشرون","الحديث الثالث والعشرون","الحديث الرابع والعشرون","الحديث الخامس والعشرون","الحديث السادس والعشرون","الحديث السابع والعشرون","الحديث الثامن والعشرون","الحديث التاسع والعشرون","الحديث الثلاثون",
                "الحديث الحادي والثلاثون","الحديث الثانى والثلاثون","الحديث الثالث والثلاثون","الحديث الرابع والثلاثون","الحديث الخامس والثلاثون","الحديث السادس والثلاثون","الحديث السابع والثلاثون","الحديث الثامن والثلاثون","الحديث التاسع والثلاثون","الحديث الأربعون",
                "الحديث الحادي والأربعون","الحديث الثانى والأربعون","الحديث الثالث والأربعون","الحديث الرابع والأربعون","الحديث الخامس والأربعون","الحديث السادس والأربعون","الحديث السابع والأربعون","الحديث الثامن والأربعون","الحديث التاسع والأربعون","الحديث الخمسون",
        };


    private void creatHadeethList() {
        hadeethModelsList1 = new ArrayList<>();
        for (int i =0 ; i <ListHadth.length ;i++ ){
       hadeethModelsList1.add(new HadeethModel(ListHadth[i]));

        }
    }











}


