package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaring each and every element
    EditText et_temp;
    RadioButton rd_btn_C;
    RadioButton rd_btn_F;
    Button btn_calculate;
    TextView tv_ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning IDs to each and every element
        et_temp = findViewById(R.id.et_temp);
        rd_btn_C = findViewById(R.id.rd_btn_C);
        rd_btn_F = findViewById(R.id.rd_btn_F);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_ans = findViewById(R.id.tv_answer);

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        btn_calculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                calculateAnswer();
//            }
//        });
//    }


    //if a user clicks on the cal button this method should be called
    public void calculateAnswer(View view){

        Calculations cal = new Calculations();
        String value = et_temp.getText().toString();

        //checking it is empty
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the temparature", Toast.LENGTH_SHORT).show();
        }

        else {
            //assingnig to a float var
            Float temp = Float.parseFloat(value);
            if(rd_btn_F.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }else if(rd_btn_C.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            }else{
                Toast.makeText(this, "Select a radio button", Toast.LENGTH_SHORT).show();
                temp = 0.00f;
            }

            tv_ans.setText(new Float(temp).toString());

        }

    }

}