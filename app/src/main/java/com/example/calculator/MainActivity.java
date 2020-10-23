package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText numberField;

    double a = 0;
    double b = 0;
    char s = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberField = (EditText) findViewById(R.id.numberField);
    }

    public void numberClicked(View view) {

        Button button = (Button) view;

        if (numberField.getText().toString().equals("Mistake")) {
            numberField.setText(null);
        }

        numberField.append(button.getText());

        if (button.getText().equals("AC")) {
            a = b = 0;
            s = ' ';
            numberField.setText(null);
        }

        if (!numberField.getText().toString().equals("-")) {
            if ((button.getText().equals("*") || button.getText().equals("-") || button.getText().equals("+") || button.getText().equals("/"))) {
                s = button.getText().toString().charAt(0);
                a = Double.parseDouble(numberField.getText().toString().substring(0, numberField.getText().toString().length() - 1));
                numberField.setText("");
            }
        }
        if (button.getText().equals("=")) {
            b = Double.parseDouble(numberField.getText().toString());
            try {
                numberField.setText(String.valueOf(calc()));
            } catch (Exception e) {
                numberField.setText(e.getMessage());
                a = b = 0;
                s = ' ';
            }
        }
    }

    private double calc() throws Exception {
        switch (s) {

            case '+': {
                return a + b;
            }
            case '-': {
                return a - b;
            }
            case '*': {
                return a * b;
            }
            case '/': {
                if (b == 0) throw new Exception("Mistake");
                return a / b;
            }
        }
        return 0;
    }
}