package com.juara.resultactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {

    public static int REQUEST_CODE=9;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btnNext);
        setTitle("Activity A");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this,Activity2.class);
                intent.putExtra("nilai",0);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == Activity2.RESULT_CODE){
            Toast.makeText(Activity1.this,"Ini adalah nilai dari activity 2 ="+data.getIntExtra("nilai",0),Toast.LENGTH_LONG).show();
        }

    }
}
