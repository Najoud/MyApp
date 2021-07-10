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

import com.example.myappislami.databinding.FragmentQuranBinding;

import java.util.ArrayList;
import java.util.List;


public class QuranFragment extends Fragment {

    private FragmentQuranBinding binding;
    View view;
    RecyclerViewAdapter viewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<QuranModel> quranModelList;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {


        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quran,container,false);
        creatQuranList();
        viewAdapter = new RecyclerViewAdapter(quranModelList);
        layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setAdapter(viewAdapter);
        binding.recyclerView.setLayoutManager(layoutManager);
        viewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos,QuranModel quranModel) {
                Intent intent = new Intent(getActivity(),AlSoerActivity.class);
                String suraname = quranModel.TextOfQuran;
                int  indexSora = pos ;
                intent.putExtra("soerName" ,suraname) ;
                intent.putExtra("indexSora", indexSora);
                startActivity(intent);
            }

        });

        view = binding.getRoot();
        return view;
    }


    public static String[] LiQuranSuer = {

            " سورة الفاتحة",

            "سورة البقرة",

            "سورة آل عمران",

            " سورة النساء",

            "سورة المائدة",

            " سورة الأنعام",

            " سورة الأعراف",

            " سورة الأنفال",

            " سورة التوبة",

            "سورة يونس ",

            "  سورة هود",

            "سورة يوسف",

            " سورة الرعد",

            " سورة إبراهيم",

            " سورة الحجر",

            " سورة النحل",

            " سورة الإسراء",

            "سورة الكهف",

            "سورة مريم",

            "  سورة طه",

            "  سورة الأنبياء",

            " سورة الحج",

            " سورة المؤمنون",

            "  سورة النّور",

            "  سورة الفرقان",

            "  سورة الشعراء",

            "  سورة النّمل",

            " سورة القصص",

            "  سورة العنكبوت",

            " سورة الرّوم",

            "  سورة لقمان",

            " سورة السجدة",

            "  سورة الأحزاب",

            "  سورة سبأ",

            "   سورة فاطر",

            " سورة يس",

            " سورة الصافات",

            " سورة ص",

            "  سورة الزمر",

            "  سورة غافر",

            " سورة فصّلت",

            "  سورة الشورى",

            "  سورة الزخرف",

            " سورة الدّخان",

            " سورة الجاثية",

            "  سورة الأحقاف",

            " سورة محمد",

            "  سورة الفتح",

            "  سورة الحجرات",

            " سورة ق",

            " سورة الذاريات",

            " سورة الطور",

            "  سورة النجم",

            "  سورة القمر",

            "سورة الرحمن",

            "  سورة الواقعة",

            " سورة الحديد",

            " سورة المجادلة",

            " سورة الحشر",

            " سورة الممتحنة",

            "  سورة الصف",

            " سورة الجمعة",

            "  سورة المنافقون",

            "  سورة التغابن ",

            "  سورة الطلاق",

            "  سورة التحريم",

            "  سورة الملك",

            "  سورة القلم",

            " سورة الحاقة",

            " سورة المعارج",

            "  سورة نوح",

            "  سورة الجن",

            " سورة المزّمّل",

            "  سورة المدّثر",

            "  سورة القيامة",

            "  سورة الإنسان",

            "  سورة المرسلات",

            "  سورة النبأ",

            "  سورة النازعات",

            "  سورة عبس",

            " سورة التكوير",

            " سورة الإنفطار",

            "  سورة المطفّفين",

            "  سورة الإنشقاق",

            "  سورة البروج",

            " سورة الطارق",

            "  سورة الأعلى",

            "  سورة الغاشية",

            "  سورة الفجر",

            "سورة البلد",

            "سورة الشمس",

            "  سورة الليل",

            " سورة الضحى",

            " سورة الشرح",

            " سورة التين",

            " سورة العلق",

            " سورة البينة",

            "  سورة الزلزلة",

            " سورة العاديات",

            " سورة القارعة",

            " سورة التكاثر",

            "  سورة العصر",

            " سورة الهمزة",

            " سورة الفيل",

            "  سورة قريش",

            " سورة الماعون",

            " سورة الكوثر",

            " سورة الكافرون",

            "  سورة النصر",

            " سورة المسد",

            "  سورة الإخلاص",

            "  سورة الفلق",

            " سورة النّاس"
    };


    private void creatQuranList() {
        quranModelList = new ArrayList<>();
        for (int i = 0; i < LiQuranSuer.length; i++) {
            quranModelList.add(new QuranModel(LiQuranSuer[i]));

        }
    }
}