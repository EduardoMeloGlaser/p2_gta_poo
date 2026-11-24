package br.com.fatec;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public class Carro{
    private final static int SEM_POTENCIA_SUFICIENTE = -1;
    private final static int POTENCIA_MINIMA_PRA_VOLTA = 1;

    private String modelo;
    private int potencia;
    
    public int getTempoDeVolta(){
        if(potencia < POTENCIA_MINIMA_PRA_VOLTA) return SEM_POTENCIA_SUFICIENTE;
        return (30 + 6000/potencia);
    }

    @Override
    public String toString() {
        return String.format("%s (%d cv)", modelo, potencia);
    }
    
}
