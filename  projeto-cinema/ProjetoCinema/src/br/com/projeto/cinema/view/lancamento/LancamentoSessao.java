package br.com.projeto.cinema.view.lancamento;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class LancamentoSessao extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LancamentoSessao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Filme:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 57, 46, 25);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 57, 233, 25);
		contentPane.add(comboBox);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorrio.setBounds(10, 93, 56, 25);
		contentPane.add(lblHorrio);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 93, 233, 25);
		contentPane.add(comboBox_1);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSala.setBounds(10, 129, 56, 25);
		contentPane.add(lblSala);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(66, 129, 233, 25);
		contentPane.add(comboBox_2);
		
		JButton button = new JButton("  Remover");
		button.setIcon(new ImageIcon(LancamentoSessao.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(284, 228, 160, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("  Limpar");
		button_1.setIcon(new ImageIcon(LancamentoSessao.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(10, 228, 160, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("  Salvar");
		button_2.setIcon(new ImageIcon(LancamentoSessao.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBounds(566, 228, 160, 41);
		contentPane.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 11, 408, 193);
		contentPane.add(scrollPane);
	}

}
