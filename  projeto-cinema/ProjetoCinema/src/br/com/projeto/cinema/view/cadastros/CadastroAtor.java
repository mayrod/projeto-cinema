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

import br.com.projeto.cinema.bean.Ator;
import br.com.projeto.cinema.dao.AtorDAO;

public class CadastroAtor extends JInternalFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txNome;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblAtor;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private Ator registro;	
	
	public CadastroAtor() 
	{
		setClosable(true);
		setTitle("Cadastro Ator");
		setBounds(100, 100, 675, 211);
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
		scrollPane.setBounds(290, 11, 369, 111);
		contentPane.add(scrollPane);
		
		tblAtor = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C�digo", "Nome"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblAtor);
		tblAtor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblAtor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { escutaTabela(arg0); }
		});
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroAtor.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(499, 133, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroAtor.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 133, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroAtor.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(255, 133, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
		
		modelo = (DefaultTableModel) tblAtor.getModel();
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
	
	public void escutaTabela(MouseEvent e) 
	{
		if(tblAtor.getSelectedRow()!=-1)
		{
			registro = (Ator) modelo.getValueAt(tblAtor.getSelectedRow(), 1);
			
			txNome.setText(registro.getNome());
		}
	}
	
	public void limpar()
	{
		registro = new Ator();
		txNome.setText("");				
		
		if(modelo.getRowCount()>0)
		{
			tblAtor.removeRowSelectionInterval(0, modelo.getRowCount() - 1);
		}
	}
	
	public void preencherTabela()
	{
		List<Ator> list = new AtorDAO().obterTodos();
		
		if(list!=null)
		{
			for(Ator obj : list)
			{
				modelo.addRow(new Object[]{obj.getPkAtor(), obj});
			}
		}
		
		limpar();
	}
	
	public void salvar()
	{
		if(txNome.getText().length()>0)
		{		
			registro.setNome(txNome.getText());
			
			if(tblAtor.getSelectedRow()==-1) 	{ registro = new AtorDAO().salvar(registro); }
			else 													
			{ 
				registro = new AtorDAO().update(registro); 
				modelo.removeRow(tblAtor.getSelectedRow()); 
			}
			
			modelo.addRow(new Object[]{registro.getPkAtor(),registro});
			limpar();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Digite um nome por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblAtor.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + modelo.getValueAt(tblAtor.getSelectedRow(),0).toString() 
					+ "?", "Confirma��o", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) 
			{ 
				new AtorDAO().delete((Ator) modelo.getValueAt(tblAtor.getSelectedRow(),1));
				modelo.removeRow(tblAtor.getSelectedRow()); 
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
