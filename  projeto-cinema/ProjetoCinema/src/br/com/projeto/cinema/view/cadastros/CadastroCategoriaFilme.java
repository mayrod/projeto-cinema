package br.com.projeto.cinema.view.cadastros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblCategoria;
	private FilmeCategoria registro;
	
	/**
	 * Create the frame.
	 */
	public CadastroCategoriaFilme() {
		setClosable(true);
		setTitle("Cadastro Categoria");
		setBounds(100, 100, 634, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 55, 46, 25);
		contentPane.add(label);
		
		txNome = new JTextField();
		txNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txNome.setColumns(10);
		txNome.setBounds(66, 55, 214, 25);
		contentPane.add(txNome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 11, 328, 110);
		contentPane.add(scrollPane);	
		
		tblCategoria = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Nome"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblCategoria);
		tblCategoria.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 132, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
				
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(458, 132, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroCategoriaFilme.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(241, 132, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
		
		tblCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { escutaTabela(arg0); }
		});
		
		modelo = (DefaultTableModel) tblCategoria.getModel();
		preencherTabela();
	}
	
	public void escutaTabela(MouseEvent e) 
	{
		if(tblCategoria.getSelectedRow()!=-1)
		{
			registro = (FilmeCategoria) modelo.getValueAt(tblCategoria.getSelectedRow(), 1);
			txNome.setText(registro.getNome());
		}
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
		
		if(modelo.getRowCount()>0)
		{
			tblCategoria.removeRowSelectionInterval(0, modelo.getRowCount() - 1);
		}
	}
	
	public void preencherTabela()
	{
		List<FilmeCategoria> list = new  FilmeCategoriaDAO().obterTodos();
		
		if(list!=null)
		{
			for(FilmeCategoria obj : list)
			{
				modelo.addRow(new Object[]{obj.getPkFilmeCategoria(),obj});
			}
		}
		
		limpar();
	}
	
	public void salvar()
	{
		if(txNome.getText().length()>0)
		{
			registro.setNome(txNome.getText());
			
			if(tblCategoria.getSelectedRow()==-1) 	{ registro = new FilmeCategoriaDAO().save(registro); }
			else 													
			{ 
				registro = new FilmeCategoriaDAO().update(registro); 
				modelo.removeRow(tblCategoria.getSelectedRow()); 
			}
			
			modelo.addRow(new Object[]{registro.getPkFilmeCategoria(), registro});
			limpar();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Digite um nome por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		
		if(tblCategoria.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + modelo.getValueAt(tblCategoria.getSelectedRow(),1).toString() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor == 0) 
			{ 
				new FilmeCategoriaDAO().delete((FilmeCategoria) modelo.getValueAt(tblCategoria.getSelectedRow(), 1));
				modelo.removeRow(tblCategoria.getSelectedRow()); 
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}

}
