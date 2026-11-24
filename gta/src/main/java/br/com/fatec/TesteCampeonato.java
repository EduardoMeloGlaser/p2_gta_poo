package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class TesteCampeonato {
    public static void main(String[] args) {
        var c1 = new Carro("Grotti Cheetah", 500);
        var c2 = new Carro("Bravado Banshee", 400);
        var c3 = new Carro("Dinka Blista", 200);
        var c4 = new Carro("Grotti Cheetah", 500);

        var p1 = new Piloto("Lucia", c1);
        var p2 = new Piloto("Jason", c2);
        var p3 = new Piloto("Raul", c3);
        var p4 = new Piloto("Cal", c4);

        var novoP1 = new Piloto("Lucia", c4);
        var novoP2 = new Piloto("Boobie", c3);

        var campeonato1 = new Campeonato();
        campeonato1.inscrever(p1);
        campeonato1.inscrever(p2);
        campeonato1.inscrever(novoP1);
        campeonato1.inscrever(p3);
        campeonato1.inscrever(p4);
        campeonato1.inscrever(novoP2);

        List<Piloto> lista1 = new ArrayList<Piloto>();
        lista1.add(p1);
        lista1.add(p2);
        lista1.add(p3);
        lista1.add(p4);
        campeonato1.registrarCorrida(lista1);
    
        List<Piloto> lista2 = new ArrayList<Piloto>();
        lista2.add(p3);
        lista2.add(p4);
        lista2.add(p2);
        lista2.add(p1);
        campeonato1.registrarCorrida(lista2);

        List<Piloto> lista3 = new ArrayList<Piloto>();
        lista3.add(p4);
        lista3.add(p3);
        lista3.add(p2);
        lista3.add(p1);
        campeonato1.registrarCorrida(lista3);
        
        List<Piloto> classificacao = new ArrayList<Piloto>();
        classificacao = campeonato1.getClassificacao();


        for(int i = 0; i < 4; i++){
            System.out.println((i+1) + ". "+classificacao.get(i));
        }
    }
}
