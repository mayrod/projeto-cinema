package br.com.projeto.cinema.view.cadastros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.FilmeCategoriaDAO;

public class CadastroCategoriaFilme extends JInternalFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txNome;
	private JButton btLimpar;
	private JButton btSalvar;
	private JButton btRemover; 
	private final DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblContato;
	private FilmeCategoria registro;
	
	/**
	 * Create the frame.
	 */
	public CadastroCategoriaFilme() {
		setClosable(true);
		setTitle("Cadastro Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 45, 46, 25);
		contentPane.add(label);
		
		txNome = new JTextField();
		txNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txNome.setColumns(10);
		txNome.setBounds(66, 45, 214, 25);
		contentPane.add(txNome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 11, 310, 96);
		contentPane.add(scrollPane);		
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		
		tblContato = new JTable(modelo);
		scrollPane.setViewportView(tblContato);
		tblContato.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 121, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
				
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(449, 121, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(227, 121, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
		
		preencherTabela();
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
		registro = new FilmeCategoria();
		txNome.setText("");
	}
	
	public void preencherTabela()
	{
		List<FilmeCategoria> list = new  FilmeCategoriaDAO().obterTodos();
		
		if(list!=null)
		{
			for(FilmeCategoria obj : list)
			{
				modelo.addRow(new Object[]{obj.getPkFilmeCategoria(),obj.getNome()});
			}
		}
		
		limpar();
	}
	
	public void salvar()
	{
		if(txNome.getText().length()>0)
		{
			FilmeCategoria filmeCategoria = new FilmeCategoria();		
			filmeCategoria.setNome(txNome.getText());
			
			try{
				registro = new FilmeCategoriaDAO().save(filmeCategoria);
				
				if(registro!=null)
				{
					registro = new FilmeCategoriaDAO().findByName(filmeCategoria.getNome());
					modelo.addRow(new Object[]{registro.getPkFilmeCategoria(), registro.getNome()});
					limpar();
				}
			}catch (Exception e) {
				e.getStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Digite um nome por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		
		if(tblContato.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + modelo.getValueAt(tblContato.getSelectedRow(),1).toString() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor == 0) 
			{ 
				int pkFilmeCategoria = Integer.parseInt(modelo.getValueAt(tblContato.getSelectedRow(),0).toString());
				FilmeCategoria filmeCategoriaSelecionado = new FilmeCategoriaDAO().findById(pkFilmeCategoria);
				new FilmeCategoriaDAO().delete(filmeCategoriaSelecionado);
				modelo.removeRow(tblContato.getSelectedRow()); 
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}

}
