package com.example.als.convertendo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMedida, btnMoeda, btnAngulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMedida = findViewById(R.id.butaoMedida);
        btnMoeda = findViewById(R.id.butaoMoeda);
        btnAngulo = findViewById(R.id.butaoAngulo);

        btnMedida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencaoMedida = new Intent(MainActivity.this,MainActivityMedida.class);
                MainActivity.this.startActivity(intencaoMedida);
            }
        });

        btnMoeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencaoMoeda = new Intent(MainActivity.this,MainActivityMoeda.class);
                MainActivity.this.startActivity(intencaoMoeda);
            }
        });

        btnAngulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencaoAngulo = new Intent(MainActivity.this,MainActivityAngulo.class);
                MainActivity.this.startActivity(intencaoAngulo);

            }
        });
    }
}
