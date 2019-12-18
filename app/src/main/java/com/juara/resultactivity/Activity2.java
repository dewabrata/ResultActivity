package com.juara.resultactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    public static int REQUEST_CODE = 2;
    public static int RESULT_CODE = 2;
    int nilai =0 ;
    String from ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("Activity B");
        nilai = getIntent().getIntExtra("nilai",0);

        nilai = tambah(nilai);

        Button btnFinish = findViewById(R.id.btnNext);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this,Activity3.class);
                intent.putExtra("from",from);
                startActivityForResult(intent,REQUEST_CODE);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode==Activity3.RESULT_CODE){
            if(data.getStringExtra("from").equalsIgnoreCase("c2")){
                from ="c2";
            }
        }
    }

    public int tambah(int x){
        return x+5;
    }
}
