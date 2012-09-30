package br.com.projeto.cinema.view.cadastros;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastroPreco extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public CadastroPreco() {
		setTitle("Cadastro Pre\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 11, 295, 143);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("  Salvar");
		button.setIcon(new ImageIcon(CadastroPreco.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(350, 173, 160, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("  Limpar");
		button_1.setIcon(new ImageIcon(CadastroPreco.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(10, 173, 160, 41);
		contentPane.add(button_1);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:  R$");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreo.setBounds(10, 71, 89, 25);
		contentPane.add(lblPreo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(82, 73, 105, 25);
		contentPane.add(textField);
	}

}
