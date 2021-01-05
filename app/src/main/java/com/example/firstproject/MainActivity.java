package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String strToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            display.setShowSoftInputOnFocus(false);
        }

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString()))
                    display.setText("");
            }
        });
    }

     private void updateText(String strToAdd) {
         this.strToAdd = strToAdd;
         String oldStr = display.getText().toString();
         int cursorPos = display.getSelectionStart();
         String LeftStr = oldStr.substring(0, cursorPos);
         String rightStr = oldStr.substring(cursorPos);
         if (getString(R.string.display).equals(display.getText().toString()))
             display.setText(strToAdd);
         else {
             display.setText(String.format("%s%s%s", LeftStr, strToAdd, rightStr));
         }
        display.setSelection(cursorPos +1);
     }


    public void zeroBN(View view) {
        updateText("0");

    }
    public void oneBN(View view) {
        updateText("1");

    }
    public void twoBN(View view) {
        updateText("2");

    }
    public void threeBN(View view) {
        updateText("3");

    }
    public void fourBN(View view) {
        updateText("4");

    }
    public void fiveBN(View view) {
        updateText("5");

    }
    public void sixBN(View view) {
        updateText("6");

    }
    public void sevenBN(View view) {
        updateText("7");

    }
    public void eightBN(View view) {
        updateText("8");

    }
    public void nineBN(View view) {
        updateText("9");

    }
    public void clearBN(View view) {
        updateText("");

    }
    public void parenthesisBN(View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i + 1).equals(")")) {
                closedPar += 1;
            }
        }
        if (openPar == closedPar || display.getText().toString().substring(textLen - 1, textLen).equals("("))
            updateText(strToAdd:"(");
        display.setSelection(cursorPos + 1);


            else if (closedPar < openPar || !display.getText().toString().substring(textLen-1, textLen).equals(")"))
            updateText(strToAdd:")");
            display.setSelection(cursorPos + 1);
    }
    public void plusBN(View view) {
        updateText("+");

    }
    public void minusBN(View view) {
        updateText("-");

    }
    public void pointBN(View view) {
        updateText(".");

    }
    public void multiplyBN(View view) {
        updateText("*");


    }
    public void divideBN(View view) {
        updateText("/");

    }

     public void backspaceBN(View view) {
        int cursorPos = display.getSelectionStart();
       int textLen = display.getText().length();



        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace( cursorPos -1, cursorPos, tb: "");
            display.setText(selection);
            display.setSelection(cursorPos -1);


    }
        public void EqualsBN(View view) {
            String userExp = display.getText().toString();

            userExp = userExp.replaceAll(regex: "÷", replacement: "/");

            expression exp = new Expression(userExp);

            string result = string.valueOf(exp.calculate());

            display.setText(result);
            display.setSelection(result.length());










}