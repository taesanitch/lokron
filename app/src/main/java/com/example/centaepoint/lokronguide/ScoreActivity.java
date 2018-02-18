package com.example.centaepoint.lokronguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    int score,size;
    TextView tvScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        score = intent.getIntExtra("score",0);
        size = intent.getIntExtra("size",0);
        tvScore = (TextView)findViewById(R.id.tvScore);
        tvScore.setText("Score : "+ score+"/"+size);

    }
}
