public class Inimigo {


    private String nome;
    private int vida;
    private int ataque;
    private int recompensaXP;
    private int recompensaMoedas;

    public Inimigo(String nome){
        this.nome = nome;
        this.vida = 100;
        this.ataque = 10;
        this.recompensaXP = 20;
        this.recompensaMoedas = 10;
    }

    public String getNome(){
        return nome;
    }
    public int getVida(){
        return vida;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getRecompensaXP(){
        return recompensaXP;
    }
    public int getRecompensaMoedas(){
        return recompensaMoedas;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
}
