package br.com.fatec;

import java.util.*;

public class TesteCarro {
    public static void main(String[] args) {

        List<Carro> carros = new ArrayList<Carro>();

        var c1 = new Carro("Grotti Cheetah", 500);
        var c2 = new Carro("Bravado Banshee", 400);
        var c3 = new Carro("Dinka Blista", 200);
        var c4 = new Carro("Grotti Cheetah", 500);
        var c5 = new Carro("Pegassi Infernus", 500);
        var c6 = new Carro("Ocelot Pariah", 500);
        carros.add(c1);
        carros.add(c2);
        carros.add(c3);
        carros.add(c4);
        carros.add(c5);

        System.out.println(c1 + " faz a volta em " + c1.getTempoDeVolta()+"s");
        System.out.println(c2 + " faz a volta em " + c2.getTempoDeVolta()+"s");
        System.out.println(c3 + " faz a volta em " + c3.getTempoDeVolta()+"s");
    

        // a        


        System.out.println("Iguais? " + c1.equals(c4));
        System.out.println("Iguais? " + c1.equals(c5));

        // b
        List<Carro> novaListaCarro = new ArrayList<Carro>();
        
        novaListaCarro.add(c6);
        novaListaCarro.add(c3);
        novaListaCarro.add(c2);
        novaListaCarro.add(c1);
        Collections.sort(novaListaCarro);
        System.out.println(novaListaCarro+"\n");

    }
}
