package br.com.projeto.cinema.view.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import br.com.projeto.cinema.view.componentes.calendario.JDateChooser;
import javax.swing.ImageIcon;

public class CadastroFilmeLancamento extends JFrame {

	private JPanel contentPane;
	private final JDateChooser calendarDataDeNasc = new JDateChooser();

	/**
	 * Create the frame.
	 */
	public CadastroFilmeLancamento() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Limpar");
		button.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/apagar.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 366, 151, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Salvar");
		button_1.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/salvar_36.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(333, 366, 151, 40);
		contentPane.add(button_1);
		
		JLabel lblFilme = new JLabel("Filme:");
		lblFilme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFilme.setBounds(10, 136, 46, 25);
		contentPane.add(lblFilme);
		
		JLabel lblData = new JLabel("Data Lan\u00E7amento:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 172, 114, 25);
		contentPane.add(lblData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 136, 213, 25);
		contentPane.add(comboBox);
		
		calendarDataDeNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calendarDataDeNasc.setBounds(134, 172, 145, 25);
		contentPane.add(calendarDataDeNasc);
	}
}
