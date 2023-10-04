import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExcursaoInterface {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField codigoInput;
	private JTextField precoInput;
	private JTextField maxReservasInput;
	private JButton criarExcursaoButton;
	private JPanel panel_1;
	private JLabel label_3;
	private JTextField recuperarCodInput;
	private JPanel panel_2;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField cpfInput;
	private JTextField nomeInput;
	private JButton criarReservaButton;
	private JLabel criarReservaLog;
	private JPanel panel_3;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel label_11;
	private JLabel label_12;
	private JButton button_2;
	private JButton button_3;
	private JTextField textField_8;
	private JPanel panel_4;
	private JLabel label_13;
	private JTextArea listarReservasCpfTextArea;
	private JButton button_4;
	private JTextField listarReservasCpfInput;
	private JPanel panel_5;
	private JLabel label_14;
	private JTextArea listarReservasNomeTextArea;
	private JButton listarReservasNomeButton;
	private JTextField listarReservasNomeInput;
	private JPanel panel_6;
	private JButton button_6;
	private JLabel label_15;
	private JTextField textField_11;
	private JButton SalvarButton;
	private JButton CarregarButton;
	
	private Excursao excursao;
	private JLabel cadastroExcursaoLog;
	private JButton button;
	private JLabel recuperarLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcursaoInterface window = new ExcursaoInterface();
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
	public ExcursaoInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 292);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Criar excursão", null, panel, null);
		panel.setLayout(null);
		
		label = new JLabel("Informe o código:");
		label.setBounds(10, 11, 205, 14);
		panel.add(label);
		
		label_1 = new JLabel("Informe o preço:");
		label_1.setBounds(10, 47, 205, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("Informe o n° máximo de reservas:");
		label_2.setBounds(10, 82, 205, 14);
		panel.add(label_2);
		
		codigoInput = new JTextField();
		codigoInput.setBounds(268, 8, 151, 20);
		panel.add(codigoInput);
		codigoInput.setColumns(10);
		
		precoInput = new JTextField();
		precoInput.setBounds(268, 44, 151, 20);
		panel.add(precoInput);
		precoInput.setColumns(10);
		
		maxReservasInput = new JTextField();
		maxReservasInput.setBounds(268, 79, 151, 20);
		panel.add(maxReservasInput);
		maxReservasInput.setColumns(10);
		
		criarExcursaoButton = new JButton("Criar excursão");
		criarExcursaoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(codigoInput.getText());
					double preco = Double.parseDouble(codigoInput.getText());
					int maxReservas = Integer.parseInt(maxReservasInput.getText());
					
					if ((preco <= 0) && (maxReservas <= 0)) {
						excursao = new Excursao(codigo);
						excursao.gravar();
					}
					else {
						excursao = new Excursao(codigo, preco, maxReservas);
						excursao.gravar();
					}
					
					codigoInput.setText("");
					precoInput.setText("");
					maxReservasInput.setText("");
					
					cadastroExcursaoLog.setText("Excursão criada com sucesso.");
				}
				catch (Exception ex) {
					cadastroExcursaoLog.setText(ex.getMessage());
				}
			}
		});
		criarExcursaoButton.setBounds(23, 159, 125, 23);
		panel.add(criarExcursaoButton);
		
		SalvarButton = new JButton("Salvar");
		SalvarButton.setBounds(159, 159, 110, 23);
		panel.add(SalvarButton);
		
		CarregarButton = new JButton("Carregar");
		CarregarButton.setBounds(282, 159, 135, 23);
		panel.add(CarregarButton);
		
		cadastroExcursaoLog = new JLabel("");
		cadastroExcursaoLog.setBounds(23, 211, 394, 14);
		panel.add(cadastroExcursaoLog);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Criar reserva", null, panel_2, null);
		panel_2.setLayout(null);
		
		label_4 = new JLabel("CPF:");
		label_4.setBounds(10, 24, 153, 14);
		panel_2.add(label_4);
		
		label_5 = new JLabel("Nome completo:");
		label_5.setBounds(10, 49, 153, 14);
		panel_2.add(label_5);
		
		cpfInput = new JTextField();
		cpfInput.setBounds(228, 21, 191, 20);
		panel_2.add(cpfInput);
		cpfInput.setColumns(10);
		
		nomeInput = new JTextField();
		nomeInput.setBounds(228, 52, 191, 20);
		panel_2.add(nomeInput);
		nomeInput.setColumns(10);
		
		criarReservaButton = new JButton("Criar reserva");
		criarReservaButton.setBounds(130, 127, 153, 23);
		panel_2.add(criarReservaButton);
		
		criarReservaLog = new JLabel("");
		criarReservaLog.setBackground(new Color(64, 0, 128));
		criarReservaLog.setBounds(10, 188, 409, 14);
		panel_2.add(criarReservaLog);
		criarReservaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = cpfInput.getText();
					String nome = nomeInput.getText();
					
					excursao.criarReserva(cpf, nome);
					criarReservaLog.setText("Reserva criada com sucesso");
					excursao.gravar();
					
					cpfInput.setText("");
					nomeInput.setText("");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Cancelar reserva", null, panel_3, null);
		panel_3.setLayout(null);
		
		label_8 = new JLabel("Cancelar reserva invidual:");
		label_8.setBounds(147, 11, 264, 14);
		panel_3.add(label_8);
		
		label_9 = new JLabel("CPF:");
		label_9.setBounds(25, 39, 140, 14);
		panel_3.add(label_9);
		
		label_10 = new JLabel("Nome:");
		label_10.setBounds(25, 64, 140, 14);
		panel_3.add(label_10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(218, 36, 201, 20);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(218, 61, 201, 20);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		label_11 = new JLabel("Cancelar reserva grupo:");
		label_11.setBounds(157, 142, 117, 14);
		panel_3.add(label_11);
		
		label_12 = new JLabel("CPF:");
		label_12.setBounds(25, 170, 140, 14);
		panel_3.add(label_12);
		
		button_2 = new JButton("Cancelar reserva (indiv)");
		button_2.setBounds(131, 102, 177, 23);
		panel_3.add(button_2);
		
		button_3 = new JButton("Cancelar reserva (grupo)");
		button_3.setBounds(131, 199, 177, 23);
		panel_3.add(button_3);
		
		textField_8 = new JTextField();
		textField_8.setBounds(218, 167, 201, 20);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("Listar reservas por CPF", null, panel_4, null);
		panel_4.setLayout(null);
		
		label_13 = new JLabel("CPF:");
		label_13.setBounds(22, 22, 85, 14);
		panel_4.add(label_13);
		
		listarReservasCpfTextArea = new JTextArea();
		listarReservasCpfTextArea.setBounds(21, 47, 398, 134);
		panel_4.add(listarReservasCpfTextArea);
		
		button_4 = new JButton("Listar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = listarReservasCpfInput.getText();
					ArrayList<String> reservasEfetivas = excursao.listarReservasPorCpf(cpf);
					StringBuffer sb = new StringBuffer();
					for (String reservaAtual : reservasEfetivas) {
						sb.append(reservaAtual);
						sb.append("\n");
					}
					listarReservasCpfTextArea.setText((sb.toString()));
				}
				catch (Exception ex) {
					label.setText(ex.getMessage());
				}
				
			}
		});
		button_4.setBounds(303, 18, 116, 23);
		panel_4.add(button_4);
		
		listarReservasCpfInput = new JTextField();
		listarReservasCpfInput.setBounds(72, 19, 221, 20);
		panel_4.add(listarReservasCpfInput);
		listarReservasCpfInput.setColumns(10);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		tabbedPane.addTab("Listar reservas por nome", null, panel_5, null);
		
		label_14 = new JLabel("Nome:");
		label_14.setBounds(22, 22, 85, 14);
		panel_5.add(label_14);
		
		listarReservasNomeTextArea = new JTextArea();
		listarReservasNomeTextArea.setBounds(21, 47, 398, 134);
		panel_5.add(listarReservasNomeTextArea);
		
		listarReservasNomeButton = new JButton("Listar");
		listarReservasNomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = listarReservasNomeInput.getText();
					ArrayList<String> reservasEfetivas = excursao.listarReservasPorNome(nome);
					StringBuffer sb = new StringBuffer();
					for (String reservaAtual : reservasEfetivas) {
						sb.append(reservaAtual);
						sb.append("\n");
					}
					listarReservasNomeTextArea.setText((sb.toString()));
				}
				catch (Exception ex) {
					label.setText(ex.getMessage());
				}
				
			}
		});
		listarReservasNomeButton.setBounds(303, 18, 116, 23);
		panel_5.add(listarReservasNomeButton);
		
		listarReservasNomeInput = new JTextField();
		listarReservasNomeInput.setColumns(10);
		listarReservasNomeInput.setBounds(72, 19, 221, 20);
		panel_5.add(listarReservasNomeInput);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Recuperar excursão", null, panel_1, null);
		panel_1.setLayout(null);
		
		label_3 = new JLabel("Insira o código da excursão:");
		label_3.setBounds(10, 25, 181, 14);
		panel_1.add(label_3);
		
		recuperarCodInput = new JTextField();
		recuperarCodInput.setBounds(238, 22, 181, 20);
		panel_1.add(recuperarCodInput);
		recuperarCodInput.setColumns(10);
		
		button = new JButton("Recuperar excursão");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(recuperarCodInput.getText());
					excursao = new Excursao(codigo);
					recuperarLabel.setText("Excursão recuperada");
				}
				catch(Exception ex) {
					recuperarLabel.setText(ex.getMessage());
				}
			}
		});
		button.setBounds(141, 71, 134, 23);
		panel_1.add(button);
		
		recuperarLabel = new JLabel("");
		recuperarLabel.setBounds(10, 205, 409, 14);
		panel_1.add(recuperarLabel);
		
		panel_6 = new JPanel();
		tabbedPane.addTab("Calcular valor total", null, panel_6, null);
		panel_6.setLayout(null);
		
		button_6 = new JButton("Calcular valor total");
		button_6.setBounds(139, 55, 154, 23);
		panel_6.add(button_6);
		
		label_15 = new JLabel("Valor total (R$):");
		label_15.setBounds(53, 115, 92, 14);
		panel_6.add(label_15);
		
		textField_11 = new JTextField();
		textField_11.setBounds(170, 111, 163, 20);
		panel_6.add(textField_11);
		textField_11.setColumns(10);
	}
}
