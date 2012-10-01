package br.com.projeto.cinema.view.cadastros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.cinema.bean.FilmeHorario;
import br.com.projeto.cinema.bean.Horario;
import br.com.projeto.cinema.dao.HorarioExibicaoDAO;

public class CadastroHorarioPreco extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblContato;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private FilmeHorario registro;
	private JComboBox cbDiaSemana;
	private JFormattedTextField txHorario;
	private JFormattedTextField txPreco;
	
	/**
	 * Create the frame.
	 */
	public CadastroHorarioPreco() {
		setTitle("Cadastro Hor\u00E1rio Pre\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:         R$");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreo.setBounds(10, 170, 101, 25);
		contentPane.add(lblPreo);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorrio.setBounds(10, 134, 55, 25);
		contentPane.add(lblHorrio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 11, 280, 278);
		contentPane.add(scrollPane);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da Semana:");
		lblDiaDaSemana.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaDaSemana.setBounds(10, 98, 101, 25);
		contentPane.add(lblDiaDaSemana);
		
		cbDiaSemana = new JComboBox();
		cbDiaSemana.setBounds(109, 98, 190, 25);
		contentPane.add(cbDiaSemana);
		
		txHorario = new JFormattedTextField();
		txHorario.setToolTipText("hh:mm");
		txHorario.setBounds(109, 134, 125, 25);
		contentPane.add(txHorario);
		
		txPreco = new JFormattedTextField();
		txPreco.setBounds(109, 172, 125, 25);
		contentPane.add(txPreco);
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 306, 160, 41);
		contentPane.add(btLimpar);
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(438, 306, 160, 41);
		contentPane.add(btSalvar);
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroHorarioPreco.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(224, 306, 160, 41);
		contentPane.add(btRemover);
	}
	
	private class escutaBotao implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{		
			if(e.getSource()==btSalvar) 		{ salvar(); }	
			else if(e.getSource()==btRemover) 	{ remover();}	
			else if(e.getSource()==btLimpar)	{ limpar();	}
			
		}
	}
	
	public void limpar()
	{
		registro = new FilmeHorario();
		
		txHorario.setText("");
		txPreco.setText("");
		cbDiaSemana.setSelectedItem(null);
	}
	
	public void salvar()
	{
		if(cbDiaSemana.getSelectedItem()!=null)
		{		
			Horario he = new Horario();
			he.setDiaSemana((java.sql.Date) new Date());
			
//			Preco preco = new Preco();
//			registroPreco.setPreco(new Double(txPreco.getText()));
			
			modelo.addRow(new Object[]{registro});
			limpar();
			
//			registro = new AtorDAO().salvar(registro);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione um dia por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblContato.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + modelo.getValueAt(tblContato.getSelectedRow(),0).toString() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) { modelo.removeRow(tblContato.getSelectedRow()); }
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
