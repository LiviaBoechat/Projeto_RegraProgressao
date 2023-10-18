package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {
  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar: ");
    // armazeno a qt. de ativ. escritas no input pelo usuário
    int quantidadeAtividades = scanner.nextInt();

    // crio arrays p/ armaz. ativ. e seus pesos, os quais são fornecidos no input pelo usuário
    String[] nomesAtividades = new String[quantidadeAtividades];
    int[] pesosAtividades = new int[quantidadeAtividades];
    // crio array p/ armaz. notas de cada ativ.
    int[] notasAtividades = new int[quantidadeAtividades];

    // p/ cada ativ., pergunto o nome e o peso, armazenando nos índices dos arrays criados acima
    for (int i = 0; i < quantidadeAtividades; i++) {
      System.out.println("Digite o nome da atividade " + (i + 1) + ": ");
      scanner.nextLine();
      nomesAtividades[i] = scanner.nextLine();
      System.out.println("Digite o peso da atividade " + (i + 1) + ": ");
      pesosAtividades[i] = scanner.nextInt();
      System.out.println("Digite a nota obtida para " + nomesAtividades[i] + ": ");
      notasAtividades[i] = scanner.nextInt();
    }

    // calculo a soma dos pesos das ativ. e verifico se somam 100
    int somaPesos = 0;
    for (int peso : pesosAtividades) {
      somaPesos += peso;
    }

    if (somaPesos != 100) {
      System.out.println("A soma dos pesos das atividades não é igual a 100.");
      return;
    }


    // mostro a nota final chamando o método responsável pelo cálculo
    double notaFinal = calcularNotaFinal(nomesAtividades, pesosAtividades, notasAtividades);
    if (notaFinal >= 85) {
      System.out.println("Parabéns! Você alcançou " + notaFinal + "%! "
          + "E temos o prazer de informar que você obteve aprovação!");
    } else {
      System.out.println("Lamentamos informar que, com base na "
          + "sua pontuação alcançada neste período, "
          + notaFinal + "%, " + "você não atingiu a pontuação "
          + "mínima necessária para sua aprovação.");
    }

    scanner.close();
  }

  /**
   * Método p/ cal a nota final com base nas atividades, pesos e notas fornecidos.
   */
  public static double calcularNotaFinal(String[] nomesAtividades,
      int[] pesosAtividades, int[] notasAtividades) {
    double soma = 0;
    int somaPesos = 0;

    for (int i = 0; i < nomesAtividades.length; i++) {
      soma += (pesosAtividades[i] * notasAtividades[i]);
      somaPesos += pesosAtividades[i];
    }
    return (soma / somaPesos);
  }
}
