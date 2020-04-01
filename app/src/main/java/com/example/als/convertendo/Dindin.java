package com.example.als.convertendo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

/**
 * Created by als on 04/12/2017.
 */

public class Dindin {
    public String mostrar(Double valor){
        NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols());
        return nf.format(valor).toString();
    }

    public double realDolar(Double valor){
        valor = valor / 3.2562;
        return valor;
    }

    public double dolarReal(Double valor){
        valor = valor * 3.2562;
        return valor;
    }

}
