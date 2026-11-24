package br.com.fatec;

import java.util.Random;

public class TestePiloto {
    public static void main(String[] args) {
        var aleatorio = new Random();
        
        var c1 = new Carro("Grotti Cheetah", 500);
        var p1 = new Piloto("Lucia", c1);



        System.out.println(p1);
        p1.correr(aleatorio, false);
        System.out.println("Tempo sem nitro: "+ p1.getTempo()+"s");
        p1.correr(aleatorio, true);
        System.out.println("Tempo com nitro: "+ p1.getTempo()+"s");
        p1.somarPontos(10);
        p1.registrarVitoria();
        System.out.println(p1);

        var c2 = new Carro("Truffade Adder",520);
        var p2 = new Piloto("Lucia", c2);
        System.out.println("Iguais? "+ p1.equals(p2));
    }
}
