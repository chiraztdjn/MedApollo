package com.example.medapollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView=findViewById(R.id.navbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.maincntr, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;

                switch(item.getItemId()){
                    case R.id.home:
                    fragment=new HomeFragment();
                    break;
                    case R.id.cart:
                        fragment=new CartFragment();
                        break;
                    case R.id.map:
                            fragment=new MapFragment();
                            break;
                    case R.id.profile:
                        fragment=new ProfileFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.maincntr,fragment).commit();
                return true;
            }
        });

    }
}