package Lista1;

import java.util.*;
import java.text.*;
import java.math.*;

public class pratica_prova {

	static Scanner scan = new Scanner (System.in);
	static DecimalFormat dc = new DecimalFormat("00.00");
	
	public static void main(String[] args) {
		System.out.println("Criando um personagem de Genshin Impact\nQuantos personagens deseja criar?");
		int repeticao = scan.nextInt();
		for(int i = 1; i <= repeticao; i ++) {
			System.out.println("Criando o " + i + "° personagem.");
			cria_persona();
		}
	}
	
	public static void cria_persona() {
		System.out.println("Vamos começar com algumas informações básicas:\n");
		System.out.println("Insira o nome: ");
		String nome = scan.next();
		System.out.println("Insira a visão: ");
		String visao = scan.next();
		System.out.println("Insira a nação: ");
		String nacao = scan.next();
		System.out.println("Insira a idade: ");
		int idade = scan.nextInt();
		System.out.println("Insira a HP: ");
		int hp = scan.nextInt();
		System.out.println("Insira o ATK: ");
		int atk = scan.nextInt();
		System.out.println("Insira a DEF: ");
		int def = scan.nextInt();
		System.out.println("Insira a Recarga de Energia: ");
		int re = scan.nextInt();
		System.out.println("Insira a proficiência: ");
		int prof = scan.nextInt();
		
		double scale = multiplicadores();
		
		int atributo = 0;
		if(scale == 1) atributo = hp;
		if(scale == 2) atributo = def;
		if(scale == 3) atributo = atk;
		if(scale == 4) atributo = re;
		if(scale == 5) atributo = prof;
		if(scale == 6) atributo = 1;

		double dano = atk + calculaDano(scale, atributo);

		System.out.println("| Introduzindo: " + nome + " |\n"
				+ "\n | HP: " + hp
				+ " | ATK: " + atk
				+ " | DEF: " + def
				+ "\n ° Recarga de Energia: " + re
				+ " | Proficiência: " + prof
				+ " | Visão elemental: " + visao
				+ "\n | Nação: " + nacao
				+ " | Idade: " + idade
				+ " | Dano do personagem: " + dano
				);
	}
	
	public static double multiplicadores() {
		int option = 0;
		while(option < 1 || option > 5) {
			System.out.println("Qual atributo o personagem vai escalar?"
					+ "[1] - HP | [2] - DEF | [3] - ATK | [4] Recarga de Energia | [5] - Profiência | [6] - Sem Scale\n");
			option = scan.nextInt();
		}
		if (option == 1) return 1;
		if (option == 2) return 2;
		if (option == 3) return 3;
		if (option == 4) return 4;
		if (option == 5) return 5;
		return 6;
		
	}
	
	public static double calculaDano(double scale, int atributo) {
		if(scale == 1) return atributo * 0.20;
		if(scale == 2) return atributo * 0.32;
		if(scale == 3) return atributo * 0.16;
		if(scale == 4) return atributo * 0.32;
		if(scale == 5) return atributo * 0.20;
		if(scale == 6) return atributo * 1;
		return atributo * 1;
	}

}
