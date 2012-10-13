package br.com.projeto.cinema.view.cadastros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeLancamento;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.dao.FilmeLancamentoDAO;
import br.com.projeto.cinema.view.componentes.calendario.JDateChooser;

public class CadastroFilmeLancamento extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser data = new JDateChooser();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblFilmeLancamento;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private FilmeLancamento registro;	
	private JComboBox<Filme> cbFilme;
	private List<Filme> filmes = new ArrayList<Filme>();
	private List<FilmeLancamento> filmesLancamento = new ArrayList<FilmeLancamento>();
	
	/**
	 * Create the frame.
	 */
	public CadastroFilmeLancamento() 
	{
		setClosable(true);
		setTitle("Cadastro Filme Lan\u00E7amento");
		setBounds(100, 100, 707, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilme = new JLabel("Filme:");
		lblFilme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFilme.setBounds(10, 27, 46, 25);
		contentPane.add(lblFilme);
		
		JLabel lblData = new JLabel("Data Lan\u00E7amento:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 63, 114, 25);
		contentPane.add(lblData);
		
		cbFilme = new JComboBox<Filme>();
		cbFilme.setBounds(66, 27, 213, 25);
		contentPane.add(cbFilme);
		
		data.setFont(new Font("Tahoma", Font.PLAIN, 14));
		data.setBounds(134, 63, 145, 25);
		contentPane.add(data);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 11, 369, 159);
		contentPane.add(scrollPane);
		
		modelo.addColumn("Código");
		modelo.addColumn("Filme");
		modelo.addColumn("Data Lançamento");

		tblFilmeLancamento = new JTable(modelo);
		scrollPane.setViewportView(tblFilmeLancamento);
		tblFilmeLancamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 181, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(515, 181, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroFilmeLancamento.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(258, 181, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
		
		preencherFilme();
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
	
	private void preencherTabela(){
		try {
			filmesLancamento = new FilmeLancamentoDAO().getAll();
			
			if(filmesLancamento!=null)
			{
				for(FilmeLancamento obj : filmesLancamento)
				{
					modelo.addRow(new Object[]{obj.getPkFilmeLancamento(),obj.getFilme(),obj.getDataEstreia()});
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void preencherFilme(){
		try {
			filmes = new FilmeDAO().getAll();
			
			for(Filme filme : filmes){
				cbFilme.addItem(filme);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void limpar()
	{
		registro = new FilmeLancamento();
		cbFilme.setSelectedItem(null);
		data.setDate(null);
	}
	
	public void salvar()
	{
		if(cbFilme.getSelectedItem()!=null)
		{
			long countId = new FilmeLancamentoDAO().count() + 1;
			
			registro = new FilmeLancamento();		
			registro.setPkFilmeLancamento(countId);
			registro.setFilme((Filme) cbFilme.getSelectedItem());
			java.sql.Date dataEstreia = new java.sql.Date(data.getDate().getTime());  

			registro.setDataEstreia(dataEstreia);
			
			try{
				new FilmeLancamentoDAO().save(registro);
				registro = new FilmeLancamentoDAO().findById(countId);
				modelo.addRow(new Object[]{registro.getPkFilmeLancamento(), registro.getFilme().getTitulo(),registro.getDataEstreia()});
				limpar();
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null," Erro ao salvar os dados de Filme Lançamento.","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione um filme por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblFilmeLancamento.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + ((Filme) modelo.getValueAt(tblFilmeLancamento.getSelectedRow(),0)).getTitulo() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) { modelo.removeRow(tblFilmeLancamento.getSelectedRow()); }
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
