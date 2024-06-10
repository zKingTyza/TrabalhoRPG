public abstract class Item implements Usavel {
    private String nome;


    public Item(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }


}
