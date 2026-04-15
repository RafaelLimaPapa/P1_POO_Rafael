public class Musica {
    private String titulo;

    public Musica(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public String toString(){
        return String.format(
            "%s ",
            titulo
        );
    }
}
