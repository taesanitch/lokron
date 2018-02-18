package com.example.centaepoint.lokronguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SaveTheWorldDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_the_world_data);
        if(savedInstanceState == null){
            Intent intent = getIntent();
            int data = intent.getIntExtra("data",0);
            if(data == 1){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save1Fragment.newInstance())
                        .commit();
            }else if(data == 2){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save2Fragment.newInstance())
                        .commit();
            }else if(data == 3){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save3Fragment.newInstance())
                        .commit();
            }else if(data == 4){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save4Fragment.newInstance())
                        .commit();
            }else if(data == 5){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save5Fragment.newInstance())
                        .commit();
            }else if(data == 6){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save6Fragment.newInstance())
                        .commit();
            }else if(data == 7){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save7Fragment.newInstance())
                        .commit();
            }else if(data == 8){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save8Fragment.newInstance())
                        .commit();
            }else if(data == 9){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.saveContent,
                                Save9Fragment.newInstance())
                        .commit();
            }
        }
    }
}
