package com.example.als.convertendo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityMedida extends AppCompatActivity {
    RadioButton rbDeMilhas, rbDeQuilometros, rbDePes, rbParaMilhas, rbParaQuilometros, rbParaPes;
    EditText valor;
    Button btnCalcular;
    TextView tvResposta;
    Conversao con = new Conversao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_medida);

        valor = findViewById(R.id.editTextMedida);
        rbDeMilhas = findViewById(R.id.milhasEntrada);
        rbDeQuilometros = findViewById(R.id.kmEntrada);
        rbDePes = findViewById(R.id.pesEntrada);
        rbParaMilhas = findViewById(R.id.milhasSaida);
        rbParaQuilometros = findViewById(R.id.kmSaida);
        rbParaPes = findViewById(R.id.pesSaida);
        btnCalcular = findViewById(R.id.butaoCalcularMedida);
        tvResposta = findViewById(R.id.textViewRespostaMedida);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = Double.parseDouble(valor.getText().toString());
                if (valor.getText().length()!=0) {
                    if (rbParaPes.isChecked() || rbParaMilhas.isChecked() || rbParaQuilometros.isChecked() && rbDeMilhas.isChecked() || rbDePes.isChecked() || rbDeQuilometros.isChecked()) {
                        if (rbDeMilhas.isChecked()) {
                            if (rbParaQuilometros.isChecked()) {
                                tvResposta.setText(con.mostrar(con.milhasQuilometros(num)));
                            } else if (rbParaPes.isChecked()) {
                                tvResposta.setText(con.mostrar(con.milhasPes(num)));
                            } else {
                                tvResposta.setText(con.mostrar(num));
                            }
                        } else if (rbDeQuilometros.isChecked()) {
                            if (rbParaMilhas.isChecked()) {
                                tvResposta.setText(con.mostrar(con.quilometrosMilhas(num)));
                            } else if (rbParaPes.isChecked()) {
                                tvResposta.setText(con.mostrar(con.quilometrosPes(num)));
                            } else {
                                tvResposta.setText(con.mostrar(num));
                            }
                        } else if (rbDePes.isChecked()) {
                            if (rbParaMilhas.isChecked()) {
                                tvResposta.setText(con.mostrar(con.pesMilhas(num)));
                            } else if (rbParaQuilometros.isChecked()) {
                                tvResposta.setText(con.mostrar(con.pesQuilometros(num)));
                            } else {
                                tvResposta.setText(con.mostrar(num));
                            }
                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        int tempo = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, "Seleção de botão obrigatório", tempo);
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

        valor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    valor.setText("");
                }
                return false;
            }
        });

    }
}
