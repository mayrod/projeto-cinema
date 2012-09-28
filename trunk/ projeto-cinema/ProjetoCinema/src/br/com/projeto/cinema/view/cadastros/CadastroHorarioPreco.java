package br.com.projeto.cinema.view.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.projeto.cinema.view.componentes.calendario.JDateChooser;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroHorarioPreco extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CadastroHorarioPreco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreo.setBounds(10, 170, 55, 25);
		contentPane.add(lblPreo);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorrio.setBounds(10, 134, 55, 25);
		contentPane.add(lblHorrio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 11, 280, 278);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("  Limpar");
		button.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(10, 306, 160, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("  Salvar");
		button_1.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(438, 306, 160, 41);
		contentPane.add(button_1);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da Semana:");
		lblDiaDaSemana.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaDaSemana.setBounds(10, 98, 101, 25);
		contentPane.add(lblDiaDaSemana);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 98, 190, 25);
		contentPane.add(comboBox);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setToolTipText("hh:mm");
		formattedTextField.setBounds(109, 134, 125, 25);
		contentPane.add(formattedTextField);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(109, 170, 125, 25);
		contentPane.add(comboBox_1);
		
		JButton btnNovo = new JButton("  Remover");
		btnNovo.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNovo.setBounds(224, 306, 160, 41);
		contentPane.add(btnNovo);
	}
}
