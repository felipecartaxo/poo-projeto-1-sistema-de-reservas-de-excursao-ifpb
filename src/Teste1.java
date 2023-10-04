/**
 * TSI - POO - Prof. Fausto projeto1
 */

public class Teste1 {
	public static void main(String[] args) {
		try {
			Excursao excursao = new Excursao(1234, 100.0, 20);
			System.out.println("Excursao: " + excursao);
			excursao.gravar();

			excursao.criarReserva("111", "joao");
			excursao.criarReserva("222", "maria");
			excursao.criarReserva("333", "jose");
			excursao.criarReserva("333", "paulo");
			excursao.criarReserva("333", "ana");
			excursao.criarReserva("555", "antonio");
			excursao.criarReserva("555", "joana");
			System.out.println(excursao.listarReservasPorCpf(""));
			System.out.println(excursao.listarReservasPorCpf("333"));
//						
//			System.out.println("Gravar dados no arquivo");
//			excursao.gravar();
//			
//			System.out.println("Inserir reservas após a criação do arquivo");
//			excursao.criarReserva("444", "felipe");
//			excursao.gravar();
//			System.out.println("------------------------------------------");
//			
//			Excursao excursao2 = new Excursao(5678, 350, 8);
//			System.out.println("Excursão 2: " + excursao2);
//			
//			excursao2.criarReserva("1", "fulano");
//			excursao2.criarReserva("2", "cicrano");
//			excursao2.criarReserva("3", "beltrano");
//			excursao2.gravar();
//			System.out.println("Gravando reservas");
//			System.out.println("Imprimindo Excursao2: ");
//			excursao.listarReservasPorCpf("");
//			
//			excursao2.cancelarReserva("2");
//			excursao2.gravar();
//			System.out.println("Excursao 2: " + excursao2);
//			
//			Excursao excursao3 = new Excursao(999);
//			System.out.println(excursao3);
//			excursao3.gravar();
//			
//			System.out.println("test");
//			System.out.println(excursao.listarReservasPorNome("paulo"));
//
//			System.out.println("\nlistar todas as reservas");
//			System.out.println(excursao.listarReservasPorCpf(""));
//			System.out.println("\nlistar as reservas por cpf");
//			System.out.println(excursao.listarReservasPorCpf("333"));
//			System.out.println("\nlistar as reservas por nome");
//			System.out.println(excursao.listarReservasPorNome("jo"));
//
//			excursao.cancelarReserva("555", "antonio");
//			System.out.println(excursao.listarReservasPorCpf(""));
//			excursao.cancelarReserva("333");
//
//			System.out.println("\nlistar todas as reservas");
//			System.out.println(excursao.listarReservasPorCpf(""));
//			System.out.println("\nexcursao:" + excursao);
//			System.out.println("\ntotal=" + excursao.calcularValorTotal());
		} catch (Exception erro) {
			System.out.println("-->" + erro.getMessage());
		}

	}
}
