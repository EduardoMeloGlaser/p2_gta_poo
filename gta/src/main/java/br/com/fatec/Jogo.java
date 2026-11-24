package br.com.fatec;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Jogo {
    private final static int CORRIDAS = 3;
    private final static int NITROS = 2;
    private final static int TAMANHO_RANKING = 5;

    public static StringBuilder gerarTabela(List<Piloto> classificacao, int corrida) {
        var tabela = new StringBuilder();
        tabela.append("Corrida " + corrida + "/" + CORRIDAS + "\n");
        for(int j = 0; j < classificacao.size(); j++) {
            tabela.append((j + 1) + ". " + classificacao.get(j) + "\n");
        }
        return tabela;
    }

    public static void ranking(){
        var ranking = PartidaDAO.listar();
        ranking.sort(Comparator.comparingInt(Partida::getPontuacao).reversed());
        var listaRanking = new StringBuilder();
        listaRanking.append("RANKING\n");
        int tamanhoRanking = Math.min(ranking.size(), TAMANHO_RANKING); 
        for(int i = 0; i < tamanhoRanking; i++) {
            Partida p = ranking.get(i);
            listaRanking.append(
                (i + 1) + ". " + p.getJogador() + " - " + p.getPontuacao() + " pontos\n"
            );
        }
        JOptionPane.showMessageDialog(null, listaRanking);
    }

    public static void campeonato() {
        String jogadorNome = JOptionPane.showInputDialog("nome jogador?");
        String nome = "";
        int opcao;
        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1-Jason ou 2-Lucia"));
            switch (opcao) {
                case 1:
                    nome = "Jason";
                    break;
                case 2:
                    nome = "Lucia";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
                    break;
            }
        }while (opcao != 1 && opcao != 2);

        int qtdNitro = NITROS;
        var concessionaria = new Concessionaria();
        var campeonato = new Campeonato();
        var p1 = new Piloto(nome, concessionaria.sortear());
        var bot1 = new Piloto("Raul", concessionaria.sortear());
        var bot2 = new Piloto("Boobie", concessionaria.sortear());
        var bot3 = new Piloto("Cal", concessionaria.sortear());
        campeonato.inscrever(p1);
        campeonato.inscrever(bot1);
        campeonato.inscrever(bot2);
        campeonato.inscrever(bot3);

        JOptionPane.showMessageDialog(null, "Seu carro: " + p1.getCarro());

        for(int i = 0; i < CORRIDAS; i++) {
            var classificacao = campeonato.getClassificacao();
            var tabela = gerarTabela(classificacao, i + 1);

            int opcaoNitro;
            do {
                opcaoNitro = Integer.parseInt(JOptionPane.showInputDialog(
                    null,
                    tabela + "\nUsar nitro? 1-Sim 2-Nao (restam " + qtdNitro + ")"
                ));
            }while (opcaoNitro != 1 && opcaoNitro != 2);

            var gerador = new Random();
            boolean usaNitro = false;
            if(opcaoNitro == 1) {
                if(qtdNitro > 0) {
                    qtdNitro--;
                    usaNitro = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Sem nitro restante");
                }
            }
            var chegada = campeonato.disputarCorrida(gerador, p1, usaNitro);

            var listaChegada = new StringBuilder();
            listaChegada.append("Chegada\n");
            for(int j = 0; j < chegada.size(); j++) {
                var p = chegada.get(j);
                listaChegada.append((j + 1) + ". " + p.getNome() + " - " + p.getTempo() + "s\n");
            }
            JOptionPane.showMessageDialog(null, listaChegada);
        }

        var classificacaoFinal = campeonato.getClassificacao();
        var listaFinal = gerarTabela(classificacaoFinal, CORRIDAS);

        int posicaoFinal = classificacaoFinal.indexOf(p1) + 1;
        if(posicaoFinal == 1) {
            listaFinal.append("\nCampeao de Vice City!");
        }else {
            listaFinal.append("\nPosicao final: " + posicaoFinal);
        }
        JOptionPane.showMessageDialog(null, listaFinal);

        var partida = Partida.builder()
            .jogador(jogadorNome)
            .pontuacao(p1.getPontos())
            .build();

        if(PartidaDAO.cadastrar(partida)) {
            JOptionPane.showMessageDialog(null, "Partida salva");
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar a partida");
        }
    }

    public static void main(String[] args) {
        String menu = "1-Jogar\n2-Ranking\n0-Sair";

        int opcao;
        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcao) {
                case 1:
                    campeonato();
                    break;
                case 2:
                    ranking();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Ate a proxima!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
                    break;
            }
        }while (opcao != 0);
    }
}

