public class Inimigo {


    private String nome;
    private int vida;
    private int ataque;
    private int recompensaXP;
    private int recompensaMoedas;

    public Inimigo(String nome){

        this.nome = nome;
        
        if (nome.equals("Goblin")){

            this.vida = 100;
            this.ataque = 10;
            this.recompensaXP = 20;
            this.recompensaMoedas = 10;

        } else if (nome.equals("Esqueleto")) {

            this.vida = 90;
            this.ataque = 12;
            this.recompensaXP = 15;
            this.recompensaMoedas = 5;

        } else if (nome.equals("Bandido")) {

            this.vida = 100;
            this.ataque = 14;
            this.recompensaXP = 25;
            this.recompensaMoedas = 20;

        } else if (nome.equals("Lobo")) {

                this.vida = 110;
                this.ataque = 15;
                this.recompensaXP = 30;
                this.recompensaMoedas = 25;
        }


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
