package br.com.projeto.cinema.view.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import br.com.projeto.cinema.view.componentes.calendario.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFilme extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public CadastroFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label.setBounds(624, 11, 154, 172);
		contentPane.add(label);
		
		JButton button = new JButton("Carregar Imagem");
		button.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Picture.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(615, 188, 175, 44);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("C\u00F3digo:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 9, 55, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(82, 11, 105, 25);
		contentPane.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(406, 118, 159, 25);
		contentPane.add(comboBox);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTtulo.setBounds(214, 11, 55, 25);
		contentPane.add(lblTtulo);
		
		JLabel lblTipoAudio = new JLabel("Audio:");
		lblTipoAudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoAudio.setBounds(10, 118, 46, 25);
		contentPane.add(lblTipoAudio);
		
		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o Inicativa:");
		lblClassificao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClassificao.setBounds(263, 118, 133, 25);
		contentPane.add(lblClassificao);
		
		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiretor.setBounds(214, 45, 55, 25);
		contentPane.add(lblDiretor);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o:");
		lblDurao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDurao.setBounds(10, 45, 57, 25);
		contentPane.add(lblDurao);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade:");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNacionalidade.setBounds(264, 154, 87, 25);
		contentPane.add(lblNacionalidade);
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinopse.setBounds(10, 225, 55, 25);
		contentPane.add(lblSinopse);
		
		JLabel lblTreiler = new JLabel("Treiler:");
		lblTreiler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTreiler.setBounds(10, 190, 55, 25);
		contentPane.add(lblTreiler);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(263, 11, 302, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(82, 190, 483, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(82, 47, 71, 25);
		contentPane.add(textField_3);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMin.setBounds(163, 47, 24, 25);
		contentPane.add(lblMin);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(361, 154, 204, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(82, 120, 168, 25);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(82, 156, 168, 25);
		contentPane.add(comboBox_3);
		
		JLabel lblLegenda = new JLabel("Legenda:");
		lblLegenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLegenda.setBounds(10, 154, 57, 25);
		contentPane.add(lblLegenda);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(263, 47, 302, 25);
		contentPane.add(textField_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 309, 555, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 11, 310, 96);
		panel.add(scrollPane);
		
		JLabel lblAtor = new JLabel("Ator:");
		lblAtor.setBounds(10, 11, 57, 25);
		panel.add(lblAtor);
		lblAtor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 47, 57, 25);
		panel.add(lblTipo);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(50, 11, 175, 25);
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(50, 47, 175, 25);
		panel.add(comboBox_5);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Create.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(88, 83, 35, 33);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Remove.png")));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBounds(133, 83, 35, 33);
		panel.add(button_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.WHITE);
		editorPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		editorPane.setBounds(82, 225, 483, 73);
		contentPane.add(editorPane);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.GRAY);
		separator.setBounds(589, 11, 2, 416);
		contentPane.add(separator);
		
		JButton button_3 = new JButton("  Salvar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBounds(624, 284, 160, 41);
		contentPane.add(button_3);
		
		JButton btnLimpar = new JButton("  Limpar");
		btnLimpar.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimpar.setBounds(624, 340, 160, 41);
		contentPane.add(btnLimpar);
		
		JLabel lblProdutora = new JLabel("Produtora:");
		lblProdutora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutora.setBounds(10, 81, 67, 25);
		contentPane.add(lblProdutora);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(82, 83, 168, 25);
		contentPane.add(comboBox_6);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoria.setBounds(263, 81, 70, 25);
		contentPane.add(lblCategoria);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(343, 81, 222, 25);
		contentPane.add(comboBox_7);
	}
}
