package br.com.fatec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
public class Campeonato {
    private final static int PONTOS[] = {10, 6, 3, 1};
    private List<Piloto> pilotos = new ArrayList<Piloto>();

    public void inscrever(Piloto piloto){
        if(pilotos.size() < PONTOS.length){
            if(!pilotos.contains(piloto)){
                pilotos.add(piloto);
            }
            else{
                System.out.println("Piloto repetido");
            }
        }
        else{
            System.out.println("Grid cheio.");
        }
    }
    public void registrarCorrida(List<Piloto> chegada){
        if(chegada.size() > 0){
            for(int i = 0; i < chegada.size(); i++){
                chegada.get(i).somarPontos(PONTOS[i]);
            }
            chegada.get(0).registrarVitoria();
        }
    }
    public List<Piloto> disputarCorrida(Random gerador, Piloto jogador, boolean nitro){
        for(Piloto p : pilotos){
            p.correr(gerador,(p.equals(jogador) ? nitro : false));
        }
        pilotos.sort(Comparator.comparingInt(Piloto :: getTempo));
        registrarCorrida(pilotos);
        return pilotos;
    }

    public List<Piloto> getClassificacao(){
        List<Piloto> listaClassificacao = new ArrayList<Piloto>();
        for (int i = 0; i < pilotos.size(); i++) {
            listaClassificacao.add(pilotos.get(i));
        }
        listaClassificacao.sort(
            Comparator
            .comparingInt(Piloto :: getPontos).reversed()
            .thenComparing(Comparator.comparingInt(Piloto :: getVitorias).reversed())
            .thenComparing(Piloto :: getNome)
        );
        return listaClassificacao;
    }
}
