package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    TextView tv_ac;
    TextView query;
    TextView res;
    TextView div;
    TextView seven;
    TextView six;
    TextView five,four,three,two,one,eight,nine,equal;
    String value1="", value2="";
    String opr="";
    EditText crunchifyEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equal=findViewById(R.id.equal);
        tv_ac = findViewById(R.id.Ac);
        query=findViewById(R.id.tv_equation);
        res=findViewById(R.id.tv_result);
        div=findViewById(R.id.div);
        seven=findViewById(R.id.seven);
        six=findViewById(R.id.six);
        five=findViewById(R.id.five);
        four=findViewById(R.id.four);
        three=findViewById(R.id.three);
        two=findViewById(R.id.two);
        one=findViewById(R.id.one);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        View.OnClickListener equals = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1!=""&&value2!=""){
                    value1= nine.getText().toString();
                    
                }else{
                    value2= nine.getText().toString();
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener nineN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1= nine.getText().toString();
                    res.setText(value1);
                }else{
                    value2= nine.getText().toString();
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener eightN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1= eight.getText().toString();
                    res.setText(value1);
                }else{
                    value2= eight.getText().toString();
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener sev = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1= seven.getText().toString();
                    res.setText(value1);
                }else{
                    value2= seven.getText().toString();
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener sixN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1= "6";
                    res.setText(value1);
                }else{
                    value2= "6";
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener fiveN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1= "5";
                    res.setText(value1);
                }else{
                    value2= "5";
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener fourN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1= "4";
                    res.setText(value1);
                }else{
                    value2= "4";
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener threeN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1="3";
                    res.setText(value1);
                }else{
                    value2="3";
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener twoN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1= "2";
                    res.setText(value1);
                }else{
                    value2= "2";
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener oneN = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    value1="1";
                    res.setText(value1);
                }else{
                    value2= "1";
                    res.setText(value2);
                }
            }
        };
        View.OnClickListener clear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query.setText(" ");
                res.setText("");
            }
        };
        View.OnClickListener divide = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1==""){
                    res.setText("enter a number");
                }
                else{
                    res.setText(res+"a");
                    opr="/";
                }
            }
        };
        tv_ac.setOnClickListener(clear);
        div.setOnClickListener(divide);
        seven.setOnClickListener(sev);
        eight.setOnClickListener(eightN);
        nine.setOnClickListener(nineN);
        six.setOnClickListener(sixN);
        five.setOnClickListener(fiveN);
        four.setOnClickListener(fourN);
        three.setOnClickListener(threeN);
        two.setOnClickListener(twoN);
        one.setOnClickListener(oneN);
    }
}
