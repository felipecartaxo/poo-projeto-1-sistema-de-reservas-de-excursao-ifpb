import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Interface {

	private JFrame frame;
	private JPanel panel;
	private JButton btnCriarExcursao;
	private JButton btnRecuperarExcursao;
	private JButton btnCriarReserva1;
	private JButton btnCancelar2;
	private JButton btnListarReserva1;
	private JButton btnListarReserva2;
	private JButton btnCalcularValorTotal;
	private JTextArea main;
	private JLabel log;
	private JLabel label_1;
	private JTextField textCodigo;
	private JLabel label_2;
	private JTextField textPreco;
	private JLabel label_3;
	private JTextField textMaxReservas;
	private JLabel label_4;
	private JTextField textCpf;
	private JLabel label_5;
	private JTextField textNome;
	
	private Excursao excursao;
	private JButton btnCancelar1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnCriarExcursao = new JButton("Criar excursão");
		btnCriarExcursao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(textCodigo.getText());
					double preco = Double.parseDouble(textPreco.getText());
					int maxReservas = Integer.parseInt(textMaxReservas.getText());
					
					if ((preco <= 0) && (maxReservas <= 0)) {
						excursao = new Excursao(codigo);
						excursao.gravar();
					}
					else {
						excursao = new Excursao(codigo, preco, maxReservas);
						excursao.gravar();
					}
					
					log.setText("Excursão " + codigo + " criada com sucesso.");
					
					
				}
				catch (Exception ex) {
					log.setText(ex.getMessage());
				}
			}
		});
		btnCriarExcursao.setBounds(10, 11, 151, 23);
		panel.add(btnCriarExcursao);
		
		btnRecuperarExcursao = new JButton("Recuperar excursão");
		btnRecuperarExcursao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(textCodigo.getText());
					excursao = new Excursao(codigo);
					log.setText("Excursão recuperada");
					main.setText(excursao.toString());
				}
				catch(Exception ex) {
					log.setText("Código não registrado.");
				}
			}
		});
		btnRecuperarExcursao.setBounds(10, 45, 151, 23);
		panel.add(btnRecuperarExcursao);
		
		btnCriarReserva1 = new JButton("Criar reserva");
		btnCriarReserva1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = textCpf.getText();
					String nome = textNome.getText();
					
					excursao.criarReserva(cpf, nome);
					log.setText("Reserva criada com sucesso");
				}
				catch(Exception ex) {
					log.setText(ex.getMessage());
				}	
			}
		});
		btnCriarReserva1.setBounds(10, 79, 151, 23);
		panel.add(btnCriarReserva1);
		
		btnCancelar2 = new JButton("Canc reserva (grupo)");
		btnCancelar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = textCpf.getText();
					
					excursao.cancelarReserva(cpf);
					log.setText("Reserva removida com sucesso.");
				}
				catch(Exception ex) {
					log.setText(ex.getMessage());
				}
			}
		});
		btnCancelar2.setBounds(10, 148, 151, 23);
		panel.add(btnCancelar2);
		
		btnListarReserva1 = new JButton("Listar reservas (cpf)");
		btnListarReserva1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = textCpf.getText();
					ArrayList<String> reservasEfetivas = excursao.listarReservasPorCpf(cpf);
					StringBuffer sb = new StringBuffer();
					for (String reservaAtual : reservasEfetivas) {
						sb.append(reservaAtual);
						sb.append("\n");
					}
					main.setText((sb.toString()));
				}
				catch (Exception ex) {
					log.setText(ex.getMessage());
				}
			}
		});
		btnListarReserva1.setBounds(10, 182, 151, 23);
		panel.add(btnListarReserva1);
		
		btnListarReserva2 = new JButton("Listar reservas (nome)");
		btnListarReserva2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textNome.getText();
					ArrayList<String> reservasEfetivas = excursao.listarReservasPorNome(nome);
					StringBuffer sb = new StringBuffer();
					for (String reservaAtual : reservasEfetivas) {
						sb.append(reservaAtual);
						sb.append("\n");
					}
					main.setText((sb.toString()));
				}
				catch (Exception ex) {
					log.setText(ex.getMessage());
				}
			}
		});
		btnListarReserva2.setBounds(10, 216, 151, 23);
		panel.add(btnListarReserva2);
		
		btnCalcularValorTotal = new JButton("Calcular valor total");
		btnCalcularValorTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String valorTotal = Double.toString(excursao.calcularValorTotal());	
					main.setText(valorTotal);
				}
				catch(Exception ex) {
					log.setText(ex.getMessage());
				}
			}
		});
		btnCalcularValorTotal.setBounds(10, 250, 151, 23);
		panel.add(btnCalcularValorTotal);
		
		main = new JTextArea();
		main.setBounds(10, 289, 414, 285);
		panel.add(main);
		
		log = new JLabel("Log: ");
		log.setBounds(10, 566, 414, 84);
		panel.add(log);
		
		label_1 = new JLabel("Código:");
		label_1.setBounds(171, 15, 46, 14);
		panel.add(label_1);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(242, 12, 182, 20);
		panel.add(textCodigo);
		textCodigo.setColumns(10);
		
		label_2 = new JLabel("Preço:");
		label_2.setBounds(171, 49, 46, 14);
		panel.add(label_2);
		
		textPreco = new JTextField();
		textPreco.setBounds(242, 46, 182, 20);
		panel.add(textPreco);
		textPreco.setColumns(10);
		
		label_3 = new JLabel("N° reservas:");
		label_3.setBounds(171, 83, 68, 14);
		panel.add(label_3);
		
		textMaxReservas = new JTextField();
		textMaxReservas.setBounds(242, 80, 182, 20);
		panel.add(textMaxReservas);
		textMaxReservas.setColumns(10);
		
		label_4 = new JLabel("CPF:");
		label_4.setBounds(171, 117, 46, 14);
		panel.add(label_4);
		
		textCpf = new JTextField();
		textCpf.setBounds(242, 114, 182, 20);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		label_5 = new JLabel("Nome:");
		label_5.setBounds(171, 151, 46, 14);
		panel.add(label_5);
		
		textNome = new JTextField();
		textNome.setBounds(242, 148, 182, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		btnCancelar1 = new JButton("Canc reserva (indiv)");
		btnCancelar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = textCpf.getText();
					String nome = textNome.getText();
					
					excursao.cancelarReserva(cpf, nome);
					log.setText("Reserva " + cpf + "/" + nome + " removida com sucesso.");
				}
				catch(Exception ex) {
					log.setText(ex.getMessage());
				}
			}
		});
		btnCancelar1.setBounds(10, 113, 151, 23);
		panel.add(btnCancelar1);
	}
}
