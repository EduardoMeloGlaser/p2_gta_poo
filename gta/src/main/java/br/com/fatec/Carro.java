package br.com.fatec;

import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public class Carro implements Comparable <Carro>{
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

    @Override
    public boolean equals(Object obj) {
        Carro outro = (Carro) obj;
        return this.modelo.equals(outro.modelo);
    }
    @Override
    public int compareTo(Carro outro) {
        return Comparator.comparingInt(Carro :: getPotencia)
        .reversed()
        .thenComparing(Carro :: getModelo)
        .compare(this, outro);
    }
    
}
