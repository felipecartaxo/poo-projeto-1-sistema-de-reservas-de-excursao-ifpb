import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excursao {

	private int codigo;
	private double preco;
	private int maxReservas;
	private ArrayList<String> reservas = new ArrayList<>();		// Array que armazenará as reservas
	
	public Excursao(int codigo) throws Exception {
		if (codigo <= 0)			// Lança uma exceção se 'codigo' <= 0
			throw new Exception("O código da excursão deve ser maior do que 0");
		this.codigo = codigo;		// Caso não seja lançada a exceção
	}
	
	public Excursao(int codigo, double preco, int maxReservas) throws Exception {
		if (codigo <= 0)			// Lança uma exceção se 'codigo' <= 0
			throw new Exception("O código da excursão deve ser maior do que 0");
		if (preco <= 0)				// Lança uma exceção se 'preco' <= 0
			throw new Exception("O preço deve ser maior do que 0");
		if (maxReservas <= 0) 		// Lança uma exceção se 'maxReservas' <= 0
			throw new Exception("O número de reservas deve ser maior do que 0");
		
		this.codigo = codigo;		// Caso não seja lançada nenhuma exceção
		this.preco = preco;
		this.maxReservas = maxReservas;

		for (int i = 0; i < maxReservas; i++) { // Criando ArrayList com espaços "disponivel" de acordo com o tamanho informado
			reservas.add("disponivel");
		}
	}

	public void criarReserva(String cpf, String nome) throws Exception {
		int vagaDisponivelEncontrada = -1;		// Variável auxiliar que será utilizada para retornar (ou não) o índice da primeira vaga disponível encontrada
		int reservaAtualIndex = 0;				// Variável que será retornará o índice do primeiro elemento "disponível encontrado
		for (String reservaAtual : reservas) {	// for-each para percorrer todos os itens de 'reservas'
			String[] partes = reservaAtual.split("/");	// Cada reserva é dividida em duas partes usando "/" como separador e armazenada no array 'partes'
			if (partes.length == 2 && partes[1].equals(nome)) {	// Está verificando se o tamanho do array 'partes' é igual a 2 (para ignorar os casos onde há "disponivel") e se o elemento na posição [1] é igual ao nome passado como parâmetro
				throw new Exception("Nome duplicado na reserva"); // Se um nome duplicado for encontrado, lançará uma exceção
			}
		}

		for (String reservaAtual : reservas) {	// Itera sobre cada reserva no ArrayList 'reservas'
			if (reservaAtual.equals("disponivel")) {	// Ao encontrar o primeiro elemento "disponível", retorna o índice do mesmo
				vagaDisponivelEncontrada = reservaAtualIndex;
				break;					// Sai do loop
			}
			reservaAtualIndex++;		// Incrementa o índice da variável auxiliar
		}
		if (vagaDisponivelEncontrada == -1) { 	// Se não foi encontrada uma vaga disponivel (ou seja, se 'vagaDisponivelEncontrada' continua sendo igual a -1) lançamos uma exceção
			throw new Exception("Todas as vagas estão ocupadas");
		}
		reservas.set(vagaDisponivelEncontrada, cpf + "/" + nome); 	// Adiciona a reserva na vaga disponivel encontrada
	}

	public void cancelarReserva(String cpf, String nome) throws Exception { // Remove uma reserva passando os campos "cpf/nome"
		boolean reservaEncontrada = false; 	// Variável de controle para verificar se a reserva foi encontrada
		for (int i = 0; i < reservas.size(); i++) {		// Varre a ArrayList 'reservas'
			String reservaAtual = reservas.get(i);		// Como o método 'split' é um método de String, iremos armazenar cada elemento de 'reservas' como String
			String[] partes = reservaAtual.split("/");	// E em seguida, no array partes, iremos quebrá-los com o método split
			if (partes.length == 2 && partes[0].equals(cpf) && partes[1].equals(nome)) { 								// Se o ArrayList 'reservas' possui o cpf (partes[0]) e o nome (partes[1]), a reserva em questão deverá ser removida
				reservas.remove(i);				// Remove a reserva caso a mesma seja encontrada
				reservaEncontrada = true;		// Altera o valor da variável de controle
				break;							// Sai do loop após a remoção
			}
		}
		if (!reservaEncontrada) {				// Caso a reserva não seja encontrada, lança uma exceção
			throw new Exception("CPF e/ou nome inexistente(s)");
		}
	}

	public void cancelarReserva(String cpf) throws Exception {
		// Variável de controle para verificar se a reserva foi encontrada
		boolean cpfEncontrado = false;
		// ArrayList auxiliar para onde as reservas NÃO RELACIONADAS com o cpf serão armazenadas
		ArrayList<String> reservasNaoRemovidas = new ArrayList<>();		// Varre a ArrayList 'reservas'
		for (String reservaAtual : reservas) {
			String[] partes = reservaAtual.split("/"); 			// Verifica se tem alguma vaga associada ao CPF
			if (partes.length == 2 && partes[0].equals(cpf)) { 	// Altera o valor da variável de controle
				cpfEncontrado = true;
			}
			else {		// Caso a reserva em questão não esteja associada ao CPF, mantém a reserva na lista de reservas não removidas
				reservasNaoRemovidas.add(reservaAtual);
			}
		}
		reservas = reservasNaoRemovidas;		// Atualiza a lista de reservas apenas com as reservas não removidas
		if (!cpfEncontrado) {					// Caso a reserva não seja encontrada, lança uma exceção
			throw new Exception("CPF inexistente");
		}
	}

	public ArrayList<String> listarReservasPorCpf(String cpf) throws Exception {
		if (cpf.equals("")) {			// Caso o cpf seja vazio, retorna todas as reservas
			return reservas;
		}
		else { 						// Caso contrário, iremos procurar se alguma reserva bate com 'cpf'
			ArrayList<String> reservasPorCpf = new ArrayList<>(); // ArrayList auxiliar para armazenar as reservas que batem com o 'cpf' passado no método
			for (String reservaAtual : reservas) {
				String[] partes = reservaAtual.split("/");
				if (partes.length == 2 && partes[0].equals(cpf)) { // Caso alguma reserva possua o 'cpf' igual, esta reserva será adicionada ao ArrayList auxiliar
					reservasPorCpf.add(reservaAtual);
				}
			}
			return reservasPorCpf;
		}
	}

	public ArrayList<String> listarReservasPorNome(String nome) {
		if (nome.equals("")) { 			// Caso 'nome' seja vazio, retorna todas as reservas
			return reservas;
		}
		else {
			ArrayList<String> reservasPorNome = new ArrayList<>();	// ArrayList auxiliar para armazenar as reservas que batem com o 'nome' passado no método
			for (String reservaAtual : reservas) {
				String[] partes = reservaAtual.split("/");
				if (partes.length == 2 && partes[1].equals(nome)) { // Caso alguma reserva possua o 'nome' igual, está reserva será adicionada ao ArrayList auxiliar
					reservasPorNome.add(reservaAtual);
				}
			}
			return reservasPorNome; 				// Retorna o array auxiliar
		}
	}

	public double calcularValorTotal() {
		return preco * (getReservas().size());		// Vai retornar o valor total contabilizando apenas as vagas efetivas (que foram de fato reservadas
	}
	
	public void gravar() throws Exception {
		try {
			File f = new File(new File(".\\" + getCodigo() + ".csv").getCanonicalPath()); // Tenta abrir o arquivo "codigo.csv", localizado na pasta do projeto
			FileWriter arquivo = new FileWriter(f, false); 	// Em seguida, utiliza um 'FileWriter' para escrever no arquivo. O parâmetro 'false' indica que o arquivo deve ser aberto para escrita, substituindo o conteúdo anterior
			arquivo.write("Preço; Max; Reserva\n"); 		// Grava a primeira linha do arquivo (linha de cabecalho contendo o Preço e o Nº máximo de reservas da excursão)
			String reservaAtual;							// Variável responsável por armazenar a reserva
			for (int i = 0; i < reservas.size(); i++) {		// Percorre o ArrayList 'reservas', verificando se uma reserva está ocupada (ou seja, se não é "disponivel")
				if (!reservas.get(i).equals("disponivel")) {
					reservaAtual = reservas.get(i); 			// Se uma reserva estiver ocupada, escreve o número da reserva e a o registro correspondente no arquivo .csv
					arquivo.write(getPreco() + "; " + getMaxReservas() + "; " + reservaAtual + "\n");										// Gravar no arquivo “codigo.txt” o preço, max e as reservas
				}
			}
			arquivo.close();
		}
		catch (IOException e) {
			throw new Exception("Problema na gravação do arquivo");
		}
	}
	
	public void carregar() throws Exception {
	    try {
	        File arquivo = new File(".\\" + getCodigo() + ".csv"); // Abre o arquivo .csv
	        Scanner scanner = new Scanner(arquivo);
	        reservas.clear();				// Limpa as reservas atuais antes de carregar os dados do arquivo
	        if (scanner.hasNextLine()) { 	// Pula a primeira linha (cabeçalho) do arquivo CSV
	            scanner.nextLine();
	        }
	        while (scanner.hasNextLine()) { // Lê as linhas restantes do arquivo e adiciona as reservas ao ArrayList
	            String linha = scanner.nextLine();
	            String[] partes = linha.split(";");
	            
	            if (partes.length >= 3) {
	                String reserva = partes[2].trim();		// A reserva está na terceira coluna
	                reservas.add(reserva);
	            }
	        }

	        scanner.close();
	    }
	    
	    catch (IOException e) {
	        throw new Exception("Problema na leitura do arquivo");
	    }
	}

	public int getCodigo() { 					// Getters e Setters
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaxReservas() {
		return maxReservas;
	}

	public void setmaxReservas(int maxReservas) {
		this.maxReservas = maxReservas;
	}

	public ArrayList<String> getReservas() {
		ArrayList<String> reservasEfetivas = new ArrayList<String>();	// Cria um ArrayList auxiliar par armazenar apenas as reservas efetivas
		for (String reservaAtual : reservas) {
			if (!reservaAtual.equals("disponivel")) {		// Se o elemento atual for uma reserva de fato, será adicionada em 'reservasEfetivas'
				reservasEfetivas.add(reservaAtual);
			}
		}
		return reservasEfetivas; 			// Retorna o ArrayList auxiliar
	}
	
	@Override
	public String toString() {
		return "Código = " + codigo + "\nPreço = " + preco + "\nNº máximo de reservas = " + maxReservas
				+ "\nQuantidade de reservas efetivas = " + getReservas().size();
	}
}