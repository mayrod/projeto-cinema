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

public class CadastroCategoriaFilme extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public CadastroCategoriaFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Limpar");
		button.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/apagar.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 341, 151, 40);
		contentPane.add(button);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(89, 11, 46, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(145, 11, 258, 25);
		contentPane.add(textField);
		
		JButton button_1 = new JButton("Salvar");
		button_1.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/salvar_36.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(333, 341, 151, 40);
		contentPane.add(button_1);
	}

}
