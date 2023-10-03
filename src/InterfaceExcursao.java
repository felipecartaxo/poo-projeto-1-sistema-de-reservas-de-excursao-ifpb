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
	private JLabel label_2;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

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
		button.setFont(new Font("Monospaced", Font.PLAIN, 12));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String codigo = JOptionPane.showInputDialog("Informe o código: ");
					String preco = JOptionPane.showInputDialog("Informe o preço: ");
					String maxReservas = JOptionPane.showInputDialog("Informe o n° máximo de reservas: ");
					excursao = new Excursao(Integer.parseInt(codigo), Double.parseDouble(preco),  Integer.parseInt(maxReservas));
					excursao.gravar();
					textArea.setText(excursao.toString());
					label.setText("Sua excursão foi criada.");
				}
				catch(NumberFormatException ex) {
					label.setText("Os campos devem ser do tipo numérico!");
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button.setBounds(133, 72, 161, 23);
		frame.getContentPane().add(button);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setBounds(43, 147, 349, 80);
		frame.getContentPane().add(textArea);
		
		label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Monospaced", Font.PLAIN, 14));
		label.setBounds(10, 416, 361, 14);
		frame.getContentPane().add(label);
		
		label_2 = new JLabel("Informações a respeito da excursão:");
		label_2.setFont(new Font("Monospaced", Font.BOLD, 14));
		label_2.setBounds(43, 122, 349, 14);
		frame.getContentPane().add(label_2);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 14));
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText("Se sua excursão já foi cadastrada, você pode consultar outras opções abaixo:");
		textArea_1.setBackground(new Color(128, 128, 255));
		textArea_1.setBounds(43, 257, 349, 54);
		frame.getContentPane().add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea_2.setText("Para cadastrar sua reserva, clique no botãoabaixo");
		textArea_2.setLineWrap(true);
		textArea_2.setBackground(new Color(128, 128, 255));
		textArea_2.setBounds(43, 24, 349, 47);
		frame.getContentPane().add(textArea_2);
		
		button_1 = new JButton("Criar reserva");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBackground(new Color(192, 192, 192));
		button_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		button_1.setBounds(43, 347, 148, 23);
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
		button_2.setFont(new Font("Monospaced", Font.PLAIN, 10));
		button_2.setBounds(43, 319, 148, 23);
		frame.getContentPane().add(button_2);
		
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
