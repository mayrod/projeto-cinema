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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeCartaz;
import br.com.projeto.cinema.dao.FilmeCartazDAO;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.view.componentes.calendario.JDateChooser;

public class CadastroFilmeCartaz extends JInternalFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txCodigo;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblFilmePromocao;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private FilmeCartaz registro;	
	private JDateChooser dataTermino;
	private JDateChooser dataInicio; 
	private JComboBox<Filme> cbFilme;
	private List<Filme> filmes = new ArrayList<Filme>();
	
	public CadastroFilmeCartaz() 
	{
		setClosable(true);
		setTitle("Cadastro Filme Cartaz");
		setBounds(100, 100, 769, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataInicio.setBounds(10, 154, 114, 25);
		contentPane.add(lblDataInicio);
		
		JLabel label_1 = new JLabel("Filme:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 118, 46, 25);
		contentPane.add(label_1);
		
		cbFilme = new JComboBox<Filme>();
		cbFilme.setBounds(66, 118, 190, 25);
		contentPane.add(cbFilme);
		
		dataInicio = new JDateChooser();
		dataInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataInicio.setBounds(109, 154, 145, 25);
		contentPane.add(dataInicio);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 82, 55, 25);
		contentPane.add(lblCdigo);
		
		txCodigo = new JTextField();
		txCodigo.setEnabled(false);
		txCodigo.setEditable(false);
		txCodigo.setBounds(66, 84, 190, 25);
		contentPane.add(txCodigo);
		txCodigo.setColumns(10);
		
		JLabel lblDataTrmino = new JLabel("Data T\u00E9rmino:");
		lblDataTrmino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataTrmino.setBounds(10, 190, 114, 25);
		contentPane.add(lblDataTrmino);
		
		dataTermino = new JDateChooser();
		dataTermino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dataTermino.setBounds(109, 190, 145, 25);
		contentPane.add(dataTermino);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 11, 487, 281);
		contentPane.add(scrollPane);
		
		modelo.addColumn("Código");
		modelo.addColumn("Filme");
		modelo.addColumn("Dt. Inicio");
		modelo.addColumn("Dt. Término");

		tblFilmePromocao = new JTable(modelo);
		scrollPane.setViewportView(tblFilmePromocao);
		tblFilmePromocao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroFilmeCartaz.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(593, 303, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroFilmeCartaz.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(10, 303, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroFilmeCartaz.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(318, 303, 160, 41);
		contentPane.add(btRemover);
		btRemover.addActionListener(new escutaBotao());
		
		preencherCodigo();
		preencherTabela();
		preencherFilme();
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
		registro = new FilmeCartaz();
		
		txCodigo.setText("");
		cbFilme.setSelectedItem(null);
		dataInicio.setDate(null);
		dataTermino.setDate(null);
		preencherCodigo();
	}
	
	public void preencherTabela()
	{
		List<FilmeCartaz> list = new FilmeCartazDAO().obterTodos();
		
		if(list!=null)
		{
			for(FilmeCartaz obj : list)
			{
				modelo.addRow(new Object[]{obj.getPkFilmeCartaz(), obj.getFilme().getTitulo(), obj.getDataInicio().toString(), 
						obj.getDataTermino().toString()});
			}
		}
		
		limpar();
	}
	
	public void salvar()
	{
		if(cbFilme.getSelectedItem()!=null)
		{
			java.sql.Date dtInicio = new java.sql.Date(dataInicio.getDate().getTime());  
			java.sql.Date dtTermino = new java.sql.Date(dataTermino.getDate().getTime());  
			
			registro = new FilmeCartaz();		
			
			registro.setPkFilmeCartaz(Long.parseLong(txCodigo.getText()));
			registro.setDataInicio(dtInicio);
			registro.setDataTermino(dtTermino);
			registro.setFilme((Filme) cbFilme.getSelectedItem());
			
			try{
				registro = new FilmeCartazDAO().save(registro);
				registro = new FilmeCartazDAO().findById(Long.parseLong(txCodigo.getText()));
				
				if(registro!=null)
				{
					modelo.addRow(new Object[]{registro.getPkFilmeCartaz(), registro.getFilme().getTitulo(), registro.getDataInicio(), 
							registro.getDataTermino()});
					limpar();
				}			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null," Erro ao salvar os dados de Filme Promoção.","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Escolhe um filme por favor!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void remover()
	{
		if(tblFilmePromocao.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + ((FilmeCartaz) modelo.getValueAt(tblFilmePromocao.getSelectedRow(),0)).getFilme().getTitulo() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) { modelo.removeRow(tblFilmePromocao.getSelectedRow()); }
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	private void preencherCodigo(){
		long countId = new FilmeCartazDAO().count() + 1;
		txCodigo.setText(Long.toString(countId));
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
}
