package br.com.projeto.cinema.view.cadastros;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmePromocao;
import br.com.projeto.cinema.dao.FilmePromocaoDAO;
import br.com.projeto.cinema.view.componentes.calendario.JDateChooser;

public class CadastroFilmePromocao extends JInternalFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txCodigo;
	private JTextField txPorcentagemPromocao;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblContato;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private FilmePromocao registro;	
	private JEditorPane txDescricao;
	private JDateChooser dataTermino;
	private JDateChooser dataInicio; 
	private JComboBox<Filme> cbFilme;
	
	public CadastroFilmePromocao() 
	{
		setClosable(true);
		setTitle("Cadastro Filme Promo\u00E7\u00E3o");
		setBounds(100, 100, 717, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataInicio.setBounds(10, 83, 114, 25);
		contentPane.add(lblDataInicio);
		
		JLabel label_1 = new JLabel("Filme:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 47, 46, 25);
		contentPane.add(label_1);
		
		cbFilme = new JComboBox<Filme>();
		cbFilme.setBounds(66, 47, 190, 25);
		contentPane.add(cbFilme);
		
		dataInicio = new JDateChooser();
		dataInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataInicio.setBounds(109, 83, 145, 25);
		contentPane.add(dataInicio);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 11, 55, 25);
		contentPane.add(lblCdigo);
		
		txCodigo = new JTextField();
		txCodigo.setBounds(66, 13, 190, 25);
		contentPane.add(txCodigo);
		txCodigo.setColumns(10);
		
		JLabel lblDataTrmino = new JLabel("Data T\u00E9rmino:");
		lblDataTrmino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataTrmino.setBounds(10, 119, 114, 25);
		contentPane.add(lblDataTrmino);
		
		dataTermino = new JDateChooser();
		dataTermino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataTermino.setBounds(109, 119, 145, 25);
		contentPane.add(dataTermino);
		
		JLabel lblPorcentagemDePromoo = new JLabel("Porcentagem de Promo\u00E7\u00E3o:");
		lblPorcentagemDePromoo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentagemDePromoo.setBounds(10, 155, 181, 25);
		contentPane.add(lblPorcentagemDePromoo);
		
		txPorcentagemPromocao = new JTextField();
		txPorcentagemPromocao.setColumns(10);
		txPorcentagemPromocao.setBounds(195, 157, 37, 25);
		contentPane.add(txPorcentagemPromocao);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(237, 155, 19, 25);
		contentPane.add(label);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 191, 114, 25);
		contentPane.add(lblDescrio);
		
		txDescricao = new JEditorPane();
		txDescricao.setBackground(Color.WHITE);
		txDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txDescricao.setBounds(10, 215, 246, 118);
		contentPane.add(txDescricao);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(272, 11, 419, 322);
		contentPane.add(scrollPane);
		
		modelo.addColumn("Código");
		modelo.addColumn("Filme");
		modelo.addColumn("Dt. Inicio");
		modelo.addColumn("Dt. Término");
		modelo.addColumn("% Promoção");

		tblContato = new JTable(modelo);
		scrollPane.setViewportView(tblContato);
		tblContato.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroFilmePromocao.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(531, 368, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroFilmePromocao.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 368, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroFilmePromocao.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(272, 368, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
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
		registro = new FilmePromocao();
		
		txCodigo.setText("");
		txDescricao.setText("");
		txPorcentagemPromocao.setText("");
		cbFilme.setSelectedItem(null);
		dataInicio.setDate(null);
		dataTermino.setDate(null);
	}
	
	public void preencherTabela()
	{
		List<FilmePromocao> list = new FilmePromocaoDAO().obterTodos();
		
		if(list!=null)
		{
			for(FilmePromocao obj : list)
			{
				modelo.addRow(new Object[]{obj, obj.getFilme().getTitulo(), obj.getDataInicio().toString(), 
						obj.getDataTermino().toString(), obj.getPorcentagemPromocao().toString()});
			}
		}
		
		limpar();
	}
	
	public void salvar()
	{
		if(cbFilme.getSelectedItem()!=null)
		{
			registro = new FilmePromocao();		
			
			registro.setCodigo(txCodigo.getText());
			registro.setDescricao(txDescricao.getText());
			registro.setPorcentagemPromocao(new Double(txCodigo.getText()));
			registro.setDataInicio((Date) dataInicio.getDate());
			registro.setDataTermino((Date) dataTermino.getDate());
			registro.setFilme((Filme) cbFilme.getSelectedItem());
			
			registro = new FilmePromocaoDAO().save(registro);
			
			if(registro!=null)
			{
				modelo.addColumn("Código");
				modelo.addColumn("Filme");
				modelo.addColumn("Dt. Inicio");
				modelo.addColumn("Dt. Término");
				modelo.addColumn("% Promoção");
				
				modelo.addRow(new Object[]{registro, registro.getFilme().getTitulo(), registro.getDataInicio().toString(), 
						registro.getDataTermino().toString(), registro.getPorcentagemPromocao().toString()});
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Escolhe um filme por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblContato.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + ((FilmePromocao) modelo.getValueAt(tblContato.getSelectedRow(),0)).getFilme().getTitulo() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) { modelo.removeRow(tblContato.getSelectedRow()); }
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
