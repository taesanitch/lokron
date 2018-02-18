package com.example.centaepoint.lokronguide;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SaveTheWorldActivity extends AppCompatActivity {
    ImageButton ibSave1,ibSave2,ibSave3,ibSave4,ibSave5,ibSave6,ibSave7,ibSave8,ibSave9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_the_world);
        initInstance();
    }

    private void initInstance() {
        ibSave1 = (ImageButton)findViewById(R.id.ibSave1);
        ibSave2 = (ImageButton)findViewById(R.id.ibSave2);
        ibSave3 =(ImageButton)findViewById(R.id.ibSave3);
        ibSave4 = (ImageButton)findViewById(R.id.ibSave4);
        ibSave5 = (ImageButton)findViewById(R.id.ibSave5);
        ibSave6 = (ImageButton)findViewById(R.id.ibSave6);
        ibSave7 = (ImageButton)findViewById(R.id.ibSave7);
        ibSave8 = (ImageButton)findViewById(R.id.ibSave8);
        ibSave9 = (ImageButton)findViewById(R.id.ibSave9);

        ibSave1.setOnClickListener(listener);
        ibSave2.setOnClickListener(listener);
        ibSave3.setOnClickListener(listener);
        ibSave4.setOnClickListener(listener);
        ibSave5.setOnClickListener(listener);
        ibSave6.setOnClickListener(listener);
        ibSave7.setOnClickListener(listener);
        ibSave8.setOnClickListener(listener);
        ibSave9.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == ibSave1){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",1);
                startActivity(intent);
            }
            if(view == ibSave2){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",2);
                startActivity(intent);
            }
            if(view == ibSave3){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",3);
                startActivity(intent);
            }if(view == ibSave4){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",4);
                startActivity(intent);
            }if(view == ibSave5){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",5);
                startActivity(intent);
            }if(view == ibSave6){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",6);
                startActivity(intent);
            }if(view == ibSave7){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",7);
                startActivity(intent);
            }if(view == ibSave8){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",8);
                startActivity(intent);
            }if(view == ibSave9){
                Intent intent = new Intent(SaveTheWorldActivity.this,SaveTheWorldDataActivity.class);
                intent.putExtra("data",9);
                startActivity(intent);
            }
        }
    };
}
