package com.example.user54.InventoryApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user54.InventoryApp.R;

public class LogIn extends AppCompatActivity {

    EditText userName, password;
    Button logIn;
    TextView messageLogIn, passStar, userStar,onIntent;
    importJson json1;
    CheckBox design;
    public static TextView intentControl;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(controll.isYellow){
            setContentView(R.layout.log_activaty_yellow);
        }else{
            setContentView(R.layout.log_activaty);
        }



        design=(CheckBox)findViewById(R.id.design);
        design.setVisibility(View.GONE);
            if(controll.isYellow){
                design.setChecked(true);
            }else{
                design.setChecked(false);
            }
        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(design.isChecked()){
                    if(controll.isYellow){

                    }else{
                        finish();
                        Intent intent=new Intent(LogIn.this,LogIn.class);
                        startActivity(intent);
                    }
                    controll.isYellow=true;
                }else{

                    if(controll.isYellow){
                        finish();
                        Intent intent=new Intent(LogIn.this,LogIn.class);
                        startActivity(intent);
                    }else{

                    }
                    controll.isYellow=false;
                }
            }
        });

        logIn = (Button) findViewById(R.id.log);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.passwordLog);
        messageLogIn = (TextView) findViewById(R.id.message);
        passStar = (TextView) findViewById(R.id.pasStar);
        userStar = (TextView) findViewById(R.id.userStar);
        onIntent=(TextView) findViewById(R.id.onIntent);

//        json1 = new importJson();
//        json1.execute();


        onIntent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(onIntent.getText().toString().equals("@")&&!onIntent.getText().toString().equals("")){
                    Intent collectIntent = new Intent(LogIn.this, MainActivity2.class);
                    collectIntent.putExtra("USER_NAME", "");
                    finish();
                    startActivity(collectIntent);
                    onIntent.setText("1");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameL, passwordL;
                userNameL = userName.getText().toString();
                passwordL = password.getText().toString();


                if (!userNameL.equals("") || !passwordL.equals("")) {
                    if (!userNameL.equals("")) {
                        userStar.setText("");
                        if (!passwordL.equals("")) {
                            passStar.setText("");
                            if (logInAuthentication(userNameL, passwordL)) {
                                intentControl=onIntent;
//                                importJson sendCloud = new importJson(LogIn.this,"");
//                                sendCloud.startSending("ItemCard");
                                onIntent.setText("@");
                            } else {
                                messageLogIn.setText(getResources().getString(R.string.notcorrectusernamepass));
                            }
                        } else {
                            messageLogIn.setText(getResources().getString(R.string.interPass));
                            passStar.setText("*");
                        }
                    } else {
                        messageLogIn.setText(getResources().getString(R.string.enterUsername));
                        userStar.setText("*");
                    }
                } else {
                    messageLogIn.setText(getResources().getString(R.string.enterPassAndUser));
                    userStar.setText("*");
                    passStar.setText("*");
                }


            }
        });


    }

    boolean logInAuthentication(String userName, String password) {
        boolean Authentication = false;
        if (userName.equals("1") && password.equals("1")) {
            Authentication = true;
        }
//        else  {
//
//
//
//
//        }

        return Authentication;
    }



}
