import java.util.Random;

public class Jogo {

    public static void main(String[] args) throws Exception {

        var gerador = new Random();
        var p1 = new Personagem("Jeferson");

        while (true) {

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

            System.out.println(p1);
            System.out.println(p1.Mochila);
            System.out.println("**********************");

            Thread.sleep(1000);
        }
    }
}