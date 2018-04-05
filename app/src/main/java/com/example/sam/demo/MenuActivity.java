package com.example.sam.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{


    //Declarations
    TextView welcome_text;
    Button btn_account;
    Button btn_pt;
    Button btn_view;
    Button btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Linking
        welcome_text = findViewById(R.id.textView_welcome);
        btn_account = findViewById(R.id.button_account);
        btn_pt = findViewById(R.id.button_pt);
        btn_view = findViewById(R.id.button_view);
        btn_exit = findViewById(R.id.button_exit);

        //OnClick Listeners
        btn_account.setOnClickListener(this);
        btn_pt.setOnClickListener(this);
        btn_view.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        //Your account button
        if (view.getId()==R.id.button_account)
        {
            startActivity(new Intent(MenuActivity.this, AccountActivity.class));
        }

        //PT button
        if (view.getId()==R.id.button_pt)
        {
            startActivity(new Intent(MenuActivity.this, InputActivity2.class));
        }

        //View Button
        if (view.getId()==R.id.button_view)
        {
            startActivity(new Intent(MenuActivity.this, ObserveActivity.class));
        }


        //Exit Button
        if (view.getId()==R.id.button_exit)
        {
            startActivity(new Intent(MenuActivity.this, MainActivity.class));
        }
    }
}
