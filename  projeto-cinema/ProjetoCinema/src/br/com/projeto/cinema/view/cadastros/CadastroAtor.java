package br.com.projeto.cinema.view.cadastros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.BoxLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

import br.com.projeto.cinema.bean.Ator;
import br.com.projeto.cinema.dao.AtorDAO;

public class CadastroAtor extends JFrame 
{
	private JPanel contentPane;
	private JTextField txNome;
	private JTable table;
	private JButton btSalvar;

	/**
	 * Create the frame.
	 */
	public CadastroAtor() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txNome = new JTextField();
		txNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txNome.setBounds(66, 45, 214, 25);
		contentPane.add(txNome);
		txNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 45, 46, 25);
		contentPane.add(lblNome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 11, 310, 96);
		contentPane.add(scrollPane);
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroAtor.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btSalvar.setBounds(449, 121, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		JButton button_1 = new JButton("  Limpar");
		button_1.setIcon(new ImageIcon(CadastroAtor.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(10, 121, 160, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("  Remover");
		button_2.setIcon(new ImageIcon(CadastroAtor.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBounds(227, 121, 160, 41);
		contentPane.add(button_2);
	}
		
	private class escutaBotao implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{		
			if(e.getSource()==btSalvar) { salvar(); }			
		}
	}
	
	public void salvar()
	{
		if(txNome.getText().length()>0)
		{
			Ator ator = new Ator();		
			ator.setNome(txNome.getText());
			
			new AtorDAO().salvar(ator);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Digite um nome por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
