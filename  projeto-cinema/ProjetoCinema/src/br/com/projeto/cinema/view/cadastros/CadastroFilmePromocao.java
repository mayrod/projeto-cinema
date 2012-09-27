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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class CadastroFilmePromocao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public CadastroFilmePromocao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataInicio.setBounds(10, 93, 114, 25);
		contentPane.add(lblDataInicio);
		
		JLabel label_1 = new JLabel("Filme:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 57, 46, 25);
		contentPane.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 57, 190, 25);
		contentPane.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateChooser.setBounds(109, 93, 145, 25);
		contentPane.add(dateChooser);
		
		JButton button = new JButton("Limpar");
		button.setIcon(new ImageIcon(CadastroFilmePromocao.class.getResource("/br/com/projeto/cinema/imagens/apagar.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 388, 151, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Salvar");
		button_1.setIcon(new ImageIcon(CadastroFilmePromocao.class.getResource("/br/com/projeto/cinema/imagens/salvar_36.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(499, 377, 151, 30);
		contentPane.add(button_1);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 11, 55, 25);
		contentPane.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(66, 13, 190, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDataTrmino = new JLabel("Data T\u00E9rmino:");
		lblDataTrmino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataTrmino.setBounds(10, 129, 114, 25);
		contentPane.add(lblDataTrmino);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateChooser_1.setBounds(109, 129, 145, 25);
		contentPane.add(dateChooser_1);
		
		JLabel lblPorcentagemDePromoo = new JLabel("Porcentagem de Promo\u00E7\u00E3o:");
		lblPorcentagemDePromoo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentagemDePromoo.setBounds(10, 165, 181, 25);
		contentPane.add(lblPorcentagemDePromoo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(195, 167, 37, 25);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(237, 165, 19, 25);
		contentPane.add(label);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 201, 114, 25);
		contentPane.add(lblDescrio);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane.setBounds(10, 225, 246, 141);
		contentPane.add(textPane);
	}
}
