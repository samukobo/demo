package com.example.sam.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Button;


public class signUpActivity extends AppCompatActivity implements View.OnClickListener{

    //Declarations
    TextView signUp_text;
    TextView allFields_text;
    Spinner memType_signUp;
    EditText editName_signUp;
    EditText editUser_signUp;
    EditText editPass_signUp;
    EditText editPass2_signUp;
    Button btn_signUpFinal;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Linking
        signUp_text = findViewById(R.id.textView_SignUp);
        allFields_text = findViewById(R.id.textView_warningFields);
        memType_signUp = findViewById(R.id.spinner_memType);
        editName_signUp = findViewById(R.id.editText_signUpName);
        editUser_signUp = findViewById(R.id.editText_signUpUser);
        editPass_signUp = findViewById(R.id.editText_signUpPass);
        editPass2_signUp = findViewById(R.id.editText_signUpPass2);
        btn_signUpFinal = findViewById(R.id.button_regreg);

        //OnClickListeners
        btn_signUpFinal.setOnClickListener(this);

        //Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.memberTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        memType_signUp.setAdapter(adapter);


    }

    //Button
    @Override
    public void onClick(View view)
    {
        String signUp_memType = memType_signUp.getSelectedItem().toString();
        String signUp_name = editName_signUp.getText().toString();
        String signUp_username = editUser_signUp.getText().toString();
        String signUp_pass = editPass_signUp.getText().toString();
        String signUp_pass2 = editPass2_signUp.getText().toString();

        if(view.getId()==R.id.button_regreg)
        {
            //Successful Login Attempts
            if (signUp_memType.equals("Faculty Member") && signUp_name!="" && signUp_username!="" && signUp_pass!="" && signUp_pass2!="" && signUp_pass.equals(signUp_pass2))
            {
                startActivity(new Intent(signUpActivity.this, MainActivity.class));
            }
            else if (signUp_memType.equals("Class President") && signUp_name!="" && signUp_username!="" && signUp_pass!="" && signUp_pass2!="" && signUp_pass.equals(signUp_pass2))
            {
                startActivity(new Intent(signUpActivity.this, MainActivity.class));
            }
            else if (signUp_memType.equals("Vice President") && signUp_name!="" && signUp_username!="" && signUp_pass!="" && signUp_pass2!="" && signUp_pass.equals(signUp_pass2))
            {
                startActivity(new Intent(signUpActivity.this, MainActivity.class));
            }

            //Errors
            else if (signUp_name.equals(""))
            {
                allFields_text.setText(R.string.signUpFail);
            }
            else if (signUp_username.equals(""))
            {
                allFields_text.setText(R.string.signUpFail);
            }
            else if (signUp_pass.equals(""))
            {
                allFields_text.setText(R.string.signUpFail);
            }
            else if (signUp_pass2.equals(""))
            {
                allFields_text.setText(R.string.signUpFail);
            }
            else if (signUp_pass!=signUp_pass2)
            {
                allFields_text.setText(R.string.signUpFailPass);
            }

        }
    }
}
