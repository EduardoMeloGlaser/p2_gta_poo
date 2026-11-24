package br.com.fatec;

public class TesteConcessionaria {
    public static void main(String[] args) {
        var con = new Concessionaria();
        System.out.println("Carros no estoque: "+ con.restantes());
        System.out.println("Sorteou: "+ con.sortear());
        System.out.println("Sorteou: "+ con.sortear());
        System.out.println("Sorteou: "+ con.sortear());
        System.out.println("Carros no estoque: "+ con.restantes());
    }
    
}
