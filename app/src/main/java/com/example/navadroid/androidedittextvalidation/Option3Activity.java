package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Option3Activity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name3);
        etPwd = (EditText) findViewById(R.id.et_pwd3);
        etEmail = (EditText) findViewById(R.id.et_email3);
        etPhone = (EditText) findViewById(R.id.et_phone3);
    }

    private void initView(){
        // OnClickListener
        findViewById(R.id.btn_validate3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( validateEditText()&&validatePassword()&&validateEmail()&&validatePhone()){
                    Toast.makeText(Option3Activity.this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Option3Activity.this, "Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TextChangedListener
        etName.addTextChangedListener(new TextValidator(etName) {
            @Override
            public void validate(TextView textView, String text) {
//                if (etName.getText().toString().length() == 0) {
//                    etName.setError("Required");
//                }
                validateEditText();
            }
        });

        etPwd.addTextChangedListener(new TextValidator(etPwd) {
            @Override
            public void validate(TextView textView, String text) {
                // TODO: add your Password validation here
//                if (etPwd.getText().toString().length() < 6 || etPwd.getText().toString().length() > 10 ){
//                    etPwd.setError("Character should be 6 - 10");
//                }
//                else if (etPwd.getText().toString().matches("[!@#$%^&*?]+")){
//                    etPwd.setError("Character should be a-z ,A-Z , 0-9");
//                }
                validatePassword();

            }
        });

        etEmail.addTextChangedListener(new TextValidator(etEmail) {
            @Override
            public void validate(TextView textView, String text) {
//                if (etEmail.getText().toString().length() == 0 ){
//                    etEmail.setError("Please Enter");
//                }
//                else if (!etEmail.getText().toString().matches("[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+")){
//                    etEmail.setError("Example@email.com");
//                }
                validateEmail();
            }
        });
        etPhone.addTextChangedListener(new TextValidator(etPhone) {
            @Override
            public void validate(TextView textView, String text) {
//                if (etPhone.getText().toString().length() != 10){
//                    etPhone.setError("Please Enter phone number");
//                }
//                else if (!etPhone.getText().toString().matches("[0-9]+")){
//                    etPhone.setError("it's not phone number");
//                }
                validatePhone();

            }
        });
    }


    // To validate all EditTexts
    private boolean validateEditText(){
        boolean isValidated = true;
        if (etName.getText().toString().length() == 0) {
            etName.setError("Required");
            isValidated = false;
        }
        // TODO: add your EditText validation here

        return isValidated;
    }

    // to validate password
    private boolean validatePassword(){

        boolean isValidated = true;
        if (etPwd.getText().toString().length() < 6 || etPwd.getText().toString().length() > 10 ){
            etPwd.setError("Character should be 6 - 10");
            isValidated = false;
        }
        else if (etPwd.getText().toString().matches("[!@#$%^&*?]+")){
            etPwd.setError("Character should be a-z ,A-Z , 0-9");
            isValidated = false;
        }

        return isValidated;


    }
    // to validate email
    private boolean validateEmail(){

        boolean isValidate = true;
        if (etEmail.getText().toString().length() == 0 ){
            etEmail.setError("Please Enter");
            isValidate = false;
        }
        else if (!etEmail.getText().toString().matches("[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+")){
            etEmail.setError("Example@email.com");
            isValidate = false;
        }

        return isValidate;


    }
    // to validate phone
    private  boolean validatePhone(){
        boolean isValidated = true;
        if (etPhone.getText().toString().length() != 10){
            etPhone.setError("Please Enter phone number");
            isValidated = false;
        }
        else if (!etPhone.getText().toString().matches("[0-9]+")){
            etPhone.setError("it's not phone number");
            isValidated = false;
        }
        return isValidated;
    }
}
