package com.juara.resultactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {

    public static int REQUEST_CODE = 3;
    public static int RESULT_CODE = 3;

    String from ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        setTitle("Activity C");

        from = getIntent().getStringExtra("from");
        Button btnFinish = findViewById(R.id.btnNext);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(from.equalsIgnoreCase("")) {
                    Intent intent = new Intent(Activity3.this, Activity4.class);
                    intent.putExtra("from", "c1");
                    startActivityForResult(intent, REQUEST_CODE);
                }else{
                    Intent intent = new Intent(Activity3.this, Activity4.class);
                    intent.putExtra("from", "c3");
                    startActivityForResult(intent, REQUEST_CODE);
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == Activity4.RESULT_CODE){
            if(data.getStringExtra("from").equalsIgnoreCase("d1")){

                Intent intent = new Intent();
                        intent.putExtra("from","c2");
                setResult(RESULT_CODE,intent);
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
