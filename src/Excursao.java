import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Excursao {

	// Atributos
	private int codigo;
	private double preco;
	private int maxReservas;
	// Array que armazenará as reservas
	private ArrayList<String> reservas = new ArrayList<>();

	// Construtor com 1 parâmetro
	public Excursao(int codigo) throws Exception {
		// Lança uma exceção se 'codigo' <= 0
		if (codigo <= 0)
			throw new Exception("O código da excursão deve ser maior do que 0");
		// Caso não seja lançada a exceção
		this.codigo = codigo;
	}

	// Construtor com 3 parâmetros
	public Excursao(int codigo, double preco, int maxReservas) throws Exception {
		// Lança uma exceção se 'codigo' <= 0
		if (codigo <= 0)
			throw new Exception("O código da excursão deve ser maior do que 0");
		// Lança uma exceção se 'preco' <= 0
		if (preco <= 0)
			throw new Exception("O preço deve ser maior do que 0");
		// Lança uma exceção se 'maxReservas' <= 0
		if (maxReservas <= 0)
			throw new Exception("O número de reservas deve ser maior do que 0");
		// Caso não seja lançada nenhuma exceção
		this.codigo = codigo;
		this.preco = preco;
		this.maxReservas = maxReservas;

		// Criando ArrayList com espaços "disponivel" de acordo com o tamanho informado
		for (int i = 0; i < maxReservas; i++) {
			reservas.add("disponivel");
		}
	}

	public void criarReserva(String cpf, String nome) throws Exception {
		// Variável auxiliar que será utilizada para retornar (ou não) o índice da
		// primeira vaga disponível encontrada
		int vagaDisponivelEncontrada = -1;
		// Variável que será retornará o índice do primeiro elemento "disponível
		// encontrado
		int reservaAtualIndex = 0;
		// for-each para percorrer todos os itens de 'reservas'
		for (String reservaAtual : reservas) {
			// Cada reserva é dividida em duas partes usando "/" como separador e armazenada
			// no array 'partes'
			String[] partes = reservaAtual.split("/");
			// Está verificando se o tamanho do array 'partes' é igual a 2 (para ignorar os
			// casos onde há "disponivel") e se o elemento na posição [1] é igual ao nome
			// passado como parâmetro
			if (partes.length == 2 && partes[1].equals(nome)) {
				// Se um nome duplicado for encontrado, lançará uma exceção
				throw new Exception("Nome duplicado na reserva");
			}
		}
		// Itera sobre cada reserva no ArrayList 'reservas'
		for (String reservaAtual : reservas) {
			// Ao encontrar o primeiro elemento "disponível", retorna o índice do mesmo
			if (reservaAtual.equals("disponivel")) {
				vagaDisponivelEncontrada = reservaAtualIndex;
				// Sai do loop
				break;
			}
			// Incrementa o índice da variável auxiliar
			reservaAtualIndex++;
		}
		// Se não foi encontrada uma vaga disponivel (ou seja, se 'vagaDisponivelEncontrada' continua sendo igual a -1) lançamos uma exceção
		if (vagaDisponivelEncontrada == -1) {
			throw new Exception("Todas as vagas estão ocupadas");
		}
		// Adiciona a reserva na vaga disponivel encontrada
		reservas.set(vagaDisponivelEncontrada, cpf + "/" + nome);
	}

	// Remove uma reserva passando os campos "cpf/nome"
	public void cancelarReserva(String cpf, String nome) throws Exception {
		// Variável de controle para verificar se a reserva foi encontrada
		boolean reservaEncontrada = false;
		// Varre a ArrayList 'reservas'
		for (int i = 0; i < reservas.size(); i++) {
			// Como o método 'split' é um método de String, iremos armazenar cada elemento de 'reservas' como String
			String reservaAtual = reservas.get(i);
			// E em seguida, no array partes, iremos quebrá-los com o método split
			String[] partes = reservaAtual.split("/");
			// Se o ArrayList 'reservas' possui o cpf (partes[0]) e o nome (partes[1]), a reserva em questão deverá ser removida
			if (partes.length == 2 && partes[0].equals(cpf) && partes[1].equals(nome)) {
				// Remove a reserva caso a mesma seja encontrada
				reservas.remove(i);
				// Altera o valor da variável de controle
				reservaEncontrada = true;
				// Sai do loop após a remoção
				break;
			}
		}
		// Caso a reserva não seja encontrada, lança uma exceção
		if (!reservaEncontrada) {
			throw new Exception("CPF e/ou nome inexistente(s)");
		}
	}

	// Remove todas as reservas do cpf passado como parâmetro
	public void cancelarReserva(String cpf) throws Exception {
		// Variável de controle para verificar se a reserva foi encontrada
		boolean cpfEncontrado = false;
		// ArrayList auxiliar para onde as reservas NÃO RELACIONADAS com o cpf serão armazenadas
		ArrayList<String> reservasNaoRemovidas = new ArrayList<>();
		// Varre a ArrayList 'reservas'
		for (String reservaAtual : reservas) {
			String[] partes = reservaAtual.split("/");
			// Verifica se tem alguma vaga associada ao CPF
			if (partes.length == 2 && partes[0].equals(cpf)) {
				// Altera o valor da variável de controle
				cpfEncontrado = true;
			} else {
				// Caso a reserva em questão não esteja associada ao CPF, mantém a reserva na lista de reservas não removidas
				reservasNaoRemovidas.add(reservaAtual);
			}
		}
		// Atualiza a lista de reservas apenas com as reservas não removidas
		reservas = reservasNaoRemovidas;
		// Caso a reserva não seja encontrada, lança uma exceção
		if (!cpfEncontrado) {
			throw new Exception("CPF inexistente");
		}
	}

	// Retorna as reservas relacionadas ao 'cpf' que foi passado no método
	public ArrayList<String> listarReservasPorCpf(String cpf) throws Exception {
		// Caso o cpf seja vazio, retorna todas as reservas
		if (cpf == "") {
			return reservas;
		}
		// Caso contrário, iremos procurar se alguma reserva bate com 'cpf'
		else {
			// ArrayList auxiliar para armazenar as reservas que batem com o 'cpf' passado no método
			ArrayList<String> reservasPorCpf = new ArrayList<>();
			for (String reservaAtual : reservas) {
				String[] partes = reservaAtual.split("/");
				if(partes.length == 2 && partes[0].equals(cpf)) {
					// Caso alguma reserva possua o 'cpf' igual, esta reserva será adicionada ao ArrayList auxiliar
					reservasPorCpf.add(reservaAtual);
				}
			}
			// Retorna o array auxiliar
			return reservasPorCpf;
		}
	}

	// Retorna as reservas relacionadas ao 'nome' passado no método
	public ArrayList<String> listarReservasPorNome(String nome) {
		// Caso 'nome' seja vazio, retorna todas as reservas
		if (nome == "") {
			return reservas;
		} else {
			// ArrayList auxiliar para armazenar as reservas que batem com o 'nome' passado
			// no método
			ArrayList<String> reservasPorNome = new ArrayList<>();
			for (String reservaAtual : reservas) {
				String[] partes = reservaAtual.split("/");
				if (partes.length == 2 && partes[1].equals(nome)) {
					// Caso alguma reserva possua o 'nome' igual, está reserva será adicionada ao
					// ArrayList auxiliar
					reservasPorNome.add(reservaAtual);
				}
			}
			// Retorna o array auxiliar
			return reservasPorNome;
		}
	}

	// Calcular valor total da excursão = preço * qde de reservas
	public double calcularValorTotal() {
		// Vai retornar o valor total contabilizando apenas as vagas que estão
		// preenchidas
		return preco * (getReservas().size());
	}

	// Gravar no arquivo “codigo.txt” o preço, maxReservas e as reservas
	public void salvar() throws IOException {
		// Grava as reservas no arquivo 'codigo.csv' que será criado no diretório atual
		File f = new File(new File(".\\" + getCodigo() + ".csv").getCanonicalPath()); // pasta do projeto
		// O objeto 'arq' é criado para escrever no arquivo representado por f. O argumento 'true' indica que novos dados serão adicionados ao final do arquivo, preservando os dados existentes
		FileWriter arq = new FileWriter(f, true);
		// Contém as informações solicitadas pelo professor que deveriam ser gravadas no arquivo .csv
		arq.write(getPreco() + "; " + getMaxReservas() + "; " + getReservas() + "\n");
		// Fecha o arquivo
		arq.close();
	}

	// Ler do arquivo “codigo.txt” o preço, maxReservas e as reservas
	public void carregar() {

	}
	
	// Grava os dados no arquivo .csv
	public void gravar() throws Exception {
		try {
			// Tenta abrir o arquivo "codigo.csv", localizado na pasta do projeto, usando um objeto 'File'
			File f = new File(new File(".\\" + getCodigo() + ".csv").getCanonicalPath());
			// Em seguida, utiliza um 'FileWriter' para escrever no arquivo. O parâmetro 'false' indica que o arquivo deve ser aberto para escrita, substituindo o conteúdo anterior
			FileWriter arquivo = new FileWriter(f, false);
			// Grava a primeira linha do arquivo (linha de cabecalho contendo o Preço e o Nº máximo de reservas da excursão)
			arquivo.write("Preço; Max; Reserva\n");
			// Variável responsável por armazenar a reserva
			String reservaAtual;
			// Percorre o ArrayList 'reservas', verificando se uma reserva está ocupada (ou seja, não é "disponivel"). Se uma reserva estiver ocupada, escreve o número da reserva e a o registro correspondente no arquivo .csv
			for (int i = 0; i < reservas.size(); i++) {
				reservaAtual = reservas.get(i);
				// Gravar no arquivo “codigo.txt” o preço, max e as reservas
				arquivo.write(getPreco() + "; " + getMaxReservas() + "; " + reservaAtual + "\n");
			}
			arquivo.close();
		}
		catch (IOException e) {
			throw new Exception("Problema na gravação do arquivo");
		}
	}

	// Retorna codigo, preço, maxReservas e total de reservas
	@Override
	public String toString() {
		return "Código = " + codigo + "\nPreço = " + preco + "\nNº máximo de reservas = " + maxReservas
				+ "\nQuantidade de reservas efetivas = " + getReservas().size();
	}

	// Getters e Setters
	public int getCodigo() {
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
		// Cria um ArrayList auxiliar par armazenar apenas as reservas efetivas
		ArrayList<String> reservasEfetivas = new ArrayList<String>();
		// for-each para percorrer 'reservas'
		for (String reservaAtual : reservas) {
			// Se o elemento atual for diferente de "disponível", ou seja, for uma reserva
			// de fato, não será adicionada ao ArrayList auxiliar
			if (!reservaAtual.equals("disponivel")) {
				// Adicionará ao 'arrayReservaEfetiva'
				reservasEfetivas.add(reservaAtual);
			}
		}
		// Retorna o ArrayList auxiliar
		return reservasEfetivas;
	}
}