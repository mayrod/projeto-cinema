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
import javax.swing.JScrollPane;

public class CadastroFilmeLancamento extends JFrame {

	private JPanel contentPane;
	private final JDateChooser calendarDataDeNasc = new JDateChooser();

	/**
	 * Create the frame.
	 */
	public CadastroFilmeLancamento() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilme = new JLabel("Filme:");
		lblFilme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFilme.setBounds(10, 27, 46, 25);
		contentPane.add(lblFilme);
		
		JLabel lblData = new JLabel("Data Lan\u00E7amento:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 63, 114, 25);
		contentPane.add(lblData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 27, 213, 25);
		contentPane.add(comboBox);
		
		calendarDataDeNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calendarDataDeNasc.setBounds(134, 63, 145, 25);
		contentPane.add(calendarDataDeNasc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 11, 369, 96);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("  Limpar");
		button.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(10, 121, 160, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("  Salvar");
		button_1.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(515, 121, 160, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("  Remover");
		button_2.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBounds(258, 121, 160, 41);
		contentPane.add(button_2);
	}
}
