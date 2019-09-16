package com.example.currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    final double eurConversion = .90299;
    final double mxnConversion = 19.4448;
    final double cadConversion = 1.32321;
    double amountEntered;
    double amountConverted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText amount = (EditText) findViewById(R.id.inputAmount);
        final RadioButton toEuros = (RadioButton) findViewById(R.id.radToEuros);
        final RadioButton toPesos = (RadioButton) findViewById(R.id.radToPesos);
        final RadioButton toCAD = (RadioButton) findViewById(R.id.radToCAD);
        final TextView result = (TextView) findViewById(R.id.resultOutput);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountEntered = Double.parseDouble(amount.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                if(toEuros.isChecked()){
                    if(amountEntered < 100000){
                        amountConverted = amountEntered * eurConversion;
                        result.setText(currency.format(amountConverted) + " EUR");
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter an amount less that $100,000.", Toast.LENGTH_LONG).show();
                    }
                }
                if(toPesos.isChecked()){
                    if(amountEntered < 100000){
                        amountConverted = amountEntered * mxnConversion;
                        result.setText(currency.format(amountConverted) + " MXN");
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter an amount less that $100,000.", Toast.LENGTH_LONG).show();
                    }
                }
                if(toCAD.isChecked()){
                    if(amountEntered < 100000){
                        amountConverted = amountEntered * cadConversion;
                        result.setText(currency.format(amountConverted) + " CAD");
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter an amount less that $100,000.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
