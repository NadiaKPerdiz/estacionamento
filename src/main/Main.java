package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Estacionamento;
import entities.Pessoa;
import entities.Tipo;
import entities.Veiculo;

public class Main {
	
	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("Selecione uma op��o:");
			System.out.println("1 - adicionar ve�culo");
			System.out.println("2 - sa�da de um ve�culo");
			System.out.println("3 - listagem de ve�culos estacionados");
			System.out.println("4 - sair");
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
				case 1:
					String cpf;
					String nome;
					String tel;
					String modelo;
					String placa;
					String tipo = "";
					
					System.out.println("Informe o CPF do cliente: ");
					cpf = sc.nextLine();
					System.out.println("Informe o nome do cliente: ");
					nome = sc.nextLine();
					System.out.println("Informe o telefone do cliente: ");
					tel = sc.nextLine();
					
					Pessoa p = new Pessoa(cpf, nome, tel);
					
					while(!(tipo.equals("CARRO")) && !(tipo.equals("MOTO"))) {
						System.out.println("Qual o tipo do ve�culo? Carro ou moto?");
						tipo = sc.nextLine().toUpperCase();
					}
					
					System.out.println("Qual o modelo do ve�culo?");
					modelo = sc.nextLine();
					System.out.println("Qual a placa do ve�culo?");
					placa = sc.nextLine();
					
					if(tipo == "CARRO") {
						if(estacionamento.entraVeiculo(placa, modelo, Tipo.CARRO, p)) {
							System.out.println("Inclu�do com sucesso!\n");
						}else {
							System.out.println("Erro!\n");
						}
					}else {
						if(estacionamento.entraVeiculo(placa, modelo, Tipo.MOTO, p)) {
							System.out.println("Inclu�do com sucesso!\n");
						}else {
							System.out.println("Erro!\n");
						}
					}
				break;
				case 2:
					System.out.println("Informe a placa do ve�culo a ser retirado:");
					placa = sc.nextLine();
					System.out.printf("Total a ser pago: %.2f", estacionamento.saiVeiculo(placa), "\n");
				break;
				case 3:
					ArrayList<Veiculo> lista = estacionamento.listaEstacionados();
					for (int i=0; i < lista.size(); i++) {
						
						System.out.println(lista.get(i).getPlaca());
					}
				break;
			}
		}while(opcao < 4);
		return;
	}
	
}
