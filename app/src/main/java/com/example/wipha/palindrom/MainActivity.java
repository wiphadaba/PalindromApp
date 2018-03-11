package com.example.wipha.palindrom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button checkButton = findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputEditText = findViewById(R.id.inputEditText);
                TextView resultTextView = findViewById(R.id.resultTextView);
                TextView messageTextView = findViewById(R.id.messageTextView);

                resultTextView.setText("");
                messageTextView.setText("");
                String input = inputEditText.getText().toString();
                boolean constraints = true;

                if(input.isEmpty()){
                    messageTextView.setText("Geben Sie bitte ein String ein.");
                    constraints = false;
                }else if(input.length()<5){
                    messageTextView.setText("Der String muss mindestens 5 Zeichen haben.");
                    constraints = false;
                }else if(!regexForString(input)){
                    messageTextView.setText("Der String darf nur aus Buchstaben und Zahlen bestehen.");
                    constraints =false;
                }

                if(constraints) {
                    if (isPalindrom(input)) {
                        resultTextView.setText("Der String " + input + " ist ein Palindrom!");
                    } else {
                        resultTextView.setText("Der String " + input + " ist kein Palindrom!");
                    }
                }


            }
        });
    }


    // check if the given string is a palindrom ignoring lower and upper case respectively
    public static boolean isPalindrom(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }

    public static boolean regexForString(String str){
        return str.matches("[A-Za-z0-9]+");
    }

}
