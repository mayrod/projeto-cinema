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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		lblTipo.setBounds(10, 110, 46, 25);
		contentPane.add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 110, 190, 25);
		contentPane.add(comboBox);
		
		JLabel label_2 = new JLabel("C\u00F3digo:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 74, 55, 25);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 76, 190, 25);
		contentPane.add(textField);
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCapacidade.setBounds(10, 146, 75, 25);
		contentPane.add(lblCapacidade);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 148, 161, 25);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 11, 355, 236);
		contentPane.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.GRAY);
		separator.setBounds(272, 26, 2, 196);
		contentPane.add(separator);
		
		JButton button_2 = new JButton("  Salvar");
		button_2.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(483, 257, 160, 41);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("  Limpar");
		button_3.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBounds(10, 257, 160, 41);
		contentPane.add(button_3);
		
		JButton button = new JButton("  Remover");
		button.setIcon(new ImageIcon(CadastroSala.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(244, 258, 160, 41);
		contentPane.add(button);
	}
}
