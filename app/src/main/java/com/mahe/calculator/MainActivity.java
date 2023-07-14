package com.mahe.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button AC,Power,Back,Div,Mul,Sub,Sum,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Ans,Equal,Point;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        AC=findViewById(R.id.ac);
        Power=findViewById(R.id.power);
        Back=findViewById(R.id.back);
        Div=findViewById(R.id.div);
        Mul=findViewById(R.id.mul);
        Sub=findViewById(R.id.sub);
        Sum=findViewById(R.id.sum);
        One=findViewById(R.id.one);
        Two=findViewById(R.id.two);
        Three=findViewById(R.id.three);
        Four=findViewById(R.id.four);
        Five=findViewById(R.id.five);
        Six=findViewById(R.id.six);
        Seven=findViewById(R.id.seven);
        Eight=findViewById(R.id.eight);
        Nine=findViewById(R.id.nine);
        Zero=findViewById(R.id.zero);
        Ans=findViewById(R.id.ans);
        Equal=findViewById(R.id.equal);
        Point=findViewById(R.id.point);
    }
    //add click listener for each button
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "AC":
                input="";
                break;
            case "ANS":
                input+=Answer;
                break;
            case "*":
                solve();
                input+="*";
                break;
            case "^":
                solve();
                input+="^";
                break;
            case "=":
                solve();
                Answer=input;
                break;
            case "--":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    private void solve(){
        if(input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input =mul+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        else if(input.split("/").length==2){
            String number[]=input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        else if(input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = pow+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        else if(input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        else if(input.split("-").length>1){
            String number[]=input.split("-");
            //to subtract negative number like -9-8
            if(number[0]=="" && number.length==2){
                number[0]=0+"";
            }
            try {
                double sub = 0;
                if(number.length==2) {
                    sub = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                }
                else if(number.length==3) {
                    sub = -Double.parseDouble(number[1])-Double.parseDouble(number[2]);
                }
                input = sub+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        //to remove the last digit .0 from integer result like 5.0
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        Screen.setText(input);
    }
}

