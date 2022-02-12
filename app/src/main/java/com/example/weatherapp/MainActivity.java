package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText etpass,etusernm;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference reference=database.getReference("https://weatherapp-fcc44-default-rtdb.asia-southeast1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin=findViewById(R.id.btnlogin);
        etpass=findViewById(R.id.etpass);
        etusernm=findViewById(R.id.etusernm);
        btnlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=etusernm.getText().toString();
                String password=etpass.getText().toString();
                if(username.equals("ap")&&password.equals("ap"))
                {
                    Toast.makeText(MainActivity.this, "success!!", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),HomeScreen.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Inavlid credentials!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}