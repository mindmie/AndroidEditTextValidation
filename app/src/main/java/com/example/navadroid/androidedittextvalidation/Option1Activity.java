package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Option1Activity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        bindView();
        initView();
    }

    private void bindView(){
        etName = (EditText) findViewById(R.id.et_name1);
        etPwd = (EditText) findViewById(R.id.et_pwd1);
        etEmail = (EditText) findViewById(R.id.et_email1);
        etPhone = (EditText) findViewById(R.id.et_phone1);
    }

    private void initView(){
        findViewById(R.id.btn_validate1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditText()&& validatePassword()&&validateEmail()&&validatePhone()) {
                    Toast.makeText(Option1Activity.this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
                    // SnackBar?
                }
                else{
                    Toast.makeText(Option1Activity.this, "Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This can be ignored
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This can be ignored
            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditText(); // OR validation can be specific (only for this EditText)
            }
        });

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validatePassword();

                // TODO: add your Password validation here
            }
        });

        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validatePhone();

            }
        });
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEmail();
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
