package application;

import model.entities.Excursao;

public class Teste1 {
	public static void main(String[] args) {
		try {
			// Instanciando uma excursão
			Excursao excursao = new Excursao(1234, 100.0, 20);
			System.out.println("excursao: " + excursao);

			// Criando reservas na excursão acima
			excursao.criarReserva("111", "joao");
			excursao.criarReserva("222", "maria");
			excursao.criarReserva("333", "jose");
			excursao.criarReserva("333", "paulo");
			excursao.criarReserva("333", "ana");
			excursao.criarReserva("555", "antonio");
			excursao.criarReserva("555", "joana");

			// Listando todas as reservas
			System.out.println("\nlistar todas as reservas");
			System.out.println(excursao.listarReservasPorCpf(""));

			// Listando as reservas cujo cpf é 3
			System.out.println("\nlistar as reservas por cpf");
			System.out.println(excursao.listarReservasPorCpf("3"));

			// Listando as reservas cujo nome começa com "jo"
			System.out.println("\nlistar as reservas por nome");
			System.out.println(excursao.listarReservasPorNome("jo"));

			// Cancelando uma reserva a partir do cpf e do nome
			excursao.cancelarReserva("555", "antonio");

			// Cancelando uma reserva a partir apenas do cpf
			excursao.cancelarReserva("333");

			// Listando todas as reservas após as exclusões
			System.out.println("\nlistar todas as reservas");
			System.out.println(excursao.listarReservasPorCpf(""));

			// Listando dados da excursão (código, preço, quantidade máxima de reservas e as
			// reservas propriamente ditas)
			System.out.println("\nexcursao: " + excursao);

			// Exibindo o valor total da excursão
			System.out.println("\ntotal=" + excursao.calcularValorTotal());
		}

		catch (Exception erro) {
			System.out.println("-->" + erro.getMessage()); // Retornando a exceção desejada
		}
	}
}