package application;

import model.entities.Excursao;

public class Teste2 {
	public static void main(String[] args) {

		// ------------ Teste das exceções -------------------
		try {
			@SuppressWarnings("unused") // Apenas para parar de exibir que a excursão instanciada abaixo não está sendo
										// utilizada

			Excursao excursao = new Excursao(0, 0, 0);
			System.out.println("1--->não ok: construtor");
		} catch (Exception erro) {
			System.out.println("1---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 1);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "bbb");
			System.out.println("2--->não ok: limite excedido");
		} catch (Exception erro) {
			System.out.println("2---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 2);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "aaa");
			System.out.println("3--->não ok: nome duplicado");
		} catch (Exception erro) {
			System.out.println("3---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 2);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "bbb");
			excursao.cancelarReserva("3");
			System.out.println("4--->não ok: cpf inexistente");
		} catch (Exception erro) {
			System.out.println("4---->ok" + erro.getMessage());
		}

		try {
			Excursao excursao = new Excursao(1, 1, 2);
			excursao.criarReserva("111", "aaa");
			excursao.criarReserva("222", "bbb");
			excursao.cancelarReserva("111", "xxx");
			System.out.println("5--->não ok: nome inexistente");
		} catch (Exception erro) {
			System.out.println("5---->ok" + erro.getMessage());
		}
	}
}