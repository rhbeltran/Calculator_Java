package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Double number1;
    String operation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView screen = findViewById(R.id.contador);
        Button btnButton0 = findViewById(R.id.btnNum0);
        Button btnButton1 = findViewById(R.id.btnNum1);
        Button btnButton2 = findViewById(R.id.btnNum2);
        Button btnButton3 = findViewById(R.id.btnNum3);
        Button btnButton4 = findViewById(R.id.btnNum4);
        Button btnButton5 = findViewById(R.id.btnNum5);
        Button btnButton6 = findViewById(R.id.btnNum6);
        Button btnButton7 = findViewById(R.id.btnNum7);
        Button btnButton8 = findViewById(R.id.btnNum8);
        Button btnButton9 = findViewById(R.id.btnNum9);

        Button ac = findViewById(R.id.btnClear);
        ImageButton del = findViewById(R.id.btnDel);
        Button dividir = findViewById(R.id.btnDivide);
        Button multiplicar = findViewById(R.id.btnMultiply);
        Button restar = findViewById(R.id.btnMinus);
        Button sumar = findViewById(R.id.btnPlus);
        Button punto = findViewById(R.id.btnPunto);
        Button igual = findViewById(R.id.btnEqual);

        ac.setOnClickListener(view -> {
            number1 = (double) 0;
            screen.setText("0");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(btnButton0);
        nums.add(btnButton1);
        nums.add(btnButton2);
        nums.add(btnButton3);
        nums.add(btnButton4);
        nums.add(btnButton5);
        nums.add(btnButton6);
        nums.add(btnButton7);
        nums.add(btnButton8);
        nums.add(btnButton9);

        for (Button b : nums){
            b.setOnClickListener(view ->{
                if (!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString() + b.getText().toString());
                }else{
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(dividir);
        opers.add(multiplicar);
        opers.add(restar);
        opers.add(sumar);
        for (Button b : opers){
            b.setOnClickListener(view ->{
                number1 = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        del.setOnClickListener(view ->{
            String num = screen.getText().toString();
            if (num.length()>1){
                screen.setText(num.substring(0, num.length()-1));
            } else if (num.length()==1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        punto.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString() + ".");
            }
        });

        igual.setOnClickListener(v -> {
            double number2 = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = number1/number2;
                    break;
                case "*":
                    result = number1*number2;
                    break;
                case "-":
                    result = number1-number2;
                    break;
                default:
                    result = number1+number2;
            }
            screen.setText(String.valueOf(result));
            number1 = result;
        });


    }




}