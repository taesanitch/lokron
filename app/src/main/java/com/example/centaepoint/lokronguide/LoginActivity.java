package com.example.centaepoint.lokronguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btLogin;
    private EditText etName;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!Datasource.getInstance().getName(LoginActivity.this).equals("")){
            Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
            startActivity(intent);
            finish();
        }
        initInstance();
    }

    private void initInstance() {
        btLogin  = (Button)findViewById(R.id.btLogin);
        etName = (EditText)findViewById(R.id.etName);
        btLogin.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btLogin){
                name = etName.getText().toString();
                if(name.equals("")){
                    Toast.makeText(LoginActivity.this,"Please input your name !!",Toast.LENGTH_LONG).show();
                }else{
                    Datasource.getInstance().setName(LoginActivity.this,name);
                    Toast.makeText(LoginActivity.this,"Welcome "+ name,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };

}
