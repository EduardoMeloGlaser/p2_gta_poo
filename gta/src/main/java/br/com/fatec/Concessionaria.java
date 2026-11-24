package br.com.fatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Concessionaria {
    private List<Carro> estoque = new ArrayList<Carro>();
    private Random gerador = new Random();

    public Concessionaria(){
        String modelo[] = {
            "Truffade Adder", "Grotti Cheetah", "Pegassi Infernus", "Vapid Dominator",
            "Bravado Banshee","Declasse Vigero", "Karin Sultan", "Dinka Blista"
        };

        int potencia[] = {520, 500, 480, 420, 400, 350, 300, 200};
        
        for(int i = 0; i< modelo.length; i++){
            var carro = new Carro(modelo[i], potencia[i]);
            estoque.add(carro);
        }
    }

    public Carro sortear(){
        if(restantes() == 0){
            return null;
        }
        var carroAleatorio = gerador.nextInt(restantes());
        Carro carroAux = estoque.get(carroAleatorio);
        estoque.remove(carroAleatorio);
        return carroAux;
    }

    public int restantes(){
        return estoque.size();
    }
}
