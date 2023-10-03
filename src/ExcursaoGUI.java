import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ExcursaoGUI {

	private JFrame frame;
	private JLabel label;
	private JTextArea textArea;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JLabel label_1;
	private Excursao excursao;
	private JButton button;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcursaoGUI window = new ExcursaoGUI();
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
	public ExcursaoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.setTitle("Sistema de Reservas de Excursão");
		frame.setBounds(100, 100, 440, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("Para cadastrar sua reserva, clique no botão abaixo:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(51, 28, 344, 14);
		frame.getContentPane().add(label);
		
//		label_2 = new JLabel("Código:");
//		label_2.setBounds(51, 67, 46, 14);
//		frame.getContentPane().add(label_2);
//		
//		label_3 = new JLabel("Preço:");
//		label_3.setBounds(51, 92, 46, 14);
//		frame.getContentPane().add(label_3);
//		
//		label_4 = new JLabel("N° máximo de reservas:");
//		label_4.setBounds(51, 117, 155, 14);
//		frame.getContentPane().add(label_4);
//		
//		textField = new JTextField();
//		textField.setBounds(224, 64, 86, 20);
//		frame.getContentPane().add(textField);
//		textField.setColumns(10);
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(224, 89, 86, 20);
//		frame.getContentPane().add(textField_1);
//		textField_1.setColumns(10);
//		
//		textField_2 = new JTextField();
//		textField_2.setBounds(224, 114, 86, 20);
//		frame.getContentPane().add(textField_2);
//		textField_2.setColumns(10);
		
		button = new JButton("Cadastrar reserva");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int codigo = Integer.parseInt(textField.getText());
//				double preco = Double.parseDouble(textField_1.getText());
//				int maxReservas = Integer.parseInt(textField_2.getText());
//				
//				try {
//					excursao = new Excursao(codigo, preco, maxReservas);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				label_1.setText("Excursão criada com sucesso!");
				
				String codigo = JOptionPane.showInputDialog("Informe o código: ");
				String preco = JOptionPane.showInputDialog("Informe o preço: ");
				String maxReservas = JOptionPane.showInputDialog("Informe o n° máximo de reservas: ");
				
				try {
					excursao = new Excursao(Integer.parseInt(codigo), Double.parseDouble(preco),  Integer.parseInt(maxReservas));
					// label_1.setText("Excursão criada com sucesso!");
					excursao.gravar();
					textArea_1.setText(excursao.toString());
					label_1.setText("Sua excursão foi criada.");
				}
				catch (NumberFormatException ex) {
					label_1.setText("O campo deve ser número");
			};
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(128, 128, 255));
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textArea.setText("Se sua excursão já foi criada, você pode consultar as  funcionalidades abaixo:");
		textArea.setBounds(51, 201, 333, 52);
		frame.getContentPane().add(textArea);
		
		button_1 = new JButton("Recuperar excursão");
		button_1.setBounds(51, 253, 155, 23);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("Criar reserva");
		button_2.setBounds(51, 287, 155, 23);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("Cancelar reserva (indiv.)");
		button_3.setBounds(228, 253, 156, 23);
		frame.getContentPane().add(button_3);
		
		button_4 = new JButton("Cancelar reserva (grupo)");
		button_4.setBounds(228, 287, 156, 23);
		frame.getContentPane().add(button_4);
		
		button_5 = new JButton("Listar reservas (cpf)");
		button_5.setBounds(51, 321, 155, 23);
		frame.getContentPane().add(button_5);
		
		button_6 = new JButton("Listar reservas (nome)");
		button_6.setBounds(51, 355, 155, 23);
		frame.getContentPane().add(button_6);
		
		button_7 = new JButton("Calcular valor total");
		button_7.setBounds(51, 389, 155, 23);
		frame.getContentPane().add(button_7);
		
		button_8 = new JButton("Salvar");
		button_8.setBounds(51, 423, 155, 23);
		frame.getContentPane().add(button_8);
		
		button_9 = new JButton("Carregar");
		button_9.setBounds(229, 321, 155, 23);
		frame.getContentPane().add(button_9);
		
		label_1 = new JLabel("");
		label_1.setBounds(51, 457, 333, 14);
		frame.getContentPane().add(label_1);
		
		button.setBounds(151, 167, 142, 23);
		frame.getContentPane().add(button);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(61, 53, 323, 90);
		frame.getContentPane().add(textArea_1);
	}
}