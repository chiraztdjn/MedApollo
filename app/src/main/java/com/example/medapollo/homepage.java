package com.example.medapollo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Locale;

public class homepage extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<Medclass> arrayList=new ArrayList<>();
    ArrayList<Medclass> searchList;
    String[] medlist = new String[]{"paracetamol","doliprane","clamoxyl","proton","spasfon","augmentin"
               ,"maxilaze","rapidus"};
    String[] medNum = new String[]{"med1","med2","med3","med4","med5","med6","med7","med8"};
    int[] imgList=new int[]{R.drawable.google};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        recyclerView=findViewById(R.id.recycle_search);
        searchView=findViewById(R.id.search_view);
        searchView.setIconified(false);
        searchView.clearFocus();
        for (int i = 0; i < medlist.length; i++) {
            Medclass medclass=new Medclass();
            medclass.setMedName(medlist[i]);
            medclass.setMedNum(medlist[i]);
            medclass.setImg(imgList[i]);
            arrayList.add(medclass);


        }
      RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(homepage.this);
        recyclerView.setLayoutManager(layoutManager);
        MedAdapter medAdapter=new MedAdapter(homepage.this,arrayList);
        recyclerView.setAdapter(medAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList=new ArrayList<>();

                if (query.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if(arrayList.get(i).getMedName().toUpperCase().contains(query.toUpperCase())){
                           Medclass medclass=new Medclass();

                           medclass.setMedName(arrayList.get(i).getMedName());
                           medclass.setMedNum(arrayList.get(i).getMedNum());
                           medclass.setImg(arrayList.get(i).getImg());
                           searchList.add(medclass);



                        }

                    }

                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(homepage.this);
                    recyclerView.setLayoutManager(layoutManager);
                    MedAdapter medAdapter=new MedAdapter(homepage.this,searchList);
                    recyclerView.setAdapter(medAdapter);
                }
                else{

                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(homepage.this);
                    recyclerView.setLayoutManager(layoutManager);
                    MedAdapter medAdapter=new MedAdapter(homepage.this,arrayList);
                    recyclerView.setAdapter(medAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                searchList=new ArrayList<>();

                if (newText.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if(arrayList.get(i).getMedName().toUpperCase().contains(newText.toUpperCase())){
                            Medclass medclass=new Medclass();

                            medclass.setMedName(arrayList.get(i).getMedName());
                            medclass.setMedNum(arrayList.get(i).getMedNum());
                            medclass.setImg(arrayList.get(i).getImg());
                            searchList.add(medclass);



                        }

                    }

                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(homepage.this);
                    recyclerView.setLayoutManager(layoutManager);
                    MedAdapter medAdapter=new MedAdapter(homepage.this,searchList);
                    recyclerView.setAdapter(medAdapter);
                }
                return false;
            }
        });
    }
}