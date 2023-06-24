 package com.rec.movie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

 public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
     private FragmentManager fm;
     private FragmentTransaction ft;
     private Home home;
     private Search search;
     private Category category;
     private Mypage mypage;
     private Settings settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.action_home:
                    setFrag(0);
                    break;
                case R.id.action_search:
                    setFrag(1);
                    break;
                case R.id.action_category:
                    setFrag(2);
                    break;
                case R.id.action_mypage:
                    setFrag(3);
                    break;
                case R.id.action_settings:
                    setFrag(4);
                    break;
            }
            return false;
        });

        home = new Home();
        search = new Search();
        category = new Category();
        mypage = new Mypage();
        settings = new Settings();
        setFrag(0); //첫 프래그먼트 화면
    }

    //프래그먼터 교체가 일어나는 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame, home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, search);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, category);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, mypage);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, settings);
                ft.commit();
                break;
        }
    }
}