package br.com.fatec;

import java.util.*;

public class TesteCarro {
    public static void main(String[] args) {

        List<Carro> carros = new ArrayList<Carro>();

        var c1 = new Carro("Grotti Cheetah", 500);
        var c2 = new Carro("Bravado Banshee", 400);
        var c3 = new Carro("Dinka Blista", 200);
        carros.add(c1);
        carros.add(c2);
        carros.add(c3);

        System.out.println(c1 + " faz a volta em " + c1.getTempoDeVolta()+"s");
        System.out.println(c2 + " faz a volta em " + c2.getTempoDeVolta()+"s");
        System.out.println(c3 + " faz a volta em " + c3.getTempoDeVolta()+"s");


    }
}
