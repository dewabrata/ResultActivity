package com.juara.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4 extends AppCompatActivity {

    public static int RESULT_CODE =4;
    String from ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        setTitle("Activity D");
        from = getIntent().getStringExtra("from");
        Button btnFinish = findViewById(R.id.btnNext);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closed();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        closed();
    }


    public void closed(){
        Intent intent = new Intent();
        if(from.equalsIgnoreCase("c1")) {

            intent.putExtra("from", "d1");
        }else{
            intent = new Intent();
            intent.putExtra("from", "d2");

        }
        setResult(RESULT_CODE,intent);
        finish();
    }
}
