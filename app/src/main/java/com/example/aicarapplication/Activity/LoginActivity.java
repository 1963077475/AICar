package com.example.aicarapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aicarapplication.R;
import com.example.aicarapplication.data.ApiConfig;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EuserName,Epassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       initView();


    }
    private void initView(){
        EuserName = findViewById(R.id.editTextName);
        Epassword=findViewById(R.id.editTextPassword);
        button=findViewById(R.id.loginBtn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBtn:
                Editable userName = EuserName.getText();
                Editable password = Epassword.getText();
                Log.d("TAG", "onClick: "+userName+":"+password);
                if(userName.toString().equals("user")&&password.toString().equals("123456")){

//                    Intent intent=new Intent(this,MainActivity.class);
//                    intent.putExtra("userName",userName);
//                    startActivity(intent);
                   ApiConfig.UserName = userName.toString();
                   finish();
                }else {
                    Toast.makeText(this, "登陆失败" , Toast.LENGTH_SHORT).show();
                }



        }

    }
}
