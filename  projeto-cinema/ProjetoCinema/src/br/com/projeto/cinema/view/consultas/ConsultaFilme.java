package br.com.projeto.cinema.view.consultas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.FilmeCategoriaDAO;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.view.FrameSistema;
import br.com.projeto.cinema.view.cadastros.CadastroFilme;

public class ConsultaFilme extends JInternalFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txNome;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblFilme;
	private JButton btPesquisar;
	private JButton btLimpar;
	private JTextField txtCodigo;
	private JLabel lblAno;
	private JTextField txAno;
	private JComboBox<String> cbClassificacao;
	private JComboBox<FilmeCategoria> cbCategoria;
	private JLabel lblClassificao;
	private FrameSistema frame;
	
	public ConsultaFilme(FrameSistema frame) 
	{
		this.frame = frame;
		
		setClosable(true);
		setTitle("Consultar Filme");
		setBounds(100, 100, 749, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txNome = new JTextField();
		txNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txNome.setBounds(250, 21, 336, 25);
		contentPane.add(txNome);
		txNome.setColumns(10);
		
		JLabel lblNome = new JLabel("T\u00EDtulo:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(204, 21, 46, 25);
		contentPane.add(lblNome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 723, 333);
		contentPane.add(scrollPane);
		
		tblFilme = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Título", "Categoria", "Classificação", "Ano"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblFilme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { escutaTabela(arg0); }
		});
		scrollPane.setViewportView(tblFilme);
		tblFilme.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btPesquisar = new JButton("   Pesquisar");
		btPesquisar.setIcon(new ImageIcon(ConsultaFilme.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btPesquisar.setBounds(596, 11, 137, 33);
		contentPane.add(btPesquisar);
		btPesquisar.addActionListener(new escutaBotao());
		
		btLimpar = new JButton("   Limpar");
		btLimpar.setIcon(new ImageIcon(ConsultaFilme.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(596, 55, 137, 33);
		contentPane.add(btLimpar);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 21, 57, 25);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(66, 21, 118, 25);
		contentPane.add(txtCodigo);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoria.setBounds(10, 57, 74, 25);
		contentPane.add(lblCategoria);
		cbCategoria = new JComboBox<FilmeCategoria>();
		cbCategoria.setBounds(76, 60, 145, 22);
		contentPane.add(cbCategoria);
		
		lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(473, 57, 57, 25);
		contentPane.add(lblAno);
		
		txAno = new JTextField();
		txAno.setText("");
		txAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txAno.setColumns(10);
		txAno.setBounds(507, 57, 79, 25);
		contentPane.add(txAno);
		
		cbClassificacao = new JComboBox<String>();
		cbClassificacao.setBounds(318, 60, 145, 22);
		contentPane.add(cbClassificacao);
		
		lblClassificao = new JLabel("Classifica\u00E7\u00E3o:");
		lblClassificao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClassificao.setBounds(231, 57, 79, 25);
		contentPane.add(lblClassificao);
		btLimpar.addActionListener(new escutaBotao());
		
		modelo = (DefaultTableModel) tblFilme.getModel();
		
		
		preencherCombos();
	}
		
	public void preencherCombos()
	{
		cbClassificacao.addItem("Livre"); 
		cbClassificacao.addItem("Especialmente Recomendado"); 
		cbClassificacao.addItem("Maiores de 10 anos"); 
		cbClassificacao.addItem("Maiores de 12 anos"); 
		cbClassificacao.addItem("Maiores de 14 anos"); 
		cbClassificacao.addItem("Maiores de 16 anos"); 
		cbClassificacao.addItem("Maiores de 18 anos"); 
		
		List<FilmeCategoria> listCategoria = new FilmeCategoriaDAO().obterTodos();
		
		if(listCategoria!=null)
		{
			for(FilmeCategoria cat : listCategoria)
			{
				cbCategoria.addItem(cat);
			}
		}
		
		limpar();
	}
	
	public void escutaTabela(MouseEvent e) 
	{
		if(tblFilme.getSelectedRow()!=-1 && e.getClickCount()>1)
		{
			CadastroFilme cadas = new CadastroFilme();
			frame.getInstancia().AbrirTela(cadas);
			cadas.preencherFilme((Filme) modelo.getValueAt(tblFilme.getSelectedRow(), 1));
		}
	}	
	
	private class escutaBotao implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{		
			if(e.getSource()==btPesquisar) 		{ pesquisar(); 	}	
			else if(e.getSource()==btLimpar)	{ limpar();		}
		}
	}
	
	public void limpar()
	{
		txNome.setText("");
		txAno.setText("");
		txtCodigo.setText("");
		cbClassificacao.setSelectedItem(null);
		cbCategoria.setSelectedItem(null);
		
		for(int i = modelo.getRowCount() -1; i>=0; i--) { modelo.removeRow(i); }
	}
	
	public void pesquisar()
	{			
		Long categoria = null;
	
		if(cbCategoria.getSelectedItem()!=null) { ((FilmeCategoria) cbCategoria.getSelectedItem()).getPkFilmeCategoria(); }
		
		List<Filme> list = new FilmeDAO().obterFilmes(txtCodigo.getText(), txNome.getText(), categoria, ((String) cbClassificacao.getSelectedItem()), txAno.getText());
		
		limpar();
		
		if(list!=null)
		{
			for(Filme obj : list)
			{
				modelo.addRow(new Object[]{obj.getCodigo(), obj, obj.getCategoria().getNome(), obj.getClassificacaoIndicativa(), obj.getAno()});
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Nenhum Filme foi encontrado!","Erro ao pesquisar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
