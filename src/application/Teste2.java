package application;

import model.entities.Excursao;

/**
 * TSI - POO - Prof. Fausto projeto1
 */

public class Teste2 {
	public static void main(String[] args) {

		// ------------Teste das exce��es --------------------
		try {
			Excursao excursao = new Excursao(0, 0, 0);
			System.out.println("1--->n�o ok: construtor");
		} catch (Exception erro) {
			System.out.println("1---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 1);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "bbb");
			System.out.println("2--->n�o ok: limite excedido");
		} catch (Exception erro) {
			System.out.println("2---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 2);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "aaa");
			System.out.println("3--->n�o ok: nome duplicado");
		} catch (Exception erro) {
			System.out.println("3---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 2);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "bbb");
			excursao.cancelarReserva("3");
			System.out.println("4--->n�o ok: cpf inexistente");
		} catch (Exception erro) {
			System.out.println("4---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 2);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "bbb");
			excursao.cancelarReserva("111", "xxx");
			System.out.println("5--->n�o ok: nome inexistente");
		} catch (Exception erro) {
			System.out.println("5---->ok" + erro.getMessage());
		}
	}
}