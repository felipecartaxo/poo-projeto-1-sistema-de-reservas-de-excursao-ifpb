public class Teste3 {

	public static void main(String[] args) throws Exception {
		Excursao excursao1 = new Excursao(1234);
		excursao1.carregar();
		System.out.println("Testando o método 'salvar'");
		System.out.println(excursao1.listarReservasPorCpf(""));
	}

}
