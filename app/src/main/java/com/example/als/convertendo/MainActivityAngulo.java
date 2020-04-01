package com.example.als.convertendo;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class MainActivityAngulo extends AppCompatActivity {
    RadioButton rbAngSen, rbAngCos, rbAngTg;
    EditText etAngulo;
    TextView tvRespostaAngulo;
    Button btnCalcular;
    Angulado angulo = new Angulado();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_angulo);

        rbAngSen = findViewById(R.id.anguloSeno);
        rbAngCos = findViewById(R.id.anguloCosseno);
        rbAngTg = findViewById(R.id.anguloTangente);
        etAngulo = findViewById(R.id.editTextAngulo);
        tvRespostaAngulo = findViewById(R.id.textViewRespostaAngulo);
        btnCalcular = findViewById(R.id.btnCalcularAngulo);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAngulo.getText().length() != 0){
                    if (rbAngTg.isChecked() || rbAngSen.isChecked() || rbAngCos.isChecked()){
                        double ang = Double.parseDouble(etAngulo.getText().toString());
                        if (rbAngSen.isChecked()){
                            tvRespostaAngulo.setText(angulo.mostrar(angulo.anguloSen(ang)));
                        }
                        else if (rbAngCos.isChecked()){
                            tvRespostaAngulo.setText(angulo.mostrar(angulo.anguloCos(ang)));
                        }
                        else if (rbAngTg.isChecked()){
                            tvRespostaAngulo.setText(angulo.mostrar(angulo.anguloTan(ang)));
                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        int tempo = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,"Seleção de botão obrigatório" , tempo);
                        toast.show();
                    }
                }else {
                    Context context = getApplicationContext();
                    int tempo = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Preenchimento de campo obrigatório", tempo);
                    toast.show();
                }
            }
        });

        etAngulo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    etAngulo.setText("");
                }
                return false;
            }
        });
    }
}