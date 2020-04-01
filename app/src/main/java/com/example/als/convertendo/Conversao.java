package com.example.als.convertendo;

import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by als on 30/11/2017.
 */

public class Conversao {

    public String mostrar(Double valor){
        return valor.toString();
    }

    public double milhasQuilometros(Double valor){
        valor = valor * 1.60934;
        return valor;
    }

    public double milhasPes(Double valor){
        valor = valor * 5280;
        return valor;
    }

    public double quilometrosMilhas(Double valor){
        valor = valor * 0.621371;
        return valor;
    }

    public double quilometrosPes(Double valor){
        valor = valor * 3280.84;
        return valor;
    }

    public double pesMilhas(Double valor){
        valor = valor * 0.000189394;
        return valor;
    }

    public double pesQuilometros(Double valor){
        valor = valor * 0.0003048;
        return valor;
    }
}
