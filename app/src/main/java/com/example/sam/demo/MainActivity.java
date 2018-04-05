package com.example.sam.demo;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import java.util.Scanner;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Declarations
    Button btn_login;
    Button btn_signup;
    ImageView imageView_logo;
    TextView errorText;
    EditText edit_user;
    EditText edit_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking
        btn_login = findViewById(R.id.button_login);
        btn_signup = findViewById(R.id.button_reg);
        imageView_logo = findViewById(R.id.imageLogo);
        errorText = findViewById(R.id.textView_error);
        edit_user = findViewById(R.id.editText_user);
        edit_pass = findViewById(R.id.editText_pass);

        //Onclick listeners
        btn_login.setOnClickListener(this);
        btn_signup.setOnClickListener(this);

    }


    @Override
    public void onClick(View view)
    {
        //String settings
        String username_log = edit_user.getText().toString();
        String password_log = edit_pass.getText().toString();

        //Login Button
        if(view.getId()== R.id.button_login)
        {

            if (username_log.equals("user1") && password_log.equals("pass1"))
            {
                errorText.setText(R.string.loginSuccess);
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }
            else if (username_log.equals("user2") && password_log.equals("pass2"))
            {
                errorText.setText(R.string.loginSuccess);
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }
            else if (username_log.equals("user3") && password_log.equals("pass3"))
            {
                errorText.setText(R.string.loginSuccess);
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }
            else if (username_log.equals("user4") && password_log.equals("pass4"))
            {
                errorText.setText(R.string.loginSuccess);
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }
            else if (username_log.equals("user5") && password_log.equals("pass5"))
            {
                errorText.setText(R.string.loginSuccess);
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
            }
            else
            {
                errorText.setText(R.string.loginFail);
            }


        }

        //Navigation to Sign In
        if(view.getId()== R.id.button_reg)
        {
            startActivity(new Intent(MainActivity.this,signUpActivity.class));

        }

    }
}

//public class DatabaseManager extends SQLiteOpenHelper
