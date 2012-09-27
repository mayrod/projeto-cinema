package br.com.projeto.cinema.view.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import br.com.projeto.cinema.view.componentes.calendario.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CadastroSala extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public CadastroSala() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 111, 46, 25);
		contentPane.add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 111, 190, 25);
		contentPane.add(comboBox);
		
		JButton button = new JButton("Limpar");
		button.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/apagar.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 258, 151, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Salvar");
		button_1.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/salvar_36.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(492, 258, 151, 40);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("C\u00F3digo:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 65, 55, 25);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 67, 190, 25);
		contentPane.add(textField);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCapacidade.setBounds(10, 147, 75, 25);
		contentPane.add(lblCapacidade);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 149, 161, 25);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 11, 355, 236);
		contentPane.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.GRAY);
		separator.setBounds(272, 26, 2, 196);
		contentPane.add(separator);
	}
}
