import java.util.Random;
import java.util.ArrayList;
import java.util.List;
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

        while (p1.vivo == true) {

            var oQueFazer = gerador.nextInt(1, 4);
            var escolherItem = gerador.nextInt(1, 6);

            switch (oQueFazer) {

                case 1:
                    p1.cacar(escolherItem);
                    break;

                case 2:
                    p1.comer();
                    break;

                case 3:
                    p1.dormir();
                    break;

            }
            p1.aprenderMusica((ArrayList<Musica>) repertorio);
            System.out.println(p1);
            System.out.println(p1.getMochila());
            System.out.println("**********************");
            Thread.sleep(150);
            p1.estaVivo();
        }
        System.out.println("\n======FIM DE JOGO======");
        System.out.println("====RELATORIO FINAL====");
        System.out.println("\nMochila de Itens:");
        System.out.println(p1.getMochila());
        System.out.println("\nMusicas no Repertorio:");
        System.out.println(p1.getRepertorio());
    }
}