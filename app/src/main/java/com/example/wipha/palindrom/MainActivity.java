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

               String input = inputEditText.getText().toString();

                if(isPalindrom(input)){
                    resultTextView.setText("Das Wort "+input+" ist ein Palindrom!");
                }else{
                    resultTextView.setText("Das Wort "+input+" ist kein Palindrom!");
                }


            }
        });
    }


    // check if the given string is a palindrom ignoring lower and upper case respectively
    public static boolean isPalindrom(String str){
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }
}
