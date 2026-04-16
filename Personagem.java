import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personagem {

    String nome;
    private int energia;
    private int fome;
    private int sono;
    private List<String> Mochila = new ArrayList<>();
    private List<Musica> repertorio = new ArrayList<>();
    public boolean vivo = true;

    public Personagem(String nome) {
        System.out.println("Construindo novo personagem");
        energia = 10;
        fome = 0;
        sono = 0;
        this.nome = nome;
        Mochila = new ArrayList<>();
        repertorio = new ArrayList<>();
    }

    public Personagem(String nome,int energia, int fome, int sono){
         System.out.println("Construindo novo personagem");
        this.nome = nome;
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        Mochila = new ArrayList<>();
        repertorio = new ArrayList<>();
    }

    public Personagem(int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        Mochila = new ArrayList<>();
        repertorio = new ArrayList<>();
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

    public void duelo(Personagem adversario){
        if (repertorio.size() == 0){
            System.out.println(nome +" nao tem musicas, impossivel duelar");
            System.out.println("**********************");
            return;
        }
        System.out.println(nome +" iniciou um duelo");

        var gerador = new Random();
        var sorteio = gerador.nextInt(repertorio.size());
        Musica mDuelo = repertorio.get(sorteio);
        if(adversario.getRepertorio().contains(mDuelo)){
            energia--;
            adversario.energia--;
            System.out.println("Ambos conheciam a musica");
            System.out.println("**********************");
        }
        else{
            adversario.energia--;
            adversario.getRepertorio().add(mDuelo);
            System.out.println(nome +" Venceu o duelo");
            System.out.println(adversario.nome +" Aprendeu a musica");
            System.out.println("**********************");
        }

    }

    public void estaVivo(){
        if(energia == 0){
            vivo = false;
        }
    }
    @Override
    public String toString() {
        return String.format(
            "%s: e:%d, f:%d, s:%d",
            nome, energia, fome, sono
        );
    }
    public void aprenderMusica(ArrayList<Musica> disponiveis) {
        Random gerador = new Random();
        int numeroMusica = gerador.nextInt(0,10);
        Musica sorteada = disponiveis.get(numeroMusica);
        
        if (!repertorio.contains(sorteada)) {
            repertorio.add(sorteada);
            System.out.println(nome + " aprendeu a música: " + sorteada.getTitulo());
        } else {
            System.out.println(nome + " já conhece a música: " + sorteada.getTitulo());
        }
    }
    public List<String> getMochila() {
        return Mochila;
    }
    
    public List<Musica> getRepertorio() {
        return repertorio;
    }
}