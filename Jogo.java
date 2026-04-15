import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Jogo {

    public static void main(String[] args) throws Exception {
        List<Musica> repertorio = new ArrayList<>();
        repertorio.add(new Musica("Billie Jean"));
        repertorio.add(new Musica("They Don't Care About Us"));
        repertorio.add(new Musica("Thriller"));
        repertorio.add(new Musica("Beat it"));
        repertorio.add(new Musica("Smooth Criminal"));
        repertorio.add(new Musica("We Are The World"));
        repertorio.add(new Musica("Heal The World"));
        repertorio.add(new Musica("Bad"));
        repertorio.add(new Musica("Love Never Felt So Good"));
        repertorio.add(new Musica("You Are Not Alone"));
        var gerador = new Random();

        var p1 = new Personagem("Jeferson");
        var p2 = new Personagem("Tico Trovador",3,8,8);
        p2.getRepertorio().add(new Musica("Trovejou na Roca"));
        while (p1.vivo == true || p2.vivo == true) {

            var oQueFazer = gerador.nextInt(1, 4);
            var escolherItem = gerador.nextInt(1, 6);
            var oQueFazer2 = gerador.nextInt(1, 6);
            if(p1.vivo == true){
                switch (oQueFazer) {
                    case 1:{
                        p1.cacar(escolherItem);
                        break;
                    }
                    case 2:{
                        p1.comer();
                        break;
                    }
                    case 3:{
                        p1.dormir();
                        break;                        
                    }
                }
                p1.aprenderMusica((ArrayList<Musica>) repertorio);
            }else{
                System.out.println(p1.nome +" esta morto");
            }

            System.out.println(p1);
            System.out.println(p1.getMochila());
            System.out.println(p1.getRepertorio());
            System.out.println("**********************");

            if(p2.vivo == true){
                switch (oQueFazer2) {
                    case 1:{
                        p2.cacar(escolherItem);
                        break;
                    }
                    case 2:{
                        p2.comer();
                        break;
                    }
                    case 3,4,5:{
                        p2.dormir();
                        break;
                    }
                }
                p2.aprenderMusica((ArrayList<Musica>) repertorio);
                
            }else{
                System.out.println(p2.nome +" esta morto");
            }
            System.out.println(p2);
            System.out.println(p2.getMochila());
            System.out.println(p2.getRepertorio());
            System.out.println("**********************");
            Thread.sleep(5000);
            p1.estaVivo();
            p2.estaVivo();
        }
        System.out.println("\n======FIM DE JOGO======");
        System.out.println("\n====RELATORIO FINAL====\n");
        System.out.println("Jogador " + p1.nome);
        System.out.println("\nMochila de Itens:");
        System.out.println(p1.getMochila());
        System.out.println("\nMusicas no Repertorio:");
        System.out.println(p1.getRepertorio());
        System.out.println("\nJogador " + p2.nome);
        System.out.println("\nMochila de Itens:");
        System.out.println(p2.getMochila());
        System.out.println("\nMusicas no Repertorio:");
        System.out.println(p2.getRepertorio());
    }
}