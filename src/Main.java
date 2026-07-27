import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner leitor = new Scanner(System.in);


        String nome;

        boolean sistemaAtivo = true;
        System.out.println("BEM VINDO AO RPG! \nDIGITE SEU NOME");
        nome = leitor.nextLine();
        Jogador jogador = new Jogador(nome);
        System.out.println("Sua aventura começa agora," + nome);

        while (sistemaAtivo){

           System.out.println("1- Novo jogo");
           System.out.println("2- Sair");

           int opcao = leitor.nextInt();

           switch (opcao){
               case 1:
                   boolean jogoAtivo = true;

                   while (jogoAtivo){

                       System.out.println("1- Ver Status");
                       System.out.println("2- Procurar batalha");
                       System.out.println("3- Loja");
                       System.out.println("4- Sair");

                       int escolha = leitor.nextInt();

                       switch (escolha){
                           case 1:
                               System.out.println("Nome: " + jogador.getNome());
                               System.out.println("Vida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
                               System.out.println("Ataque: " + jogador.getAtaque());
                               System.out.println("Defesa: " + jogador.getDefesa());
                               System.out.println("Nivel " + jogador.getNivel());
                               System.out.println("Xp: " + jogador.getExperiencia());
                               System.out.println("Moedas: " + jogador.getMoedas());
                               System.out.println("Poções: " + jogador.getQuantidadePocoes());
                               break;

                           case 2:
                               int sorteInimigo = random.nextInt(4);
                               Inimigo inimigo;
                               if (sorteInimigo == 0){
                                   inimigo = new Inimigo("Goblin");
                               } else if (sorteInimigo == 1) {
                                   inimigo = new Inimigo("Esqueleto");
                               } else if (sorteInimigo == 2) {
                                   inimigo = new Inimigo("Bandido");
                               }else {
                                   inimigo = new Inimigo("Lobo");
                               }

                               boolean batalha = true;
                               System.out.println("\nUm " + inimigo.getNome() +  " apareceu!");
                               while (batalha){

                                   int sorteBatalha = random.nextInt(100);
                                               if (sorteBatalha < 60){


                                                   System.out.println("Vida: " + inimigo.getVida());
                                                   System.out.println("===========================");
                                                   System.out.println("Vida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
                                                   System.out.println("\n");
                                                   System.out.println("=============");
                                                   System.out.println("1- Atacar");
                                                   System.out.println("2- Usar pocão");
                                                   System.out.println("3- Fugir");
                                                   System.out.println("=============");

                                                   int escolhaBatalha = leitor.nextInt();
                                                   switch (escolhaBatalha){
                                                       case 1:
                                                           System.out.println("Você atacou! Dano causado: " + jogador.getAtaque());
                                                           int novaVidaInimigo = inimigo.getVida() - jogador.getAtaque();
                                                           inimigo.setVida(novaVidaInimigo);
                                                           System.out.println(inimigo.getNome() + "/" + inimigo.getVida());
                                                           System.out.println("====================");
                                                           if (novaVidaInimigo <= 0) {
                                                               System.out.println("Você derrotou o " + inimigo.getNome());
                                                               int novaExperiencia = jogador.getExperiencia() + inimigo.getRecompensaXP();
                                                               int moedas = jogador.getMoedas() + inimigo.getRecompensaMoedas();
                                                               jogador.setExperiencia(novaExperiencia);
                                                               jogador.setMoedas(moedas);
                                                               System.out.println("Você ganhou " + inimigo.getRecompensaXP() + " de XP");
                                                               if (novaExperiencia >= 100) {
                                                                   System.out.println("Você subiu de nivel!");
                                                                   int novoNivel = jogador.getNivel() + 1;
                                                                   jogador.setNivel(novoNivel);
                                                                   System.out.println("Seu novo nivel é: " + jogador.getNivel());
                                                                   int novoDano = jogador.getAtaque() + 5;
                                                                   int novaVidaMaxima = jogador.getVidaMaxima() + 10;
                                                                   jogador.setAtaque(novoDano);
                                                                   jogador.setVidaMaxima(novaVidaMaxima);
                                                                   jogador.setVida(jogador.getVidaMaxima());
                                                                   jogador.setExperiencia(0);
                                                               }

                                                               System.out.println("Xp atual: " + jogador.getExperiencia());
                                                               System.out.println("Você ganhou " + inimigo.getRecompensaMoedas() + " de moedas");
                                                               System.out.println("total de moedas: " + jogador.getMoedas());
                                                               System.out.println("\n");
                                                               batalha = false;


                                                           }else {
                                                               System.out.println(inimigo.getNome() + " Atacou! Dano causado: " + inimigo.getAtaque());
                                                               int novaVidaJogador = jogador.getVida() - inimigo.getAtaque();
                                                               jogador.setVida(novaVidaJogador);
                                                               System.out.println("\nVida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
                                                               System.out.println("====================");
                                                               if (novaVidaJogador <= 0){
                                                                   System.out.println("Você morreu! tente novamente");
                                                                   jogoAtivo = false;
                                                                   batalha = false;
                                                               }
                                                           }break;
                                                       case 2:
                                                           if (jogador.getQuantidadePocoes() == 0){
                                                               System.out.println("você não possui poções");
                                                           }else {
                                                               if (jogador.getVida() == jogador.getVidaMaxima()){
                                                                   System.out.println("Vida cheia!");
                                                               }else {
                                                                   Pocao pocao = new Pocao("Pocão de cura");
                                                                   int novaVida = jogador.getVida() + pocao.getCura();
                                                                   if (novaVida > jogador.getVidaMaxima()){
                                                                       jogador.setVida(jogador.getVidaMaxima());
                                                                   }else {
                                                                       jogador.setVida(novaVida);
                                                                       System.out.println("Você usou uma poção!");
                                                                       System.out.println("Vida atual: " + jogador.getVida());
                                                                       int novaQuantidadepocoes = jogador.getQuantidadePocoes() - 1;
                                                                       jogador.setQuantidadePocoes(novaQuantidadepocoes);
                                                                       System.out.println("Poções restantes: " + jogador.getQuantidadePocoes());
                                                                   }

                                                               }

                                                           }break;
                                                       case 3:
                                                           System.out.println("Você fugiu!");
                                                           batalha = false;
                                       }

                                   }
                               }break;
                           case 3:
                               boolean compras = true;
                               Pocao pocao = new Pocao("Poção de cura");
                               while (compras){

                                   System.out.println("====LOJA====");
                                   System.out.println("Moedas: " + jogador.getMoedas());
                                   System.out.println("1- " + pocao.getNome() + " Valor: " + pocao.getPreco());
                                   System.out.println("2- Sair da loja");
                                   int escolhaPocao = leitor.nextInt();
                                   switch (escolhaPocao){
                                       case 1:
                                           if (jogador.getMoedas() < pocao.getPreco()){
                                               System.out.println("Moedas insuficientes!");
                                           }else{
                                               int novamoedas = jogador.getMoedas() - pocao.getPreco();
                                               jogador.setMoedas(novamoedas);
                                               int novaQuantidadePocoes = jogador.getQuantidadePocoes() + 1;
                                               jogador.setQuantidadePocoes(novaQuantidadePocoes);
                                               System.out.println("Pocões: " + jogador.getQuantidadePocoes());
                                               System.out.println("Moedas restantes: " + jogador.getMoedas());
                                               System.out.println("Poção adcionada ao inventario!");

                                           }break;

                                       case 2:
                                           compras = false;
                               }


                               }break;

                           case 4:
                               jogoAtivo = false;

                       }

                   }

           }
                
                
        }
    }
}