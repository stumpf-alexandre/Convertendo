package com.example.als.convertendo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityMoeda extends AppCompatActivity {

    EditText etReal;
    EditText etDolar;
    Button btnConverter;
    Dindin din = new  Dindin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_moeda);

        etReal = findViewById(R.id.editTextReal);
        etDolar = findViewById(R.id.editTextDolar);
        btnConverter = findViewById(R.id.btnCalcularMoeda);


        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etDolar.getText().length()!=0 || etReal.getText().length()!=0){
                    if (etReal.getText().length()!=0 && etDolar.getText().length()==0){
                        double real = Double.parseDouble(etReal.getText().toString());
                        etDolar.setText(din.mostrar(din.realDolar(real)));
                    }
                    else if (etDolar.getText().length()!=0 && etReal.getText().length()==0){
                        double dolar = Double.parseDouble(etDolar.getText().toString());
                        etReal.setText(din.mostrar(din.dolarReal(dolar)));
                    }
                    else {
                        Context context = getApplicationContext();
                        int tempo = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, "Preencha apenas um campo", tempo);
                        toast.show();
                    }
                }
                else {
                    Context context = getApplicationContext();
                    int tempo = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Preenchimento de campo obrigatório", tempo);
                    toast.show();
                }
            }
        });

        etReal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    etReal.setText("");
                }
                return false;
            }
        });

        etDolar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    etDolar.setText("");
                }
                return false;
            }
        });
    }
}
