package br.com.fatec;

public class TestePartidaDAO {
    public static void main(String[] args) {
        var pessoa1 = Partida.builder()
        .jogador("Ana")
        .pontuacao(26)
        .build();
        
        var pessoa2 = Partida.builder()
        .jogador("Bia")
        .pontuacao(13)
        .build();

        System.out.println("Cadastrou Ana? " + PartidaDAO.cadastrar(pessoa1));
        System.out.println("Cadastrou Bia? " + PartidaDAO.cadastrar(pessoa2));
        
            var partidaJogadores = PartidaDAO.listar();
            for(int i = 0; i < partidaJogadores.size(); i++){
                var p = partidaJogadores.get(i);
                System.out.println(p.getCodigo() + " - " + p.getJogador() + " - " + p.getPontuacao());
            } 
    }
}
