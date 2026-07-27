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
                       System.out.println("3- Sair");

                       int escolha = leitor.nextInt();

                       switch (escolha){
                           case 1:
                               System.out.println("Nome: " + jogador.getNome());
                               System.out.println("Vida: " + jogador.getVida());
                               System.out.println("Ataque: " + jogador.getAtaque());
                               System.out.println("Defesa: " + jogador.getDefesa());
                               System.out.println("Nivel " + jogador.getNivel());
                               System.out.println("Xp: " + jogador.getExperiencia());
                               System.out.println("Moedas: " + jogador.getMoedas());
                               break;

                           case 2:
                               Inimigo inimigo = new Inimigo("Goblin");
                               boolean batalha = true;
                               while (batalha){

                                   int sorteBatalha = random.nextInt(100);
                                   if (sorteBatalha < 60){

                                       System.out.println("\nUm Goblin apareceu!");
                                       System.out.println("Vida Goblin: " + inimigo.getVida());
                                       System.out.println("Sua vida: " + jogador.getVida());
                                       System.out.println("\n");
                                       System.out.println("1- Atacar");
                                       System.out.println("2- Fugir");

                                       int escolhaBatalha = leitor.nextInt();
                                       if (escolhaBatalha == 1){
                                           System.out.println("Você atacou! Dano causado: " + jogador.getAtaque());
                                           int novaVidaInimigo = inimigo.getVida() - jogador.getAtaque();
                                           inimigo.setVida(novaVidaInimigo);
                                           if (novaVidaInimigo <= 0){
                                               System.out.println("Você derrotou o inimigo!");
                                               int novaExperiencia = jogador.getExperiencia() + 20;
                                               int moedas = jogador.getMoedas() + 10;
                                               jogador.setExperiencia(novaExperiencia);
                                               jogador.setMoedas(moedas);
                                               System.out.println("Você ganhou 20 de XP");
                                               if (novaExperiencia >= 100){
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
                                               System.out.println("Você ganhou 10 moedas");
                                               System.out.println("total de moedas: " + jogador.getMoedas());
                                               System.out.println("\n");
                                               batalha = false;
                                           }else {
                                               System.out.println("Inimigo Atacou! Dano causado: " + inimigo.getAtaque());
                                               int novaVidaJogador = jogador.getVida() - inimigo.getAtaque();
                                               jogador.setVida(novaVidaJogador);
                                               if (novaVidaJogador <= 0){
                                                   System.out.println("Você morreu! tente novamente");
                                                   jogoAtivo = false;
                                                   batalha = false;
                                               }
                                           }
                                       }else {
                                           System.out.println("Você fugiu!");
                                           batalha = false;
                                       }
                                   }
                               }break;
                           case 3:
                               jogoAtivo = false;

                       }

                   }

           }
                
                
        }
    }
}