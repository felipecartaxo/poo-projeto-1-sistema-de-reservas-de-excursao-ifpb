package model.entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excursao {
	// Atributos
	private int codigo;
	private double preco;
	private int maxReservas;

	private ArrayList<String> reservas = new ArrayList<>();

	// Construtor com apenas um argumento e tratamento de exceção
	public Excursao(int codigo) throws Exception {
		if (codigo <= 0) {
			throw new Exception("O código da excursão deve ser maior do que zero.");
		}

		this.codigo = codigo;
		this.carregar();
	}

	// Construtor com três argumentos e tratamento de exceção
	public Excursao(int codigo, double preco, int maxReservas) throws Exception {
		if (codigo <= 0) {
			throw new Exception("O código da excursão deve ser maior do que zero.");
		}
		if (preco <= 0) {
			throw new Exception("O preco deve ser maior do que zero.");
		}
		if (maxReservas <= 0) {
			throw new Exception("O n° máximo de reservas deve ser maior do que zero.");
		}

		this.codigo = codigo;
		this.preco = preco;
		this.maxReservas = maxReservas;

		this.gravar(); // Ao instanciar o objeto, grava no arquivo
	}

	// Getters e setters
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

	public void setMaxReservas(int maxReservas) {
		this.maxReservas = maxReservas;
	}

	public ArrayList<String> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<String> reservas) {
		this.reservas = reservas;
	}

	// Métodos principais da aplicação

	// Cria a reserva e lança exceção
	public void criarReserva(String cpf, String nome) throws Exception {
		for (String reservaAtual : reservas) {
			String[] partes = reservaAtual.split("/");

			if (partes[1].equals(nome)) {
				throw new Exception("Nome duplicado na reserva");
			}
		}
		if (reservas.size() >= maxReservas) {
			throw new Exception("Limite de reservas atingido");
		}

		reservas.add(cpf + "/" + nome);

		this.gravar(); // Grava no arquivo após criar a reserva
	}

	// Cancela reserva existente a partir do CPF
	public void cancelarReserva(String cpf) throws Exception {
		boolean reservaEncontrada = false;

		for (int i = reservas.size() - 1; i >= 0; i--) {
			if (reservas.get(i).contains(cpf)) {
				reservas.remove(i);
				reservaEncontrada = true;
			}
		}

		this.gravar();

		// Lança exceção caso o CPF passado como argumento não exista
		if (!reservaEncontrada) {
			throw new Exception("CPF inexistente");
		}
	}

	// Cancela reserva a partir do CPF e nome
	public void cancelarReserva(String cpf, String nome) throws Exception {
		boolean reservaEncontrada = false;

		for (int i = 0; i < reservas.size(); i++) {
			String reservaAtual = reservas.get(i);
			String[] partes = reservaAtual.split("/");

			if (partes[0].equals(cpf) && partes[1].equals(nome)) {
				reservas.remove(i);
				reservaEncontrada = true;

				this.gravar();

				break;
			}
		}

		// Lança exceção caso o CPF e/ou o nome passado como argumento não exista
		if (!reservaEncontrada) {
			throw new Exception("CPF e/ou nome inexistente(s)");
		}
	}

	// Lista todas as reservas a partir de um CPF
	public ArrayList<String> listarReservasPorCpf(String cpf) throws Exception {
		if (cpf.equals("")) {
			return reservas;
		} else {
			ArrayList<String> reservasPorCpf = new ArrayList<>();

			for (String reservaAtual : reservas) {
				String[] partes = reservaAtual.split("/");

				if (partes.length == 2 && (partes[0].equals(cpf) || partes[0].contains(cpf))) {
					reservasPorCpf.add(reservaAtual);
				}
			}

			return reservasPorCpf;
		}
	}

	// Lista as reservas a partir de um nome
	public ArrayList<String> listarReservasPorNome(String nome) {
		if (nome.equals("")) {
			return reservas;
		} else {
			ArrayList<String> reservasPorNome = new ArrayList<>();

			for (String reservaAtual : reservas) {
				String[] partes = reservaAtual.split("/");

				if (partes.length == 2 && (partes[1].equals(nome) || partes[1].contains(nome))) {
					reservasPorNome.add(reservaAtual);
				}
			}
			return reservasPorNome;
		}
	}

	// Calcula o valor total da excursão
	public double calcularValorTotal() {
		return preco * (getReservas().size());
	}

	// Grava os dados no arquivo .csv
	public void gravar() throws Exception {
		try {
			File f = new File(new File(".\\" + getCodigo() + ".csv").getCanonicalPath());
			FileWriter arquivo = new FileWriter(f, false);
			arquivo.write(getPreco() + "; " + getMaxReservas() + "\n");

			for (int i = 0; i < reservas.size(); i++) {
				arquivo.write(reservas.get(i) + "\n");
			}

			arquivo.close();
		} catch (IOException e) {
			throw new Exception("Problema na gravacao do arquivo de saida");
		}
	}

	// Carrega os dados a partir do arquivo .csv existente
	public void carregar() throws Exception {
		try {
			File f = new File(".\\" + getCodigo() + ".csv");
			Scanner s = new Scanner(f);

			reservas.clear();

			if (s.hasNextLine()) {
				s.hasNextLine();
			}

			while (s.hasNextLine()) {
				String reservaAtual = s.nextLine();

				reservas.add(reservaAtual);
			}

			s.close();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// toString
	@Override
	public String toString() {
		return "Excursao [codigo=" + codigo + ", preco=" + preco + ", maxReservas=" + maxReservas + ", reservas="
				+ reservas + "]";
	}
}