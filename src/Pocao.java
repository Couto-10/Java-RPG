public class Pocao {
    private String nome;
    private int preco;
    private  int cura;

    public Pocao(String nome){
        this.nome = nome;
        this.cura = 30;
        this.preco = 20;
    }
    public String getNome(){
        return nome;
    }
    public int getPreco(){
        return preco;
    }
    public int getCura(){
        return cura;
    }
    
}

