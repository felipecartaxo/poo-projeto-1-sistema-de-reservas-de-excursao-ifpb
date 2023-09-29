/**
 * TSI - POO - Prof. Fausto projeto1
 */

public class Teste1 {
	public static void main(String[] args) {
		try {
			Excursao excursao = new Excursao(1234, 100.0, 20);
			System.out.println("excursao:" + excursao);

			excursao.criarReserva("111", "joao");
			excursao.criarReserva("222", "maria");
			excursao.criarReserva("333", "jose");
			excursao.criarReserva("333", "paulo");
			excursao.criarReserva("333", "ana");
			excursao.criarReserva("555", "antonio");
			excursao.criarReserva("555", "joana");
			excursao.criarReserva("666", "joao");
			
			excursao.salvar();
			System.out.println(excursao.listarGeral());
			
			Excursao excursao2 = new Excursao(999, 888, 5);
			System.out.println("excursao:" + excursao2);
			
			excursao2.criarReserva("912", "joao");
			excursao2.criarReserva("913", "maria");
			excursao2.criarReserva("914", "felipe");
//			excursao2.cancelarReserva("914");
			
			excursao2.salvar();
			System.out.println(excursao2);
			

			System.out.println("\nlistar todas as reservas");
			System.out.println(excursao.listarReservasPorCpf(""));
			System.out.println("\nlistar as reservas por cpf");
			System.out.println(excursao.listarReservasPorCpf("3"));
			System.out.println("\nlistar as reservas por nome");
//			System.out.println(excursao.listarReservasPorNome("joao"));
//
//			excursao.cancelarReserva("555", "claudia");
//			excursao.cancelarReserva("111");
			excursao.cancelarReserva("555", "joana");
//			
			System.out.println(excursao.listarGeral());
//			System.out.println(excursao);
//
//
			System.out.println("\nlistar todas as reservas");
			System.out.println(excursao.listarReservasPorCpf("222"));
			System.out.println("Listando todas as reservas novamente:");
			System.out.println(excursao.listarGeral());
			System.out.println("-----------------------------");
			System.out.println(excursao.listarReservasPorNome("antonio"));
			System.out.println(excursao.listarGeral());
			System.out.println("\nexcursao:" + excursao);
			System.out.println("\ntotal=" + excursao.calcularValorTotal());
		}
		catch (Exception erro) {
			System.out.println("-->" + erro.getMessage());
		}
	}
}