import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Cursor;
import java.awt.Font;

public class InterfaceExcursao {

	private JFrame frame;
	private JButton button;
	private JTextArea textArea;
	private JLabel label;
	
	private Excursao excursao;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceExcursao window = new InterfaceExcursao();
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
	public InterfaceExcursao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Monospaced", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.setTitle("Sistema de Reservas de Excursão");
		frame.setBounds(100, 100, 450, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Cadastra uma excursão
		button = new JButton("Cadastrar excursão");
		button.setBackground(new Color(192, 192, 192));
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String codigo = JOptionPane.showInputDialog("Informe o código: ");
					String preco = JOptionPane.showInputDialog("Informe o preço: ");
					String maxReservas = JOptionPane.showInputDialog("Informe o n° máximo de reservas: ");
					excursao = new Excursao(Integer.parseInt(codigo), Double.parseDouble(preco),  Integer.parseInt(maxReservas));
					excursao.gravar();
					textArea.setText(excursao.toString() + "\n\nSua excursão foi criada.");
					textArea.setText("");
				}
				catch(NumberFormatException ex) {
					label.setText("Os campos devem ser do tipo numérico!");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button.setBounds(133, 75, 161, 23);
		frame.getContentPane().add(button);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setBounds(43, 332, 349, 98);
		frame.getContentPane().add(textArea);
		
		label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Monospaced", Font.PLAIN, 14));
		label.setBounds(10, 416, 361, 14);
		frame.getContentPane().add(label);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText("Se sua excursão já foi cadastrada, você pode consultar outras opções abaixo:");
		textArea_1.setBackground(new Color(128, 128, 255));
		textArea_1.setBounds(43, 109, 349, 54);
		frame.getContentPane().add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea_2.setText("Para cadastrar sua reserva, clique no botãoabaixo:");
		textArea_2.setLineWrap(true);
		textArea_2.setBackground(new Color(128, 128, 255));
		textArea_2.setBounds(43, 24, 349, 47);
		frame.getContentPane().add(textArea_2);
		
		button_1 = new JButton("Criar reserva");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBackground(new Color(192, 192, 192));
		button_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_1.setBounds(43, 196, 167, 23);
		frame.getContentPane().add(button_1);
		
		// Recuperar dados de uma excursão existente
		button_2 = new JButton("Recuperar excursão");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String codigo = JOptionPane.showInputDialog("Informe o código: ");
				}
				catch(Exception ex) {
					textArea.setText(ex.getMessage());
				}
			}
		});
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setBackground(new Color(192, 192, 192));
		button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_2.setBounds(43, 162, 167, 23);
		frame.getContentPane().add(button_2);
		
		button_4 = new JButton("Cancelar reserva (cpf)");
		button_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(225, 162, 167, 23);
		frame.getContentPane().add(button_4);
		
		button_5 = new JButton("Cancelar reserva (nome)");
		button_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_5.setBounds(225, 197, 167, 23);
		frame.getContentPane().add(button_5);
		
		button_6 = new JButton("Listar reservas (cpf)");
		button_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_6.setBounds(43, 230, 167, 23);
		frame.getContentPane().add(button_6);
		
		button_7 = new JButton("Listar reservas (nome)");
		button_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		button_7.setBounds(42, 264, 168, 23);
		frame.getContentPane().add(button_7);
		
		button_8 = new JButton("Calcular valor total");
		button_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_8.setBounds(225, 231, 167, 23);
		frame.getContentPane().add(button_8);
		
		button_9 = new JButton("Salvar");
		button_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_9.setBounds(225, 265, 167, 23);
		frame.getContentPane().add(button_9);
		
		button_10 = new JButton("Carregar");
		button_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		button_10.setBounds(133, 298, 161, 23);
		frame.getContentPane().add(button_10);
		
		// Cria uma reserva para uma excursão existente
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = JOptionPane.showInputDialog("Informe o cpf: ");
					String nome = JOptionPane.showInputDialog("Informe o nome: ");
					
					excursao.criarReserva(cpf, nome);
					excursao.gravar();
					label.setText("Foi adicionada uma reserva.");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		
		
		
		
	}
}
