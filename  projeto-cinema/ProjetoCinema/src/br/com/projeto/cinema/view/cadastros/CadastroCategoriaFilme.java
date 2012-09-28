package br.com.projeto.cinema.view.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class CadastroCategoriaFilme extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public CadastroCategoriaFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 45, 46, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(66, 45, 214, 25);
		contentPane.add(textField);
		
		JButton button = new JButton("  Limpar");
		button.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(10, 121, 160, 41);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 11, 310, 96);
		contentPane.add(scrollPane);
		
		JButton button_1 = new JButton("  Salvar");
		button_1.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(449, 121, 160, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("  Remover");
		button_2.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(227, 121, 160, 41);
		contentPane.add(button_2);
	}

}
