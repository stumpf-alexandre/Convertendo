package com.example.als.convertendo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

/**
 * Created by als on 04/12/2017.
 */

public class Angulado {
    public String mostrar(Double valor){
        NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols());
        return nf.format(valor).toString();
    }

    public double anguloTan(Double valor){
        valor = (Math.tan(valor * 2.0 * Math.PI / 360));
        return valor;
    }

    public double anguloCos(Double valor){
        valor = (Math.cos(valor * Math.PI / 180));
        return valor;
    }

    public double anguloSen(Double valor){
        valor = (Math.sin(valor * 2.0 * Math.PI / 360.0));
        return valor;
    }
}
