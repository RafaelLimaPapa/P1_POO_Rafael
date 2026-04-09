import java.util.ArrayList;
import java.util.List;

public class Personagem {

    String nome;
    private int energia;
    private int fome;
    private int sono;

    public List<String> Mochila = new ArrayList<>();

    public Personagem(String nome) {
        System.out.println("Construindo novo personagem");
        energia = 10;
        fome = 0;
        sono = 0;
        this.nome = nome;
    }

    public Personagem(int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    }

    void cacar(int item) {

        if (energia >= 2) {
            System.out.printf("%s caçando\n", nome);
            energia -= 2;

            switch (item) {
                case 1: {
                    Mochila.add("Garra");
                    break;
                }
                case 2: {
                    Mochila.add("Pena");
                    break;
                }
                case 3: {
                    Mochila.add("Couro");
                    break;
                }
                case 4: {
                    Mochila.add("Osso");
                    break;
                }
                case 5: {
                    Mochila.add("Presa");
                    break;
                }
            }

        } else {
            System.out.printf("%s sem energia para caçar\n", nome);
        }

        if (fome < 10) {
            fome = fome + 1;
        }

        sono = sono == 10 ? sono : sono + 1;
    }

    void comer() {

        if (fome >= 1) {
            System.out.println(nome + " comendo");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            System.out.println(nome + " sem fome");
        }
    }

    void dormir() {

        if (sono >= 1) {
            System.out.print(nome + " dormindo\n");
            energia = energia == 10 ? energia : energia + 1;
            sono -= 1;
        } else {
            System.out.println(nome + " sem sono");
        }
    }

    @Override
    public String toString() {
        return String.format(
            "%s: e:%d, f:%d, s:%d",
            nome, energia, fome, sono
        );
    }
}