package com.example.centaepoint.lokronguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class GlobalWarmingMenuActivity extends AppCompatActivity {
    View btGlobalWarming,btCause,btEffect,btOtherCause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_warming_menu);
        InitInstance();
    }

    private void InitInstance() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btGlobalWarming = (View)findViewById(R.id.btGlobalWarming);
        btCause = (View)findViewById(R.id.btCause);
        btEffect = (View)findViewById(R.id.btEffect);
        btOtherCause = (View)findViewById(R.id.btOtherCause);

        btGlobalWarming.setOnClickListener(listener);
        btCause.setOnClickListener(listener);
        btEffect.setOnClickListener(listener);
        btOtherCause.setOnClickListener(listener);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btGlobalWarming){
                Intent intent = new Intent(GlobalWarmingMenuActivity.this,GlobalWarmingActivity.class);
                startActivity(intent);
            }else if(view == btCause){
                Intent intent = new Intent(GlobalWarmingMenuActivity.this,CauseActivity.class);
                startActivity(intent);
            }else if(view == btEffect){
                Intent intent = new Intent(GlobalWarmingMenuActivity.this,EffectActivity.class);
                startActivity(intent);
            }else if(view == btOtherCause){
                Intent intent = new Intent(GlobalWarmingMenuActivity.this,OtherCauseActivity.class);
                startActivity(intent);
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(GlobalWarmingMenuActivity.this,MenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
