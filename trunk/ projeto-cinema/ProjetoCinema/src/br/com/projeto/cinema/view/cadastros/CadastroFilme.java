package br.com.projeto.cinema.view.cadastros;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.cinema.bean.Ator;
import br.com.projeto.cinema.bean.Elenco;
import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.bean.FilmeCategoria;
import br.com.projeto.cinema.dao.AtorDAO;
import br.com.projeto.cinema.dao.ElencoDAO;
import br.com.projeto.cinema.dao.FilmeCategoriaDAO;
import br.com.projeto.cinema.dao.FilmeDAO;
import br.com.projeto.cinema.utils.Constantes;

public class CadastroFilme extends JInternalFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txCodigo;
	private JTextField txNome;
	private JTextField txTreiler;
	private JTextField txDuracao;
	private JTextField txDiretor;
	private JComboBox<String> cbProdutora;
	private JComboBox<FilmeCategoria> cbCategoria;
	private JButton btRemoverTabela; 
	private JButton btAdicionar;
	private JComboBox<String> cbTipoAtor;
	private JComboBox<Ator> cbAtor;
	private JComboBox<String> cbLegenda;
	private JComboBox<String> cbAudio;
	private JComboBox<String> cbNacionalidade;
	private final DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblContato;
	private JButton btSalvar;
	private JButton btRemover;
	private JButton btLimpar;
	private Filme registro;	
	private JTextField txAno;
	private JComboBox<String> cbClassificacaoIndicativa;
	private String pathImagem;
	private JEditorPane txSinopse;
	private List<Elenco> registroElenco;
	
	public CadastroFilme() 
	{
		setClosable(true);
		setTitle("Cadastro Filme");
		setBounds(100, 100, 814, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label.setBounds(624, 11, 154, 172);
		contentPane.add(label);
		
		JButton btCarregarImagem = new JButton("Carregar Imagem");
		btCarregarImagem.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Picture.png")));
		btCarregarImagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btCarregarImagem.setBounds(615, 188, 175, 44);
		contentPane.add(btCarregarImagem);
		
		JLabel label_1 = new JLabel("C\u00F3digo:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 9, 55, 25);
		contentPane.add(label_1);
		
		txCodigo = new JTextField();
		txCodigo.setColumns(10);
		txCodigo.setBounds(82, 11, 80, 25);
		contentPane.add(txCodigo);
		
		cbClassificacaoIndicativa = new JComboBox<String>();
		cbClassificacaoIndicativa.setBounds(406, 118, 159, 25);
		contentPane.add(cbClassificacaoIndicativa);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTtulo.setBounds(172, 9, 55, 25);
		contentPane.add(lblTtulo);
		
		JLabel lblTipoAudio = new JLabel("\u00C1udio:");
		lblTipoAudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoAudio.setBounds(10, 118, 46, 25);
		contentPane.add(lblTipoAudio);
		
		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o Inicativa:");
		lblClassificao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClassificao.setBounds(263, 118, 133, 25);
		contentPane.add(lblClassificao);
		
		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiretor.setBounds(279, 45, 55, 25);
		contentPane.add(lblDiretor);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o:");
		lblDurao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDurao.setBounds(10, 45, 57, 25);
		contentPane.add(lblDurao);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade:");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNacionalidade.setBounds(264, 154, 87, 25);
		contentPane.add(lblNacionalidade);
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinopse.setBounds(10, 225, 55, 25);
		contentPane.add(lblSinopse);
		
		JLabel lblTrailer = new JLabel("Trailer");
		lblTrailer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrailer.setBounds(10, 190, 55, 25);
		contentPane.add(lblTrailer);
		
		txNome = new JTextField();
		txNome.setColumns(10);
		txNome.setBounds(214, 11, 351, 25);
		contentPane.add(txNome);
		
		txTreiler = new JTextField();
		txTreiler.setColumns(10);
		txTreiler.setBounds(82, 190, 483, 25);
		contentPane.add(txTreiler);
		
		txDuracao = new JTextField();
		txDuracao.setColumns(10);
		txDuracao.setBounds(82, 47, 55, 25);
		contentPane.add(txDuracao);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMin.setBounds(140, 47, 22, 25);
		contentPane.add(lblMin);
		
		cbNacionalidade = new JComboBox<String>();
		cbNacionalidade.setBounds(361, 154, 204, 25);
		contentPane.add(cbNacionalidade);
		
		cbAudio = new JComboBox<String>();
		cbAudio.setBounds(82, 120, 168, 25);
		contentPane.add(cbAudio);
		
		cbLegenda = new JComboBox<String>();
		cbLegenda.setBounds(82, 156, 168, 25);
		contentPane.add(cbLegenda);
		
		JLabel lblLegenda = new JLabel("Legenda:");
		lblLegenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLegenda.setBounds(10, 154, 57, 25);
		contentPane.add(lblLegenda);
		
		txDiretor = new JTextField();
		txDiretor.setColumns(10);
		txDiretor.setBounds(343, 47, 222, 25);
		contentPane.add(txDiretor);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 309, 555, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 11, 310, 96);
		panel.add(scrollPane);
		
		modelo.addColumn("Ator");
		modelo.addColumn("Tipo");

		tblContato = new JTable(modelo);
		scrollPane.setViewportView(tblContato);
		tblContato.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblAtor = new JLabel("Ator:");
		lblAtor.setBounds(10, 11, 57, 25);
		panel.add(lblAtor);
		lblAtor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(10, 47, 57, 25);
		panel.add(lblTipo);
		
		cbAtor = new JComboBox<Ator>();
		cbAtor.setBounds(50, 11, 175, 25);
		panel.add(cbAtor);
		
		cbTipoAtor = new JComboBox<String>();
		cbTipoAtor.setBounds(50, 47, 175, 25);
		panel.add(cbTipoAtor);
		
		btAdicionar = new JButton("");
		btAdicionar.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Create.png")));
		btAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btAdicionar.setBounds(88, 83, 35, 33);
		btAdicionar.addActionListener(new escutaBotao());
		panel.add(btAdicionar);
		
		btRemoverTabela = new JButton("");
		btRemoverTabela.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Remove.png")));
		btRemoverTabela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btRemoverTabela.setBounds(133, 83, 35, 33);
		btRemoverTabela.addActionListener(new escutaBotao());
		panel.add(btRemoverTabela);
		
		txSinopse = new JEditorPane();
		txSinopse.setBackground(Color.WHITE);
		txSinopse.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txSinopse.setBounds(82, 225, 483, 73);
		contentPane.add(txSinopse);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.GRAY);
		separator.setBounds(589, 11, 2, 416);
		contentPane.add(separator);		
		
		JLabel lblProdutora = new JLabel("Produtora:");
		lblProdutora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutora.setBounds(10, 81, 67, 25);
		contentPane.add(lblProdutora);
		
		cbProdutora = new JComboBox<String>();
		cbProdutora.setBounds(82, 83, 168, 25);
		contentPane.add(cbProdutora);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoria.setBounds(263, 81, 70, 25);
		contentPane.add(lblCategoria);
		
		cbCategoria = new JComboBox<FilmeCategoria>();
		cbCategoria.setBounds(343, 81, 222, 25);
		contentPane.add(cbCategoria);
		
		btSalvar = new JButton("  Salvar");
		btSalvar.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Save.png")));
		btSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSalvar.setBounds(624, 264, 160, 41);
		contentPane.add(btSalvar);
		btSalvar.addActionListener(new escutaBotao());
		
		btLimpar = new JButton("  Limpar");
		btLimpar.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Trash.png")));
		btLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btLimpar.setBounds(624, 368, 160, 41);
		contentPane.add(btLimpar);
		btLimpar.addActionListener(new escutaBotao());
		
		btRemover = new JButton("  Remover");
		btRemover.setIcon(new ImageIcon(CadastroFilme.class.getResource("/br/com/projeto/cinema/imagens/Close.png")));
		btRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btRemover.setBounds(624, 316, 160, 41);
		btRemover.addActionListener(new escutaBotao());
		contentPane.add(btRemover);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(172, 45, 57, 25);
		contentPane.add(lblAno);
		
		txAno = new JTextField();
		txAno.setColumns(10);
		txAno.setBounds(212, 47, 57, 25);
		contentPane.add(txAno);
				
		preencherCombos();
		limpar();
	}
	
	public void preencherFilme(Filme filme)
	{
		registro = filme;
		
		txAno.setText(filme.getAno());
		txCodigo.setText(filme.getCodigo());
		txDiretor.setText(filme.getDiretor());
		txDuracao.setText(filme.getDuracao());
		txNome.setText(filme.getTitulo());
		txSinopse.setText(filme.getSinopse());
		txTreiler.setText(filme.getTrailer());
		
		cbAudio.setSelectedItem(filme.getTipoAudio());
		cbCategoria.setSelectedItem(filme.getCategoria());
		cbClassificacaoIndicativa.setSelectedItem(filme.getClassificacaoIndicativa());
		cbLegenda.setSelectedItem(filme.getLegenda());
		cbNacionalidade.setSelectedItem(filme.getNacionalidade());
		cbProdutora.setSelectedItem(filme.getProdutora());
		
		List<Elenco> elenco = new ElencoDAO().obterElenco(filme.getPkFilme());
		registroElenco = new ArrayList<Elenco>();
		
		if(elenco!=null)
		{
			for(Elenco ele : elenco)
			{
				modelo.addRow(new Object[]{ele.getAtor(), Constantes.getTipoPalelProtagonista(ele.getTipoPapel())});
				registroElenco.add(ele);
			}
		}
	}
	
	public void preencherCombos()
	{
		cbClassificacaoIndicativa.addItem("Livre"); 
		cbClassificacaoIndicativa.addItem("Especialmente Recomendado"); 
		cbClassificacaoIndicativa.addItem("Maiores de 10 anos"); 
		cbClassificacaoIndicativa.addItem("Maiores de 12 anos"); 
		cbClassificacaoIndicativa.addItem("Maiores de 14 anos"); 
		cbClassificacaoIndicativa.addItem("Maiores de 16 anos"); 
		cbClassificacaoIndicativa.addItem("Maiores de 18 anos"); 
		
		cbNacionalidade.addItem("Nacional"); 
		cbNacionalidade.addItem("Internacional"); 	

		cbAudio.addItem("Português/Dublado"); 
		cbAudio.addItem("Inglês"); 
		cbAudio.addItem("Espanhol"); 
		
		cbLegenda.addItem("S/L");
		cbLegenda.addItem("Português");
		cbLegenda.addItem("Inglês");
		cbLegenda.addItem("Espanhol");
		
		cbProdutora.addItem("Globo Filmes");
		cbProdutora.addItem("O2 Filmes");
		cbProdutora.addItem("Zeta Filmes");
		cbProdutora.addItem("20º Century Fox");
		cbProdutora.addItem("Columbia Pictures");
		cbProdutora.addItem("Dreamworks");
		cbProdutora.addItem("Estúdio Paramount");
		cbProdutora.addItem("Estúdio Wall Disney");
		cbProdutora.addItem("Miramax Films");
		cbProdutora.addItem("Pixar");
		cbProdutora.addItem("Universal Pictures");
		cbProdutora.addItem("Warner Bros");
		
		cbTipoAtor.addItem("Protagonista");
		cbTipoAtor.addItem("Co-protagonista");
		cbTipoAtor.addItem("Antagonista");
		cbTipoAtor.addItem("Oponente");
		cbTipoAtor.addItem("Coadjuvante ");
		cbTipoAtor.addItem("Figurante");
		
		List<Ator> listAtor = new AtorDAO().obterTodos();
		
		if(listAtor!=null)
		{
			for(Ator ator : listAtor)
			{
				cbAtor.addItem(ator);
			}
		}
		
		List<FilmeCategoria> listCategoria = new FilmeCategoriaDAO().obterTodos();
		
		if(listCategoria!=null)
		{
			for(FilmeCategoria cat : listCategoria)
			{
				cbCategoria.addItem(cat);
			}
		}
	}
	
	private class escutaBotao implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{		
			if(e.getSource()==btSalvar) 			{ salvar(); 	}	
			else if(e.getSource()==btRemover) 		{ remover();	}	
			else if(e.getSource()==btLimpar)		{ limpar();		}
			else if(e.getSource()==btAdicionar)		{ adicionar();	}
			else if(e.getSource()==btRemoverTabela)	{ removerAtor();}
		}
	}
	
	public void adicionar()
	{
		if(cbAtor.getSelectedItem()!=null && cbTipoAtor.getSelectedItem()!=null)
		{
			Elenco elenco = new Elenco();
			
			elenco.setAtor((Ator) cbAtor.getSelectedItem());
			elenco.setTipoPapel(Constantes.getTipoPalelProtagonista((String) cbTipoAtor.getSelectedItem()));
			
			registroElenco.add(elenco);
			
			modelo.addRow(new Object[]{cbAtor.getSelectedItem(), cbTipoAtor.getSelectedItem()});
			
			cbAtor.setSelectedItem(null);
			cbTipoAtor.setSelectedItem(null);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione o Ator e seu Tipo para adicioná-lo no Elenco!","Erro ao adionar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void removerAtor()
	{
		if(tblContato.getSelectedRow()!=-1)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + modelo.getValueAt(tblContato.getSelectedRow(),0).toString() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) 
			{ 
				registroElenco.remove(tblContato.getSelectedRow());
				modelo.removeRow(tblContato.getSelectedRow()); 
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Selecione uma linha da tabela por favor!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	public void limpar()
	{
		registro = null;
		registroElenco = new ArrayList<Elenco>();
		
		txCodigo.setText("");
		txNome.setText("");
		txTreiler.setText("");
		txDuracao.setText("");
		txDiretor.setText("");
		txAno.setText("");
		txSinopse.setText("");
		cbProdutora.setSelectedItem(null);
		cbCategoria.setSelectedItem(null);
		cbTipoAtor.setSelectedItem(null);
		cbAtor.setSelectedItem(null);
		cbLegenda.setSelectedItem(null);
		cbAudio.setSelectedItem(null);
		cbNacionalidade.setSelectedItem(null);
		cbClassificacaoIndicativa.setSelectedItem(null);
		
		int linhas = tblContato.getRowCount();
		
		for(int i=linhas-1; i>=0; i--) { modelo.removeRow(i); }
	}
	
	public void salvar()
	{
		if(txNome.getText().length()>0 && cbCategoria.getSelectedIndex()!=-1)
		{	
			boolean tipoSalvar = false;
			
			if(registro == null) 
			{
				registro = new Filme();
				tipoSalvar = true;
			}
			
			registro.setTitulo(txNome.getText());
			registro.setAno(txAno.getText());
			registro.setCodigo(txCodigo.getText());
			registro.setDiretor(txDiretor.getText());
			registro.setDuracao(txDuracao.getText());			
			registro.setPathImagem(pathImagem);			
			registro.setSinopse(txSinopse.getText());
			registro.setTrailer(txTreiler.getText());			
			registro.setNacionalidade((String) cbNacionalidade.getSelectedItem());
			registro.setClassificacaoIndicativa((String) cbClassificacaoIndicativa.getSelectedItem());
			registro.setTipoAudio((String) cbAudio.getSelectedItem());
			registro.setLegenda((String) cbLegenda.getSelectedItem());
			registro.setProdutora((String) cbProdutora.getSelectedItem());
			registro.setCategoria((FilmeCategoria) cbCategoria.getSelectedItem());
			
			if(tipoSalvar) 	{ registro = new FilmeDAO().save(registro); 	}
			else 			{ registro = new FilmeDAO().update(registro); 	}
			
			salvarElenco();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Digite os dados corretamente!","Erro ao salvar.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	private void salvarElenco()
	{		
		if(registro.getPkFilme()!=null) { new ElencoDAO().removerForaLista(registro.getPkFilme()); }
		
		for(Elenco el : registroElenco)
		{
			el.setPkElenco(null);
			el.setFilme(registro);
			new ElencoDAO().save(el);
		}

		JOptionPane.showMessageDialog(null,"Registro salvo com sucesso!","Sucesso.",JOptionPane.INFORMATION_MESSAGE);  
	}
	
	public void remover()
	{
		if(registro!=null && registro.getPkFilme()!=null)
		{
			int valor = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o item " + registro.getTitulo() 
					+ "?", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
			if(valor==0) 
			{ 
				new FilmeDAO().delete(registro);
				limpar();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Não há nenhum registro de Filme salvo!","Erro ao excluir.",JOptionPane.INFORMATION_MESSAGE);  
		}
	}
}
