import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Excursao {

	// Atributos
	private int codigo; // Código da excursão
	private double preco; // Preço da excursão
	private int max; // Máximo de reservas
	
	// Array que armazenará as reservas
	private ArrayList<String> reservas = new ArrayList<>();

	// Construtor com 1 parâmetro
	public Excursao(int codigo) throws Exception {
		// Lança uma exceção se codigo <=0
		if (codigo <= 0)
			throw new Exception("O Código da excursão deve ser maior do que 0");
		// Caso não seja lançada a exceção
		this.codigo = codigo;
	}

	// Construtor com 3 parâmetros
	public Excursao(int codigo, double preco, int max) throws Exception {
		// Lança uma exceção se codigo <= 0
		if (codigo <= 0)
			throw new Exception("O código deve ser maior do que 0");
		// Lança uma exceção se preço <= 0
		if (preco <= 0)
			throw new Exception("O preço deve ser maior do que 0");
		// Lança uma exceção se max <= 0
		if (max <= 0)
			throw new Exception("O número de reservas deve ser maior do que 0");
		// Caso não seja lançada nenhuma exceção
		this.codigo = codigo;
		this.preco = preco;
		this.max = max;

		// Criando ArrayList com espaços vazios de acordo com o tamanho informado
		for (int i = 0; i < max; i++) {
			reservas.add("vazia");
		}
	}
	
	public void criarReserva(String cpf, String nome) throws Exception {
//	    boolean vagaEncontrada = false; // Variável para controlar se uma vaga foi encontrada

	    // Verifica se o número máximo de reservas foi atingido
	    if (reservas.size() > max) {
	        throw new Exception("O número máximo de reservas foi alcançado");
	    }

	    // Verifica se o nome já existe nas reservas
	    for (String reserva : reservas) {
	    	// Cada reserva é dividida em duas partes usando "/" como separador e armazenada no array 'partes'
	        String[] partes = reserva.split("/");
	        // Está verificando se o tamanho do array 'partes' é igual a 2 (para ignorar os casos onde há "vazia") e se o elemento na posição [1] é igual ao nome passado como parâmetro
	        if (partes.length == 2 && partes[1].equals(nome)) {
	        	// Se um nome duplicado for encontrado, será lançada a exceção abaixo
	            throw new Exception("Nome duplicado na reserva");
	        }
	    }

	    // É inicializada com -1 para indicar que nenhuma vaga vazia foi encontrada até o momento
	    int indexVagaVazia = -1;
	    
	    // Itera sobre cada reserva na lista reservas
	    for (int i = 0; i < reservas.size(); i++) {
	    	// Verifica se algum elemento é igual a "vazia" (em outras palavras, retorna o índice da primeira vaga "vazia" encontrada)
	        if (reservas.get(i).equals("vazia")) {
	        	// Se uma vaga "vazia" for encontrada, o índice da vaga é armazenado na variável 'indexVagaVazia'
	            indexVagaVazia = i;
	            // O loop é interrompido
	            break;
	        }
	    }

	    // Se não foi encontrada uma vaga vazia (ou seja, de 'indexVagaVazia' continua sendo igual a -1, significa que não foi encontrada nenhuma vaga vazia, logo lançamos uma exceção
	    if (indexVagaVazia == -1) {
	        throw new Exception("Todas as vagas estão ocupadas");
	    }

	    // Adiciona a reserva na vaga vazia encontrada
	    reservas.set(indexVagaVazia, cpf + "/" + nome);
	    
	    // Grava as reservas no arquivo 'codigo.csv' que será criado no diretório atual
	    File f = new File(new File(".\\codigo.csv").getCanonicalPath()); // pasta do projeto
	    // O objeto 'arq' é criado para escrever no arquivo representado por f. O argumento 'true' indica que novos dados serão adicionados ao final do arquivo, preservando os dados existentes
		FileWriter arq = new FileWriter(f, true);
		// Contém as informações solicitadas pelo professor que deveriam ser gravadas no arquivo .csv
		arq.write(getPreco() + "; " + getMax() + "; " + nome + "/" + cpf + "\n");
		// Fecha o arquivo
		arq.close();
	}

	// Remove uma reserva passando os campos "cpf/nome"
	public void cancelarReserva(String cpf, String nome) throws Exception {
		
	    // Variável de controle para verificar se a reserva foi encontrada
		boolean reservaEncontrada = false;
		
		// Varre a ArrayList 'reservas'
		for (int i = 0; i < reservas.size(); i++) {
		        String reserva = reservas.get(i);
		        String[] partes = reserva.split("/");

		        // Verifica se o CPF e o nome coincidem
		        // Ou seja, se o ArrayList 'reservas' possui o cpf (partes[0]) e o nome (partes[1]), a reserva em questão deverá ser removida
		        if (partes.length == 2 && partes[0].equals(cpf) && partes[1].equals(nome)) {
		        	
		        	// Remove a reserva caso a mesma seja encontrada
		            reservas.remove(i);
		            
		            // Ao invés de remover, também é uma possibilidade apenas alterar seu valor para "vazia" (perguntar a Fausto sobre isso...)
		            // reservas.set(i, "vazia");
		            		            
		            // Altera o valor da variável de controle
		            reservaEncontrada = true;
		            
		            // Sai do loop após a remoção
		            break;
		        }
		    }
			
			// Caso a reserva não seja encontrada, lança uma exceção
		    if (!reservaEncontrada) {
		        throw new Exception("CPF e/ou nome inexistente(s) nas reservas");
		    }
	}

	// Remove todas as reservas do cpf passado como parâmetro
	public void cancelarReserva(String cpf) throws Exception {
	    
		// Variável de controle para verificar se a reserva foi encontrada
		boolean cpfEncontrado = false;
		
		// ArrayList auxiliar para onde as reservas NÃO RELACIONADAS com o cpf serão armazenadas
	    ArrayList<String> reservasNaoRemovidas = new ArrayList<>();

	    // Varre a ArrayList 'reservas'
	    for (String reserva : reservas) {
	        String[] partes = reserva.split("/");

	        // Verifica se tem alguma vaga associada ao CPF
	        if (partes.length == 2 && partes[0].equals(cpf)) {
	            
	        	// Altera o valor da variável de controle
	            cpfEncontrado = true;
	        } 
	        
	        else {    
	        	// Caso a reserva em questão não esteja associada ao CPF, mantém a reserva na lista de reservas não removidas
	            reservasNaoRemovidas.add(reserva);
	        }
	    }

	    // Atualiza a lista de reservas apenas com as reservas não removidas
	    reservas = reservasNaoRemovidas;

	    // Caso a reserva não seja encontrada, lança uma exceção
	    if (!cpfEncontrado) {
	        throw new Exception("CPF inexistente(s) nas reservas");
	    }
		
//		boolean cpfEncontrado = false;
//
//	    // Varre a ArrayList 'reservas'
//	    for (int i = 0; i < reservas.size(); i++) {
//	        String reserva = reservas.get(i);
//	        String[] partes = reserva.split("/");
//
//	        // Verifica se tem alguma vaga associada ao CPF
//	        if (partes.length == 2 && partes[0].equals(cpf)) {
//	            // Altera o valor da reserva para "vazia"
//	            reservas.set(i, "vazia");
//	            cpfEncontrado = true;
//	        }
//	    }
//
//	    // Caso a reserva não seja encontrada, lança uma exceção
//	    if (!cpfEncontrado) {
//	        throw new Exception("CPF inexistente(s) nas reservas");
//	    }
	}

	public ArrayList<String> listarGeral() {
		return reservas;
	}

	// Retorna as reservas dos cpfs que contém os dígitos (ou retorna todas as reservas caso dígitos seja vazio)
	public ArrayList<String> listarReservasPorCpf(String cpf) throws Exception {
		
		if (cpf == "") {
			return reservas;
		}
		
		else {
			// Array auxiliar que será utilizado para armazenar as reservas associadas ao Cpf em questão (de modo a não alterar o ArrayList principal 'reservas'
			ArrayList<String> reservasPorCpf = new ArrayList<>();
			
			// Varre o array reservas à procura do cpf
			for (int i = 0; i < reservas.size(); i++) {
				String reserva = reservas.get(i);
		        String[] partes = reserva.split("/");

		        // Verifica se tem alguma vaga associada ao CPF
		        if (partes.length == 2 && partes[0].equals(cpf)) {
		            // Caso tenha alguma associação, a reserva em questão será armazenada no array auxiliar
		            reservasPorCpf.add(reserva);
		        }
			}
			// Retorna o array auxiliar
			return reservasPorCpf;
		}
	}

	// Retorna as reservas dos nomes que contém o texto (ou retorna todas as
	// reservas caso texto seja vazio)
	public ArrayList<String> listarReservasPorNome(String nome) {
		if (nome == "") {
			return reservas;
		}
		
		else {
			// Array auxiliar que será utilizado para armazenar as reservas associadas ao Cpf em questão (de modo a não alterar o ArrayList principal 'reservas'
			ArrayList<String> reservasPorNome = new ArrayList<>();
			
			// Varre o array reservas à procura do cpf
			for (int i = 0; i < reservas.size(); i++) {
				String reserva = reservas.get(i);
		        String[] partes = reserva.split("/");

		        // Verifica se tem alguma vaga associada ao CPF
		        if (partes.length == 2 && partes[1].equals(nome)) {
		            // Caso tenha alguma associação, a reserva em questão será armazenada no array auxiliar
		            reservasPorNome.add(reserva);
		        }
			}
			// Retorna o array auxiliar
			return reservasPorNome;
		}
	}

	// Calcular valor total da excursão = preço * qde de reservas
	public double calcularValorTotal() {
		return preco * (reservas.size());
	}

	// Retorna codigo, preço, max e total de reservas
	@Override
	public String toString() {
		return "Excursao [codigo=" + codigo + ", preco=" + preco + ", max=" + max + ", Quantidade de reservas="
				+ reservas.size() + "]";
	}

	// Gravar no arquivo “codigo.txt” o preço, max e as reservas
	public void salvar() {
	    
	}

	// Ler do arquivo “codigo.txt” o preço, max e as reservas
	public void carregar() {

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

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public ArrayList<String> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<String> reservas) {
		this.reservas = reservas;
	}
	
	
}