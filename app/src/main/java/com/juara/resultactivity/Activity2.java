package com.juara.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    public static int RESULT_CODE = 1;
    int nilai =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        nilai = getIntent().getIntExtra("nilai",0);

        nilai = tambah(nilai);

        Button btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("nilai", nilai);

                setResult(RESULT_CODE,intent);
                finish();
            }
        });
    }

    public int tambah(int x){
        return x+5;
    }
}
