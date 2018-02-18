package com.example.centaepoint.lokronguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    Button btLogout;
    TextView tvName;
    View btAbout,btGlobal,btSaveTheWorld,btTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initInstance();
    }

    private void initInstance() {
        tvName = (TextView)findViewById(R.id.tvName);
        btLogout = (Button)findViewById(R.id.btLogout);
        btAbout = (View)findViewById(R.id.btAbout);
        btGlobal = (View)findViewById(R.id.btGlobal);
        btSaveTheWorld = (View)findViewById(R.id.btSaveTheWorld);
        btTest = (View)findViewById(R.id.btTest);
        btAbout.setOnClickListener(listener);
        btLogout.setOnClickListener(listener);
        btSaveTheWorld.setOnClickListener(listener);
        btGlobal.setOnClickListener(listener);
        btTest.setOnClickListener(listener);
        tvName.setText(Datasource.getInstance().getName(MenuActivity.this));
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btLogout){
                Datasource.getInstance().ClearData(MenuActivity.this);
                Intent intent = new Intent(MenuActivity.this,LoginActivity.class);
                startActivity(intent);
            }else if(view == btAbout){
                Intent intent = new Intent(MenuActivity.this,AboutActivity.class);
                startActivity(intent);
            }else if(view == btGlobal){
                Intent intent = new Intent(MenuActivity.this,GlobalWarmingMenuActivity.class);
                startActivity(intent);
            }else if(view == btSaveTheWorld){
                Intent intent = new Intent(MenuActivity.this,SaveTheWorldActivity.class);
                startActivity(intent);
            }else if(view == btTest){
                Intent intent = new Intent(MenuActivity.this,TestActivity.class);
                startActivity(intent);
            }
        }
    };

}
