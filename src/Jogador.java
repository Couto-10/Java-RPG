public class Jogador {

    private String nome;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int defesa;
    private int nivel;
    private int experiencia;
    private int moedas;
    private int quantidadePocoes;

    public Jogador(String nome){
        this.nome = nome;
        this.vida = 100;
        this.vidaMaxima = 100;
        this.ataque = 15;
        this.defesa = 5;
        this.nivel = 1;
        this.experiencia = 0;
        this.moedas = 20;
        this.quantidadePocoes = 0;
    }

    public String getNome(){
        return nome;
    }
    public int getVida(){
        return vida;
    }
    public int getVidaMaxima(){
        return vidaMaxima;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getDefesa(){
        return defesa;
    }
    public int getNivel(){
        return nivel;
    }
    public int getExperiencia(){
        return experiencia;
    }
    public int getMoedas(){
        return moedas;
    }

    public int getQuantidadePocoes() {
        return quantidadePocoes;
    }

    public void setVida(int vida){
        this.vida = vida;
    }
    public void setExperiencia(int experiencia){
        this.experiencia = experiencia;
    }
    public void setMoedas(int moedas){
        this.moedas = moedas;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setQuantidadePocoes(int quantidadePocoes) {
        this.quantidadePocoes = quantidadePocoes;
    }
}
